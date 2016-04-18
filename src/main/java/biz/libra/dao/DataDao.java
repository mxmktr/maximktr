package biz.libra.dao;

import biz.libra.date.WorkWithDate;
import biz.libra.model.CashTableData;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by steve on 11/17/15.
 */
public class DataDao {

    private String termId = null;

    public DataDao(String termId) {
        this.termId = termId;
    }

    public String getBankName() {

        String request = "SELECT tb.NAME FROM Term tr, TFIID tf, TBANK tb where tr.TERMID = '" + termId + "' and tr.FIID = tf.FIID and  tf.BANK = tb.BANK";
        String bankName = null;

        DBConn dbConn = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            dbConn = new DBConn();
            connection = dbConn.getConn();
            ps = connection.prepareStatement(request);
            rs = ps.executeQuery();
            while (rs.next()) {
                bankName = rs.getString("NAME");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bankName;
    }

    public String getTermAddress() {
        String termAddress = null;
        String query = "SELECT tm.KIOSKHADCHECK3 FROM TERM tm WHERE tm.TERMID = ?";

        DBConn dbConn = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            dbConn = new DBConn();
            connection = dbConn.getConn();
            ps = connection.prepareStatement(query);
            ps.setString(1, termId);
            rs = ps.executeQuery();
            while (rs.next()) {
                termAddress = rs.getString("KIOSKHADCHECK3");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return termAddress;
    }

    public String getCollectorCard() {
        String PAN = null;
        String query = "SELECT tc.PAN from TCOLLECTOR tc, TCOLLECTORACCESS tca WHERE tca.TERMID = ? and tc.COLLECTORID = tca.COLLECTORID";

        DBConn dbConn = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            dbConn = new DBConn();
            connection = dbConn.getConn();
            ps = connection.prepareStatement(query);
            ps.setString(1, termId);
            rs = ps.executeQuery();
            while (rs.next()) {
                PAN = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return PAN.substring(0, 4) + "########" + PAN.substring(12) ;
    }

    public Date[] getLastEncashmentDateByTerm(){
        Timestamp[] date = new Timestamp[2];
        String query = "Select CREATEDATE from (SELECT ROW_NUMBER () OVER (order BY tr.CREATEDATE desc) as daterow, tr.CREATEDATE FROM TRAN tr " +
                "where tr.TERM_ID = '" + termId + "' and tr.TERM_CONFIRM = 1 and tr.SERVICE_CODE like 'ENCAS%') " +
                "where daterow in (1, 2)";
        DBConn conn = new DBConn();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()){
                date[i] = rs.getTimestamp(1);
                i--;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    public List<CashTableData> getTableData(Date startOfTran, Date endOfTran){

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        String start = sdf.format(startOfTran);
        String end = sdf.format(endOfTran);

        String query = "select ts.CASH_SYMBOL , count(tr.TRANID) as quantity, SUM(tr.TERM_TRANVALUE) as sumOfTran FROM TRAN tr, TSERVICE ts " +
                "  where tr.TERM_ID = '" + termId + "' " +
                "    and tr.SERVICE_ID = ts.SERVICE_ID" +
                "    and tr.SERVICE_ID <> 243" +
                "    and tr.TERM_CONFIRM = 1" +
                "    and tr.TRAN_STATUS = 'TOEXTRACT'" +
                "    and tr.CREATEDATE BETWEEN TO_DATE('" + start + "', 'dd.mm.YY HH24:mi:ss') AND TO_DATE('" + end + "', 'dd.mm.YY HH24:mi:ss')" +
                "    GROUP BY ts.CASH_SYMBOL";
        DBConn conn = new DBConn();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<CashTableData> list = new ArrayList<CashTableData>(20);
        try {
            connection = conn.getConn();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                CashTableData line = new CashTableData();
                line.setCashSymbol(rs.getString("CASH_SYMBOL"));
                line.setCountOfTran(rs.getInt("quantity"));
                line.setSumOfTran(rs.getDouble("sumOfTran"));
                list.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {

        DataDao data = new DataDao("S0183544");
        Date[] date = data.getLastEncashmentDateByTerm();

        Date[][] intervals = WorkWithDate.getTimeIntervals(date);

        List<? extends Object> list = data.getTableData(intervals[1][0], intervals[1][1]);
        System.out.println(list);

    }
}
