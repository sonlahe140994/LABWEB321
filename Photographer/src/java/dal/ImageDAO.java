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
import model.Image;

/**
 *
 * @author dinht
 */
public class ImageDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Image> getImageByGalleryId(String galleryId) throws ClassNotFoundException, SQLException {
        ArrayList<Image> list = new ArrayList<>();
        String query = "select * from [image] where ga_id like '" + galleryId.trim() + "'";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int imgId = rs.getInt(1);
                String gaId = rs.getString(2);
                String imgUrl = rs.getString(3);
                list.add(new Image(imgId, gaId, imgUrl));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }

    public String getTop1UrlImageByGalleryId(String galleryId) throws ClassNotFoundException, SQLException {
        String query = "select top 1 i.img_url from [image] i left join gallery g on i.ga_id=g.ga_id "
                + "where g.ga_id like ? order by img_id desc";
        String url = "";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, galleryId.trim());
            rs = ps.executeQuery();
            if (rs.next()) {
                url += rs.getString(1);
            }
        } catch (ClassNotFoundException | SQLException e) {
            url = "";
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return url;
    }

    public Image getTop1Image() throws ClassNotFoundException, SQLException {
        Image i = null;
        String query = "select top 1 * from [image] order by img_id desc";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                int imgId = rs.getInt(1);
                String gaId = rs.getString(2);
                String imgUrl = rs.getString(3);
                i = new Image(imgId, gaId, imgUrl);
            }
        } catch (ClassNotFoundException | SQLException e) {
            i = null;
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return i;
    }

    public ArrayList<Image> getArrayBetween(ArrayList<Image> listImg, int start, int end) {
        if (listImg.size() < end) {
            end = listImg.size() - 1;
        }
        ArrayList<Image> listBe = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i != listImg.size()) {
                listBe.add(listImg.get(i));
            }

        }
        return listBe;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ImageDAO id = new ImageDAO();
        ArrayList<Image> l = id.getImageByGalleryId("GA2");

        int sizePage = l.size() / 4;
        if (l.size() % 4 != 0) {
            sizePage++;
        }
        int start = 0;
        int end = 3;
        if (l.size() < 4) {
            end = l.size();
        }
        System.out.println("List Size: " + l.size());
        for (int i = 1; i <= sizePage; i++) {
            ArrayList<Image> lImg = id.getArrayBetween(l, start, end);
            for (Image a : lImg) {
                System.out.println(a.toString());
            }
            start = end + 1;
            end += 4;
            System.out.println("-----------------------------");
        }
    }

    public Image getImageByUrl(String url) throws ClassNotFoundException, SQLException {
        Image i = null;
        String query = "select * from [image] where img_url like ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, url);
            rs = ps.executeQuery();
            if (rs.next()) {
                int imgId = rs.getInt(1);
                String gaId = rs.getString(2);
                String imgUrl = rs.getString(3);
                i = new Image(imgId, gaId, imgUrl);
            }
        } catch (ClassNotFoundException | SQLException e) {
            i = null;
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return i;
    }
}
