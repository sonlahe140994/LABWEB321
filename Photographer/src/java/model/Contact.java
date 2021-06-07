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
public class Contact {

    private String nameContact;
    private String addressContact;
    private String cityContact;
    private String countryContact;
    private String telephoneContact;
    private String emailContact;
    private String mapUrl;
    private String faceUrl;
    private String twitterUrl;
    private String googleUrl;
    private String aboutContact;

    public Contact(String nameContact, String addressContact, String cityContact, String countryContact, String telephoneContact, String emailContact, String mapUrl, String faceUrl, String twitterUrl, String googleUrl, String aboutContact) {
        this.nameContact = nameContact;
        this.addressContact = addressContact;
        this.cityContact = cityContact;
        this.countryContact = countryContact;
        this.telephoneContact = telephoneContact;
        this.emailContact = emailContact;
        this.mapUrl = mapUrl;
        this.faceUrl = faceUrl;
        this.twitterUrl = twitterUrl;
        this.googleUrl = googleUrl;
        this.aboutContact = aboutContact;
    }

    public String getAboutContact() {
        return aboutContact;
    }

    public void setAboutContact(String aboutContact) {
        this.aboutContact = aboutContact;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getAddressContact() {
        return addressContact;
    }

    public void setAddressContact(String addressContact) {
        this.addressContact = addressContact;
    }

    public String getCityContact() {
        return cityContact;
    }

    public void setCityContact(String cityContact) {
        this.cityContact = cityContact;
    }

    public String getCountryContact() {
        return countryContact;
    }

    public void setCountryContact(String countryContact) {
        this.countryContact = countryContact;
    }

    public String getTelephoneContact() {
        return telephoneContact;
    }

    public void setTelephoneContact(String telephoneContact) {
        this.telephoneContact = telephoneContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public String getTwitterUrl() {
        return twitterUrl;
    }

    public void setTwitterUrl(String twitterUrl) {
        this.twitterUrl = twitterUrl;
    }

    public String getGoogleUrl() {
        return googleUrl;
    }

    public void setGoogleUrl(String googleUrl) {
        this.googleUrl = googleUrl;
    }

    @Override
    public String toString() {
        return "Contact{" + "nameContact=" + nameContact + ", addressContact=" + addressContact + ", cityContact=" + cityContact + ", countryContact=" + countryContact + ", telephoneContact=" + telephoneContact + ", emailContact=" + emailContact + ", mapUrl=" + mapUrl + ", faceUrl=" + faceUrl + ", twitterUrl=" + twitterUrl + ", googleUrl=" + googleUrl + '}';
    }

}
