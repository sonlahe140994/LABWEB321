/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dinht
 */
public class DBContext {

    public Connection getConnection() throws ClassNotFoundException, SQLException {

        // Edit URL , username, password to authenticate with your MS SQL Server
        String url = "jdbc:sqlserver://DESKTOP-MHUN32P:1433;databaseName=Photographer;";
        String username = "sa";
        String password = "123";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }

    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
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
