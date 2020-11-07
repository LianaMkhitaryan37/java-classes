package com.company.info;

public class Address {
    private String postalCode;
    private String country;
    private String city;
    private String street;

    public Address(String postalCode, String country, String city, String street) {
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
