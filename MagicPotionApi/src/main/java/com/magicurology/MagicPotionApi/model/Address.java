package com.magicurology.MagicPotionApi.model;

public class Address {

    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    public String getStreet1() {
        return street1;
    }

    public Address setStreet1(String street1) {
        this.street1 = street1;
        return this;
    }

    public String getStreet2() {
        return street2;
    }

    public Address setStreet2(String street2) {
        this.street2 = street2;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public Address setZip(String zip) {
        this.zip = zip;
        return this;
    }
}
