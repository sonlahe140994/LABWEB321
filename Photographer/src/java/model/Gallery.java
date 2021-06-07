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
public class Gallery {

    private String galleryId;
    private String titleGallery;
    private String descriptionGallery;

    public Gallery(String galleryId, String titleGallery, String descriptionGallery) {
        this.galleryId = galleryId;
        this.titleGallery = titleGallery;
        this.descriptionGallery = descriptionGallery;
    }

    public String getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    public String getTitleGallery() {
        return titleGallery;
    }

    public void setTitleGallery(String titleGallery) {
        this.titleGallery = titleGallery;
    }

    public String getDescriptionGallery() {
        return descriptionGallery;
    }

    public void setDescriptionGallery(String descriptionGallery) {
        this.descriptionGallery = descriptionGallery;
    }

    @Override
    public String toString() {
        return "Gallery{" + "galleryId=" + galleryId + ", titleGallery=" + titleGallery + ", descriptionGallery=" + descriptionGallery + '}';
    }

}
