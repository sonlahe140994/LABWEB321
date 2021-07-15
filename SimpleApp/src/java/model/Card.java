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
public class Card {
   private int id;
   private String fromUrl;
   private String fromLogo;
   private String title;
   private String des;
   private String imgMain;
   private int numOfPin;
   private int numOfLike;
   private String expandPin;
   private String urlSourcePage;
   private int authorId;
   private int conceptId;

    public Card(int id, String fromUrl, String fromLogo, String title, String des, String imgMain, int numOfPin, int numOfLike, String expandPin, String urlSourcePage, int authorId, int conceptId) {
        this.id = id;
        this.fromUrl = fromUrl;
        this.fromLogo = fromLogo;
        this.title = title;
        this.des = des;
        this.imgMain = imgMain;
        this.numOfPin = numOfPin;
        this.numOfLike = numOfLike;
        this.expandPin = expandPin;
        this.urlSourcePage = urlSourcePage;
        this.authorId = authorId;
        this.conceptId = conceptId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getFromLogo() {
        return fromLogo;
    }

    public void setFromLogo(String fromLogo) {
        this.fromLogo = fromLogo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImgMain() {
        return imgMain;
    }

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    public int getNumOfPin() {
        return numOfPin;
    }

    public void setNumOfPin(int numOfPin) {
        this.numOfPin = numOfPin;
    }

    public int getNumOfLike() {
        return numOfLike;
    }

    public void setNumOfLike(int numOfLike) {
        this.numOfLike = numOfLike;
    }

    public String getExpandPin() {
        return expandPin;
    }

    public void setExpandPin(String expandPin) {
        this.expandPin = expandPin;
    }

    public String getUrlSourcePage() {
        return urlSourcePage;
    }

    public void setUrlSourcePage(String urlSourcePage) {
        this.urlSourcePage = urlSourcePage;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getConceptId() {
        return conceptId;
    }

    public void setConceptId(int conceptId) {
        this.conceptId = conceptId;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", fromUrl=" + fromUrl + ", fromLogo=" + fromLogo + ", title=" + title + ", des=" + des + ", imgMain=" + imgMain + ", numOfPin=" + numOfPin + ", numOfLike=" + numOfLike + ", expandPin=" + expandPin + ", urlSourcePage=" + urlSourcePage + ", authorId=" + authorId + ", conceptId=" + conceptId + '}';
    }
   
}
