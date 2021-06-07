/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Post;

/**
 *
 * @author dinht
 */
public class PostDAO extends DBContext {

    Statement st;
    ResultSet rs;

    public Post getPostById(int id) throws ClassNotFoundException, SQLException {
        Post p = null;
        try {
            String query = "select * from Post where idPost = " + id;
            st = getConnection().createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                int idPost = rs.getInt(1);
                String titlePost = rs.getString(2);
                String descriptPost = rs.getString(3);
                String imgPost = rs.getString(4);
                String authorPost = rs.getString(5);
                Date timePost = rs.getDate(6);
                String shortDes = rs.getString(7);
                p = new Post(idPost, titlePost, descriptPost, imgPost, authorPost, praseDate(timePost), shortDes);
            }
            closeConnection(rs, st, getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            p = null;
            closeConnection(rs, st, getConnection());
        }

        return p;
    }

    public java.util.Date praseDate(java.sql.Date timePst) {
        try {
            java.util.Date d = new java.util.Date(timePst.getTime());
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PostDAO pd = new PostDAO();
        ArrayList<Post> p = pd.getSearchListPost("i");
        if (p != null) {
            for (Post pos : p) {
                System.out.println(pos.getIdPost());
            }
        }
        int index = 4;
        int start = 0, end = 0;
        if (p.size() <= 2) {
            start = 0;
            end = p.size();
        } else {
            start = (index - 1) * 2;
            if (start == p.size() - 1) {
                end = p.size();
            } else {
                end = start + 2;
            }
        }
        System.out.println(start + " | " + end);
        System.out.println("-------------------");
        ArrayList<Post> l = pd.getListPostBetween(p, start, end);
        for (Post pos : l) {
            System.out.println(pos.getIdPost());
        }

    }

    public Post getMostRecentNews() throws ClassNotFoundException, SQLException {
        Post p = null;
        try {
            String query = "select top 1 * from Post order by timePost desc";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                int idPost = rs.getInt(1);
                String titlePost = rs.getString(2);
                String descriptPost = rs.getString(3);
                String imgPost = rs.getString(4);
                String authorPost = rs.getString(5);
                Date timePost
                        = rs.getDate(6);
                String shortDes = rs.getString(7);
                p = new Post(idPost, titlePost, descriptPost, imgPost, authorPost, praseDate(timePost), shortDes);
            }
            closeConnection(rs, st, getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            p = null;
            closeConnection(rs, st, getConnection());
        }

        return p;
    }

    public ArrayList<Post> getLastArticle() throws ClassNotFoundException, SQLException {
        ArrayList<Post> listPost = new ArrayList<>();
        try {
            String query = "select top 5 * from Post order by timePost desc";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String titlePost = rs.getString(2);
                String descriptPost = rs.getString(3);
                String imgPost = rs.getString(4);
                String authorPost = rs.getString(5);
                Date timePost = rs.getDate(6);
                String shortDes = rs.getString(7);
                Post p = new Post(idPost, titlePost, descriptPost, imgPost, authorPost, praseDate(timePost), shortDes);
                listPost.add(p);
            }
            closeConnection(rs, st, getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            listPost = null;
            closeConnection(rs, st, getConnection());
        }
        return listPost;
    }

    public ArrayList<Post> getSearchListPost(String searchString) throws ClassNotFoundException, SQLException {
        ArrayList<Post> listPost = new ArrayList<>();
        try {
            String query = "select * from Post where titlePost like '%" + searchString.trim() + "%' order by timePost desc";
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String titlePost = rs.getString(2);
                String descriptPost = rs.getString(3);
                String imgPost = rs.getString(4);
                String authorPost = rs.getString(5);
                Date timePost = rs.getDate(6);
                String shortDes = rs.getString(7);
                Post p = new Post(idPost, titlePost, descriptPost, imgPost, authorPost, praseDate(timePost), shortDes);
                listPost.add(p);
            }
            closeConnection(rs, st, getConnection());
        } catch (ClassNotFoundException | SQLException e) {
            listPost = null;
            closeConnection(rs, st, getConnection());
        }
        return listPost;
    }

    public ArrayList<Post> getListPostBetween(ArrayList<Post> listPost, int start, int last) {
        ArrayList<Post> listBtw = new ArrayList<>();
        if (listPost == null) {
            return null;
        }
        for (int i = start; i < last; i++) {
            listBtw.add(listPost.get(i));
        }
        return listBtw;
    }
}
