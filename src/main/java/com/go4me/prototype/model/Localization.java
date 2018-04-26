package com.go4me.prototype.model;


import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import javax.persistence.*;
import java.util.Objects;
import java.io.IOException;

@Entity
public class Localization {
    private static final String API_KEY = "AIzaSyBGSymDT45SwboBEgG_D53iAFhDurwGlww";

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
        LatLng coord;
        this.address1 = address1;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        coord = getCoordinates(address1);
        if(coord != null){
            this.latitude = coord.lat;
            this.longitude = coord.lng;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Localization that = (Localization) o;
        return zipCode == that.zipCode &&
                Objects.equals(address1, that.address1) &&
                Objects.equals(city, that.city) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address1, city, country, zipCode);
    }

    @Override
    public String toString() {
        return "Localization{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode=" + zipCode +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    private static LatLng getCoordinates(String address){
        // Adaptation from the code example in https://github.com/googlemaps/google-maps-services-java
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        GeocodingResult[] results;
        try {
            results = com.google.maps.GeocodingApi.geocode(context,
                    address).await();
            return results[0].geometry.location;
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
