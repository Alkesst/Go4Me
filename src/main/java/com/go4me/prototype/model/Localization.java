package com.go4me.prototype.model;


import javax.persistence.*;

@Entity
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String address1;

    private String address2;

    @Column(nullable = false)
    private String city;

    @Column(nullable=false)
    private String country;

    @Column(nullable = false)
    private int zipCode;

    private double latitude;

    private double longitude;

    public Localization(){}

    public Localization(String address1, String city, String country, int zipCode) {
        this.address1 = address1;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    //TODO Este método debe realizarse con la colaboración de los integrantes del grupo en la proxima reunion
    public void searchOrderLocation(double longitude, double latitude){

    }



}
