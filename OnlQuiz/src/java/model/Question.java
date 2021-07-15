/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dinht
 */
public class Question {

    private int id;
    private String ques;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private java.sql.Date dateCreate;

    public Question(int id, String ques, String option1, String option2, String option3, String option4, String answer, java.sql.Date dateCreate) {
        this.id = id;
        this.ques = ques;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public java.sql.Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(java.sql.Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String formatDateCreate() {
        Date date = new Date(this.dateCreate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");
        String dateString = sdf.format(date);
        return dateString;
    }
    public String formatDate(){
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis);
        return date.toString();
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", ques=" + ques + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ", option4=" + option4 + ", answer=" + answer + ", dateCreate=" + dateCreate + '}';
    }

}
