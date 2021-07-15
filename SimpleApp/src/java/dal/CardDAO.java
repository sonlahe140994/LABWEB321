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
import model.Card;

/**
 *
 * @author dinht
 */
public class CardDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Card> getAllCard() throws ClassNotFoundException, SQLException {
        ArrayList<Card> list = new ArrayList<>();
        try {
            String query = "select * from [Card]";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cardId = rs.getInt("id");
                String fromUrl = rs.getString("from_url");
                String fromLogoUrl = rs.getString("from_logo_url");
                String title = rs.getString("title");
                String des = rs.getString("des");
                String imgMain = rs.getString("img_main");
                int numPin = rs.getInt("num_pin");
                int numLike = rs.getInt("num_like");
                String expandPinUrl = rs.getString("expandpin_url");
                String urlHome = rs.getString("urlhome_img");
                int authorId = rs.getInt("author_id");
                int conceptId = rs.getInt("concept_id");
                list.add(new Card(cardId, fromUrl, fromLogoUrl, title, des, imgMain, numPin, numLike, expandPinUrl, urlHome, authorId, conceptId));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
            System.out.println(e.getMessage());
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }

    public ArrayList<Card> getTop10Card() throws ClassNotFoundException, SQLException {
        ArrayList<Card> list = new ArrayList<>();
        try {
            String query = "  select top (10)* from [Card]";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int cardId = rs.getInt("id");
                String fromUrl = rs.getString("from_url");
                String fromLogoUrl = rs.getString("from_logo_url");
                String title = rs.getString("title");
                String des = rs.getString("des");
                String imgMain = rs.getString("img_main");
                int numPin = rs.getInt("num_pin");
                int numLike = rs.getInt("num_like");
                String expandPinUrl = rs.getString("expandpin_url");
                String urlHome = rs.getString("urlhome_img");
                int authorId = rs.getInt("author_id");
                int conceptId = rs.getInt("concept_id");
                list.add(new Card(cardId, fromUrl, fromLogoUrl, title, des, imgMain, numPin, numLike, expandPinUrl, urlHome, authorId, conceptId));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
            System.out.println(e.getMessage());
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }

    public ArrayList<Card> getListCardFrom(ArrayList<Card> listCard, int index, int sizeOfArr) {
        ArrayList<Card> listSplit = new ArrayList<>();
        try {
            for (int i = index; i < sizeOfArr; i++) {
                if (listCard.get(i) != null) {
                    listSplit.add(listCard.get(i));
                }
            }
        } catch (Exception e) {
        }
        return listSplit;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        CardDAO cd = new CardDAO();
//        ArrayList<Card> list = cd.getAllCard();
//        list.remove(list.size() - 1);
//        Card c = new Card(4, "1", "A", "A", "a", "A", 1, 0, "A", "A", 0, 0);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);
//        list.add(c);

//        int listSize = list.size();
//        int numOfCol = 5;
//        if (listSize < numOfCol) {
//            System.out.println("ListSize: " + listSize);
//        }
//        int sizeOfCol = listSize / numOfCol;
//
//        int startCo = (5 - 1) * sizeOfCol;
//        int endCo = startCo + sizeOfCol;
//        if (listSize <= endCo) {
//            endCo = listSize - 1;
//        }
//        int listSize = 25;
//        int sizeOfCol = listSize / 5;
//
//        int startColumn = (5 - 1) * sizeOfCol;
//
//        System.out.println("ListSize: " + listSize);
//        System.out.println("Size Of Ever Column " + sizeOfCol);
//        System.out.println("Index of Column: " + startColumn);
//        System.out.println("------------------------------------");
//        System.out.println("list size: " + listSize);
//        System.out.println("startCo " + startCo);
//        System.out.println("sizeOfCol " + sizeOfCol);
//        ArrayList<Card> l = cd.getListCardFrom(list, startCo, endCo);
        CardDAO cd = new CardDAO();
        ArrayList<Card> listCard = cd.getAllCard();

//        listCard.remove(listCard.size() - 1);
//        listCard.remove(listCard.size() - 1);
        System.out.println("List Size: " + listCard.size());
        for (Card card : listCard) {
            System.out.println(card.getId());
        }

        System.out.println("-------------------------");
        int sizeOfList = listCard.size();
        int numOfCol = 5;
        //if the size of list is less than the number of column then 
        //will having number of column equals with the list size(1 row in page)
        if (sizeOfList < 5) {
            numOfCol = sizeOfList;
        }
        int sizeOfCol = sizeOfList / numOfCol;

        //check if the number of list size is enough for 5 column (from 1 to 5)
        boolean old = true;
        if (sizeOfList % numOfCol == 0) {
            old = false;
        }

        for (int i = 1; i <= numOfCol; i++) {
            int startCol = (i - 1) * sizeOfCol;
            int endCol = startCol + sizeOfCol;
            ArrayList<Card> col1 = cd.getListCardFrom(listCard, startCol, endCol);
            System.out.println("Column at: " + i);
            for (Card c : col1) {
                System.out.println("Item: " + c.getId());
            }
            System.out.println("----------------------------------------------------");
        }
        // if old size of list. then create a column sixth
        if (old) {
            int startCol = (6 - 1) * sizeOfCol;
            int endCol = sizeOfList;
            ArrayList<Card> col1 = cd.getListCardFrom(listCard, startCol, endCol);
            System.out.println("Column at: " + 6);
            for (Card c : col1) {
                System.out.println("Item: " + c.getId());
            }
            System.out.println("----------------------------------------------------");
        }

    }
}
