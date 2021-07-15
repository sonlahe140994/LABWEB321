/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dinht
 */
public class Author {
    private int authorId;
    private String imgUrl;
    private String authorName;
    private String nameConcept;

    public Author(int authorId, String imgUrl, String authorName, String nameConcept) {
        this.authorId = authorId;
        this.imgUrl = imgUrl;
        this.authorName = authorName;
        this.nameConcept = nameConcept;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getNameConcept() {
        return nameConcept;
    }

    public void setNameConcept(String nameConcept) {
        this.nameConcept = nameConcept;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + authorId + ", imgUrl=" + imgUrl + ", authorName=" + authorName + ", nameConcept=" + nameConcept + '}';
    }
    
}
