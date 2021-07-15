/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author dinht
 */
public class AccountDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Account getAcountByUserNameAndPassword(String userN, String passW) throws ClassNotFoundException, SQLException {
        Account a = null;
        try {
            String query = "select * from Account where userName = ? and passW = ?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, userN);
            ps.setString(2, passW);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String uN = rs.getString("userName");
                String pW = rs.getString("passW");
                int type = rs.getInt("type");
                String email = rs.getString("email");
                a = new Account(id, uN, pW, type, email);
            }
        } catch (ClassNotFoundException | SQLException e) {
            a = null;
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return a;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccountDAO ad = new AccountDAO();
        Account a = ad.getAcountByUserNameAndPassword("sb", "123");
        System.out.println(a.toString());
    }

    public Account getAccountByUserName(String user) throws ClassNotFoundException, SQLException {
        Account a = null;
        try {
            String query = "select * from Account where userName = ?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String uN = rs.getString("userName");
                String pW = rs.getString("passW");
                int type = rs.getInt("type");
                String email = rs.getString("email");
                a = new Account(id, uN, pW, type, email);
            }
        } catch (ClassNotFoundException | SQLException e) {
            a = null;
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return a;
    }

    public Account getAccountByEmail(String mail) throws ClassNotFoundException, SQLException {
        Account a = null;
        try {
            String query = "select * from Account where email =?";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, mail);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String uN = rs.getString("userName");
                String pW = rs.getString("passW");
                int type = rs.getInt("type");
                String email = rs.getString("email");
                a = new Account(id, uN, pW, type, email);
            }
        } catch (ClassNotFoundException | SQLException e) {
            a = null;
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return a;
    }

    public boolean insertAccount(Account a) throws ClassNotFoundException, SQLException {
        if (a == null) {
            return false;
        }
        try {
            String query = "insert into Account\n"
                    + "values(?,?,?,?)";
            ps = getConnection().prepareStatement(query);
            ps.setString(1, a.getUserName());
            ps.setString(2, a.getPassWord());
            ps.setInt(3, a.getType());
            ps.setString(4, a.getEmail());
            ps.execute();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            getConnection().rollback();
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return false;
    }

}
