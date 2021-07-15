/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author dinht
 */
public class QuestionDAO extends DBContext {

    PreparedStatement ps;
    ResultSet rs;
    Connection c;

    public ArrayList<Question> getAllQuestion() throws ClassNotFoundException, SQLException {
        ArrayList<Question> listQues = new ArrayList<>();
        try {
            String query = "select * from Question";
            ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("q_id");
                String ques = rs.getString("ques");
                String op1 = rs.getString("op1");
                String op2 = rs.getString("op2");
                String op3 = rs.getString("op3");
                String op4 = rs.getString("op4");
                String ans = rs.getString("ans");
                Date dateCreate = rs.getDate("date_crea");
                Question q = new Question(id, ques, op1, op2, op3, op4, ans, dateCreate);
                listQues.add(q);
            }
        } catch (ClassNotFoundException | SQLException e) {
            listQues.clear();
        } finally {
            closeConnection(rs, ps, getConnection());
        }
        return listQues;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        QuestionDAO qd = new QuestionDAO();
        //        long millis = System.currentTimeMillis();
        //        Date date = new Date(millis);
        //        Question q = new Question(0, "Việt Nam Thuộc Khối Nào ?", "Khối EU", "Khối Asian", "Khối Caribe", "Khối Africa", "2", date);
        //        if (qd.insertQues(q)) {
        //            System.out.println("win");
        //        } else {
        //            System.out.println("lose");
        //        }

        ArrayList<Question> listQ = qd.getRandomQuestion(5);
        for (Question i : listQ) {
            System.out.println(i.toString());
        }

    }

    public boolean insertQues(Question q) throws ClassNotFoundException, SQLException {
        c = getConnection();
        try {
            String query = "insert into Question\n"
                    + "values(?,?,?,?,?,?,?)\n";
            ps = c.prepareStatement(query);
            c.setAutoCommit(false);
//            ps.setString(1, q.getQues());
//            ps.setString(2, q.getOption1());
//            ps.setString(3, q.getOption2());
//            ps.setString(4, q.getOption3());
//            ps.setString(5, q.getOption4());
//            ps.setString(6, q.getAnswer());
//            ps.setDate(7, q.getDateCreate());
            ps.setNString(1, q.getQues());
            ps.setNString(2, q.getOption1());
            ps.setNString(3, q.getOption2());
            ps.setNString(4, q.getOption3());
            ps.setNString(5, q.getOption4());
            ps.setNString(6, q.getAnswer());
            ps.setDate(7, q.getDateCreate());
//            ps.setNString(1, "Ai là người ném rùi vào Thanos?");
//            ps.setNString(2, "Black panther");
//            ps.setNString(3, "Black Windown");
//            ps.setNString(4, "Đội Trưởng Mỹ");
//            ps.setNString(5, "Thần Sấm Thor");
//            ps.setNString(6, "5");
//            ps.setDate(7, q.getDateCreate());
            ps.executeUpdate();
            c.commit();
            return true;
        } catch (SQLException e) {
            if (c != null) {
                c.rollback();
            }
        } finally {
            closeConnection(rs, ps, c);
        }
        return false;
    }

    public ArrayList<Question> getRandomQuestion(int numOfQues) throws SQLException {
        ArrayList<Question> listRan = new ArrayList<>();
        try {
            String query = "SELECT TOP " + numOfQues + " * FROM Question\n"
                    + "ORDER BY NEWID()";
            c = getConnection();
            ps = c.prepareStatement(query);
            System.out.println(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("q_id");
                String ques = rs.getString("ques");
                String op1 = rs.getString("op1");
                String op2 = rs.getString("op2");
                String op3 = rs.getString("op3");
                String op4 = rs.getString("op4");
                String ans = rs.getString("ans");
                Date dateCreate = rs.getDate("date_crea");
                Question q = new Question(id, ques, op1, op2, op3, op4, ans, dateCreate);
                listRan.add(q);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            listRan.clear();
        } finally {
            closeConnection(rs, ps, c);
        }
        return listRan;
    }

}
