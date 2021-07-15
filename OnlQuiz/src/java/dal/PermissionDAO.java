/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Permission;

/**
 *
 * @author dinht
 */
public class PermissionDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Permission> getAllPermission() throws ClassNotFoundException, SQLException {
        ArrayList<Permission> listPer = new ArrayList<>();
        try {
            String query = "select * from TypePermission";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Permission p = new Permission(id, name);
                listPer.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            listPer.clear();
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return listPer;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PermissionDAO pd = new PermissionDAO();
        ArrayList<Permission> l = pd.getAllPermission();
        for (Permission p : l) {
            System.out.println(p.toString());
        }
    }
}
