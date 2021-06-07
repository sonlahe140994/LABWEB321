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
import model.Gallery;

/**
 *
 * @author dinht
 */
public class GalleryDAO extends DBContext {
    
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList<Gallery> getAllGallery() throws ClassNotFoundException, SQLException {
        ArrayList<Gallery> list = new ArrayList<>();
        String query = "select * from gallery";
        try {
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                String gaId = rs.getString(1);
                String gaTitle = rs.getString(2);
                String gaDes = rs.getString(3);
                list.add(new Gallery(gaId, gaTitle, gaDes));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        GalleryDAO gd = new GalleryDAO();
        ArrayList<Gallery> list = gd.getAllGallery();
//        list.add(new Gallery("Alo7", "Test", "TestThoi"));
//        list.add(new Gallery("Alo8", "Test", "TestThoi"));
//        list.add(new Gallery("Alo9", "Test", "TestThoi"));
//        list.add(new Gallery("Alo10", "Test", "TestThoi"));
//        list.add(new Gallery("Alo11", "Test", "TestThoi"));
//        list.add(new Gallery("Alo12", "Test", "TestThoi"));
//        list.add(new Gallery("Alo12", "Test", "TestThoi"));
//        list.add(new Gallery("Alo12", "Test", "TestThoi"));
//        list.add(new Gallery("Alo12", "Test", "TestThoi"));
        list.remove(list.size() - 1);
        list.remove(list.size() - 2);
        list.remove(list.size() - 3);

        int i = 0;
        for (Gallery g2 : list) {
            System.out.println("Index " + i + ": " + g2.getGalleryId());
            i++;
        }
        int index = 1;
        int pageSize = list.size() / 4;
        if (list.size() % 4 != 0) {
            pageSize++;
        }
        int start = 0;
        int end = 0;
        start = (index - 1) * 4;
        if (list.size() < 4) {
            System.out.println("List Size <4");
            end = list.size();
        } else {
            end = start + 3;
            if (end >= list.size()) {
                System.out.println("end > list size");
                end = list.size() - 1;
            }
        }
        System.out.println("Page Size: " + pageSize);
        System.out.println("ListSize: " + list.size());
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        System.out.println("List Sub");
        ArrayList<Gallery> listBet = gd.getArrayBetween(list, start, end);
        for (Gallery g : listBet) {
            System.out.println(g.getGalleryId());
        }
        
    }
    
    public Gallery getGalleryById(String gaId) throws ClassNotFoundException, SQLException {
        Gallery g = null;
        String query = "select * from gallery where ga_id like ?";
        try {
            ps = getConnection().prepareStatement(query);
            ps.setString(1, gaId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String galleryId = rs.getString(1);
                String gaTitle = rs.getString(2);
                String gaDes = rs.getString(3);
                g = new Gallery(galleryId, gaTitle, gaDes);
            }
        } catch (ClassNotFoundException | SQLException e) {
            g = null;
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return g;
    }
    
    public ArrayList<Gallery> getArrayBetween(ArrayList<Gallery> listGa, int start, int end) {
        ArrayList<Gallery> listBet = new ArrayList<>();
        if (listGa.size() < end) {
            end = listGa.size() - 1;
        }
        for (int i = start; i <= end; i++) {
            listBet.add(listGa.get(i));
        }
        return listBet;
    }
}
