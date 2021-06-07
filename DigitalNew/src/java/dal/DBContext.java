package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dinht
 */
public class DBContext {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // Edit URL , username, password to authenticate with your MS SQL Server
        String url = "jdbc:sqlserver://DESKTOP-MHUN32P:1433;databaseName=Digital;";
        String userName = "sa";
        String passWord = "123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userName, passWord);
    }

    public void closeConnection(ResultSet rs, Statement st, Connection con) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (st != null && !st.isClosed()) {
            st.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBContext t = new DBContext();
        if (t.getConnection() != null) {
            System.out.println("win");
        } else {
            System.out.println("Lose");
        }
    }

}
