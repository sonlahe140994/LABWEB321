/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Contact;

/**
 *
 * @author dinht
 */
public class ContactDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Contact getContact() {
        Contact c = null;
        String query = "select top 1 *from contact";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString(1);
                String address = rs.getString(2);
                String city = rs.getString(3);
                String country = rs.getString(4);
                String tel = rs.getString(5);
                String email = rs.getString(6);
                String mapUrl = rs.getString(7);
                String faceUrl = rs.getString(8);
                String twitterUrl = rs.getString(9);
                String googleUrl = rs.getString(10);
                String about = rs.getString(11);
                c = new Contact(name, address, city, country, tel, email, mapUrl, faceUrl, twitterUrl, googleUrl, about);
            }
        } catch (ClassNotFoundException | SQLException e) {
            c = null;
        }
        return c;
    }

    public static void main(String[] args) {
        ContactDAO cd = new ContactDAO();
        Contact c = cd.getContact();
        System.out.println(c.toString() + "|" + c.getAboutContact());
    }
}
