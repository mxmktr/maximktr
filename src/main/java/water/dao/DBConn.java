package water.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by steve on 11/17/15.
 */
public class DBConn {

    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@10.20.0.27:1521:sstdemo";
    private static final String LOGIN = "rkc#sst";
    private static final String PASSWORD = "sst4libra";
    private Connection conn = null;

    public DBConn(){

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConn(){
        try {
            if (!conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
