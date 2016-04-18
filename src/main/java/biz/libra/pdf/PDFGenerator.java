package biz.libra.pdf;

import biz.libra.dao.DataDao;
import biz.libra.date.WorkWithDate;
import biz.libra.model.CashTableData;
import biz.libra.model.Result;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by steve on 11/17/15.
 */
public class PDFGenerator {

    private BaseFont bf;
    private static final String PATTERN = "#0.00";
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    private DataDao dataDao;
    private String termId;

    public PDFGenerator(String termId) {
        this.termId = termId;

        dataDao = new DataDao(termId);
        try {
            bf = BaseFont.createFont("/home/steve/IdeaProjects/Max/src/main/resources/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String genPDFReportL002() {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        Date[][] intervals = WorkWithDate.getTimeIntervals(dataDao.getLastEncashmentDateByTerm());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");

        try {
            PdfWriter.getInstance(document, new FileOutputStream("/home/steve/Max/work/Poltava/" + dateFormat.format(new Date()) + termId + ".pdf"));
            document.open();
            document.add(getChapter());

            Paragraph paragraph = new Paragraph();
            paragraph.setSpacingAfter(25);
            paragraph.add(getPhrase(intervals[0][0], intervals[1][1]));
            document.add(paragraph);

            PdfPTable table = getTableTemplateI001();
            document.add(table);

            changeHeader(document, table, "До дня інкасації ( " + sdf.format(intervals[0][1]) + " )");
            Result res = fillTable(document, table, termId, intervals[0][0], intervals[0][1]);
            changeHeader(document, table, "День інкасації ( " + sdf.format(intervals[1][1]) + " )");
            Result resFinal = fillTable(document, table, termId, intervals[1][0], intervals[1][1]);
            resFinal.add(res);

            fillTableTotal(document, table, resFinal);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return null;
    }

    public Chapter getChapter() {

        Paragraph title = new Paragraph("I002 Операції з готівкою", new Font(bf, 16, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(20);
        Chapter chapter = new Chapter(title, 1);
        chapter.setNumberDepth(0);

        return chapter;
    }

    public Phrase getPhrase(Date start, Date end){
        Font font = new Font(bf, 12, Font.NORMAL, BaseColor.DARK_GRAY);

        Phrase phrase = new Phrase();
        phrase.setFont(font);

        phrase.add("За інкасаційний період з " + sdf.format(start) + " по " + sdf.format(end) + "\n");
        phrase.add("LIBRA-PAY\n");
        phrase.add(dataDao.getBankName() + "\n");
        phrase.add("термінал самообслуговування   ");
        phrase.setFont(new Font(bf, 12, Font.BOLD, BaseColor.BLACK));
        phrase.add(termId + "\n");
        phrase.setFont(font);
        phrase.add(dataDao.getTermAddress() + "\n");
        phrase.add("Карта інкасатора:  ");
        phrase.setFont(new Font(bf, 12, Font.BOLD, BaseColor.BLACK));
        phrase.add(dataDao.getCollectorCard());

        return phrase;
    }

    public PdfPTable getTableTemplateI001() {
        PdfPTable table = new PdfPTable(3);

        table.setWidthPercentage(100);
        table.getDefaultCell().setMinimumHeight(20);

        table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        table.addCell(new Paragraph("СКП", new Font(bf, 14, Font.BOLD)));
        table.addCell(new Paragraph("Кількість", new Font(bf, 14, Font.BOLD)));
        table.addCell(new Paragraph("Сума готівки", new Font(bf, 14, Font.BOLD)));

        table.getDefaultCell().setBackgroundColor(null);

        return table;
    }

    public void changeHeader(Document document, PdfPTable table, String text) {
        table.deleteBodyRows();
        table.resetColumnCount(1);
        table.addCell(new Paragraph(text, new Font(bf, 12, Font.NORMAL, BaseColor.DARK_GRAY)));
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Result fillTable(Document document, PdfPTable table, String termId, Date start, Date end) {
        table.deleteBodyRows();
        table.resetColumnCount(3);

        int totalCount = 0;
        double totalSum = 0;

        DecimalFormat df = new DecimalFormat(PATTERN);
        df.setRoundingMode(RoundingMode.HALF_UP);

        Font fontNorm = new Font(bf, 12, Font.NORMAL, BaseColor.DARK_GRAY);
        Font fontBold = new Font(bf, 12, Font.BOLD, BaseColor.DARK_GRAY);

        List<CashTableData> list = dataDao.getTableData(start, end);
        if (list.size() != 0) {
            for (CashTableData elem : list) {
                table.addCell(new Paragraph(elem.getCashSymbol(), fontNorm));
                table.addCell(new Paragraph(new Integer(elem.getCountOfTran()).toString(), fontNorm));
                table.addCell(new Paragraph(df.format(elem.getSumOfTran()), fontNorm));

                totalCount += elem.getCountOfTran();
                totalSum += elem.getSumOfTran();
            }

            table.addCell(new Paragraph("Итого:", fontBold));
            table.addCell(new Paragraph(new Integer(totalCount).toString(), fontBold));
            table.addCell(new Paragraph(df.format(totalSum), fontBold));

        } else {
            table.addCell(new Paragraph("Итого:", fontBold));
            table.addCell(new Paragraph(new Integer(0).toString(), fontBold));
            table.addCell(new Paragraph(df.format(0), fontBold));
        }
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new Result(totalCount, totalSum);
    }

    public void fillTableTotal(Document document, PdfPTable table, Result result) {
        table.deleteBodyRows();
        table.resetColumnCount(3);

        DecimalFormat df = new DecimalFormat(PATTERN);
        df.setRoundingMode(RoundingMode.HALF_UP);

        Font fontBold = new Font(bf, 14, Font.BOLD, BaseColor.DARK_GRAY);

        table.addCell(new Paragraph("Всього:", fontBold));
        table.addCell(new Paragraph(new Integer(result.getCount()).toString(), fontBold));
        table.addCell(new Paragraph(df.format(result.getSumm()), fontBold));
        try {
            document.add(table);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
