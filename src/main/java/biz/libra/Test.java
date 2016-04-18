package biz.libra;

import biz.libra.pdf.PDFGenerator;

/**
 * Created by steve on 11/30/15.
 */
public class Test {
    public static void main(String[] args) {

        PDFGenerator gen = new PDFGenerator("S0183544");
        gen.genPDFReportL002();

    }

}
