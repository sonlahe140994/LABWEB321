/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Author;

/**
 *
 * @author dinht
 */
public class AuthorDAO extends DBContext {

    Statement st;
    ResultSet rs;
    Connection con;

    public ArrayList<Author> getAllAuthor() {
        ArrayList<Author> list = new ArrayList<>();
        try {
            String query = "select * from Author";
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("authorId");
                String name = rs.getString("authorName");
                Author a = new Author(id, name);
                list.add(a);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        AuthorDAO ad = new AuthorDAO();
        ArrayList<Author> list = ad.getAllAuthor();
        for (Author i : list) {
            System.out.println(i.getAuName());
        }
    }
}
