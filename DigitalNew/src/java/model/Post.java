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
public class Post {

    private int idPost;
    private String titlePost;
    private String descriptPost;
    private String imgPost;
    private String authorPost;
    private Date timePost;
    private String shortDesPost;

    public Post(int idPost, String titlePost, String descriptPost, String imgPost, String authorPost, Date timePost, String shortDesPost) {
        this.idPost = idPost;
        this.titlePost = titlePost;
        this.descriptPost = descriptPost;
        this.imgPost = imgPost;
        this.authorPost = authorPost;
        this.timePost = timePost;
        this.shortDesPost = shortDesPost;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public void setTitlePost(String titlePost) {
        this.titlePost = titlePost;
    }

    public String getDescriptPost() {
        return descriptPost;
    }

    public void setDescriptPost(String descriptPost) {
        this.descriptPost = descriptPost;
    }

    public String getImgPost() {
        return imgPost;
    }

    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
    }

    public String getAuthorPost() {
        return authorPost;
    }

    public void setAuthorPost(String authorPost) {
        this.authorPost = authorPost;
    }

    public Date getTimePost() {
        return timePost;
    }

    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    public String getShortDesPost() {
        return shortDesPost;
    }

    public void setShortDesPost(String shortDesPost) {
        this.shortDesPost = shortDesPost;
    }

    public String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd yyyy - hh:mm aaa ");
        try {
            Date d = new Date(timePost.getTime());
            String dateString = sdf.format(d);
            return dateString;
        } catch (Exception e) {
            return null;
        }
    }
}
