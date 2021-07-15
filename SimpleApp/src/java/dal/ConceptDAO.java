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
import model.Concept;

/**
 *
 * @author dinht
 */
public class ConceptDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;

    public Concept getConceptById(int id) throws ClassNotFoundException, SQLException {
        Concept c = null;
        try {
            String query = "select * from Concept where concept_id = "+id;
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                int conceptId = rs.getInt("concept_id");
                String conceptName = rs.getString("concept_name");
                c = new Concept(conceptId, conceptName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            c = null;
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return c;

    }

    public ArrayList<Concept> getAllConcept() throws ClassNotFoundException, SQLException {
        ArrayList<Concept> list = new ArrayList<>();

        try {
            String query = "select * from Concept";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int conceptId = rs.getInt("concept_id");
                String conceptName = rs.getString("concept_name");
                list.add(new Concept(conceptId, conceptName));
            }
        } catch (ClassNotFoundException | SQLException e) {
            list.clear();
        } finally {
            closeConnection(getConnection(), ps, rs);
        }
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ConceptDAO cd = new ConceptDAO();
        Concept c = cd.getConceptById(2);
        System.out.println(c.toString());
    }
}
