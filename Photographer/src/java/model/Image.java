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
public class Image {

    private int id;
    private String galleryId;
    private String url;

    public Image(int id, String galleryId, String url) {
        this.id = id;
        this.galleryId = galleryId;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" + "id=" + id + ", galleryId=" + galleryId + ", url=" + url + '}';
    }

}
