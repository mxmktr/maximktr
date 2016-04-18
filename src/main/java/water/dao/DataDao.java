package water.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by steve on 11/17/15.
 */
public class DataDao {

    public DataDao() {
    }

    public int insertPltvVodAcc(List<String> listLSC){

        DBConn dbConn = new DBConn();
        Connection connection = dbConn.getConn();
        String query = "INSERT INTO TPMNT_PLTV_VOD_ACC_MAX VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            String[] dataLSC;
            for (String element: listLSC) {
                dataLSC = element.split("\\|");
                ps.setString(1, dataLSC[1]);
                ps.setString(2, dataLSC[3]);
                ps.setString(3, dataLSC[4]);
                ps.setString(4, dataLSC[5]);
                ps.setString(5, dataLSC[6]);
                ps.setString(6, dataLSC[7]);
                ps.setString(7, dataLSC[8]);
                ps.setString(8, dataLSC[9]);
                ps.setString(9, dataLSC[10]);
                ps.setDouble(10, Double.parseDouble(dataLSC[11]));
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public int insertPltvServAcc(List<String> listLSC){
        DBConn connection = new DBConn();
        Connection conn = connection.getConn();

        String query = "INSERT INTO TPMNT_PLTV_VOD_SERV_ACC_MAX VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);

            String[] dataService;
            ps = conn.prepareStatement(query);
            for (String element: listLSC){
                dataService = element.split("\\|");
                int j = 13;
                for (int i = 0; i < Integer.parseInt(dataService[12]); i++) {
                    ps.setString(1, dataService[1]);
                    ps.setDouble(2, Double.parseDouble(dataService[j++]));
                    ps.setDouble(3, Double.parseDouble(dataService[j++]));
                    ps.setDouble(4, Double.parseDouble(dataService[j++]));
                    ps.setDouble(5, Double.parseDouble(dataService[j++]));
                    ps.setDouble(6, Double.parseDouble(dataService[j++]));
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    public int insertPltvVodCounter(List<String> listVDM){
        DBConn dbConn = new DBConn();
        Connection connection = dbConn.getConn();
        String query = "INSERT INTO TPMNT_PLTV_VOD_COUNTER_MAX VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            String[] dataVDM;
            for (String element: listVDM) {
                dataVDM = element.split("\\|");
                int j = 11;
                for (int i = 0; i < Integer.parseInt(dataVDM[10]); i++) {
                    ps.setString(1, dataVDM[1]);
                    ps.setString(2, dataVDM[j]);
                    ps.setString(3, dataVDM[j++]);
                    ps.setString(4, dataVDM[j++]);
                    ps.setString(5, dataVDM[j++]);
                    ps.setString(6, dataVDM[j++]);
                    ps.setString(7, dataVDM[j++]);
                    ps.setDouble(8, Double.parseDouble(dataVDM[j++]));
                    ps.addBatch();
                }
            }
            ps.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

}
