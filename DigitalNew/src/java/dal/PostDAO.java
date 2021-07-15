/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
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
    Connection con;

    public ArrayList<Post> getPostByAuId(int id) throws ClassNotFoundException, SQLException {
        ArrayList<Post> l = new ArrayList<>();
        String query = "select top 5 p.idPost,p.titlePost,p.descript,p.img,a.authorName,p.timePost,p.shortDes \n"
                + "from Post p join Author a on p.author = a.authorId where p.author =" + id;
        try {
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int idPost = rs.getInt("idPost");
                String titlePost = rs.getString("titlePost");
                String decript = rs.getString("descript");
                String img = rs.getString("img");
                String author = rs.getString("authorName");
                Date date = rs.getDate("timePost");
                String shortDes = rs.getString("shortDes");
                Post p = new Post(idPost, titlePost, decript, img, author, date, shortDes);
                l.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            l.clear();
        } finally {
            closeConnection(rs, st, getConnection());
        }
        return l;
    }

    public Post getPostById(int id) throws ClassNotFoundException, SQLException {
        Post p = null;
        try {
            String query = "select p.idPost,p.titlePost,p.descript,p.img,a.authorName,p.timePost,p.shortDes \n"
                    + "from Post p join Author a on p.author = a.authorId\n"
                    + "where p.idPost = " + id;
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int idPost = rs.getInt("idPost");
                String titlePost = rs.getString("titlePost");
                String decript = rs.getString("descript");
                String img = rs.getString("img");
                String author = rs.getString("authorName");
                Date date = rs.getDate("timePost");
                String shortDes = rs.getString("shortDes");
                p = new Post(idPost, titlePost, decript, img, author, date, shortDes);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            p = null;
        } finally {
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
        ArrayList<Post> l = pd.getPostByAuId(1);
        for (Post i : l) {
            System.out.println(i.toString());
        }
    }

    public Post getMostRecentNews() throws ClassNotFoundException, SQLException {
        Post p = null;
        try {
            String query = "select top 1 p.idPost,p.titlePost,p.descript,p.img,a.authorName,p.timePost,p.shortDes from Post p join Author a on p.author = a.authorId";
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                int id = rs.getInt("idPost");
                String titlePost = rs.getString("titlePost");
                String decript = rs.getString("descript");
                String img = rs.getString("img");
                String author = rs.getString("authorName");
                Date date = rs.getDate("timePost");
                String shortDes = rs.getString("shortDes");
                p = new Post(id, titlePost, decript, img, author, date, shortDes);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
            p = null;
        }
        return p;
    }

    public ArrayList<Post> getLastArticle() throws ClassNotFoundException, SQLException {
        ArrayList<Post> listPost = new ArrayList<>();
        try {
            String query = "select top 5 p.idPost,p.titlePost,p.descript,p.img,a.authorName,p.timePost,p.shortDes \n"
                    + "from Post p join Author a on p.author = a.authorId order by p.timePost desc";
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idPost");
                String titlePost = rs.getString("titlePost");
                String decript = rs.getString("descript");
                String img = rs.getString("img");
                String author = rs.getString("authorName");
                Date date = rs.getDate("timePost");
                String shortDes = rs.getString("shortDes");
                Post p = new Post(id, titlePost, decript, img, author, date, shortDes);
                listPost.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listPost.clear();
        } finally {
            closeConnection(rs, st, getConnection());
        }
        return listPost;
    }

    public ArrayList<Post> getSearchListPost(String searchString) throws ClassNotFoundException, SQLException {
        ArrayList<Post> listPost = new ArrayList<>();
        try {
            String query = "select * from Post where titlePost like N'%" + searchString + "%'";
            con = getConnection();
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idPost");
                String titlePost = rs.getString("titlePost");
                String decript = rs.getString("descript");
                String img = rs.getString("img");
                String author = rs.getString("authorName");
                Date date = rs.getDate("timePost");
                String shortDes = rs.getString("shortDes");
                Post p = new Post(id, titlePost, decript, img, author, date, shortDes);
                listPost.add(p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listPost.clear();
        } finally {
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
