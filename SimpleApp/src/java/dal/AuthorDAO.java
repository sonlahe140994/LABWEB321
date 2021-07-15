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
import model.Author;

/**
 *
 * @author dinht
 */
public class AuthorDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Author getAuthorById(int id) throws ClassNotFoundException, SQLException {
        Author au = null;
        try {
            String query = "select * from Author where author_id = ?;";
            ps = getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                int authorId = rs.getInt("author_id");
                String imgUrl = rs.getString("img_url");
                String authorName = rs.getString("author_name");
                String nameConcept = rs.getString("name_concept");
                au = new Author(authorId, imgUrl, authorName, nameConcept);
            }
        } catch (ClassNotFoundException | SQLException e) {
            au = null;
        }finally {
            closeConnection(getConnection(), ps, rs);
        }
        return au;
    }

    public ArrayList<Author> getAllAuthor() throws ClassNotFoundException, SQLException {
        ArrayList<Author> list = new ArrayList<>();
        try {
            String query = "select * from  Author";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int conceptId = rs.getInt("author_id");
                String imgUrl = rs.getString("img_url");
                String authorName = rs.getString("author_name");
                String nameConcept = rs.getString("name_concept");
                list.add(new Author(conceptId, imgUrl, authorName, nameConcept));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AuthorDAO ad = new AuthorDAO();
        ArrayList<Author> list = ad.getAllAuthor();
        for (Author a : list) {
            System.out.println(a.toString());
        }
    }
}
