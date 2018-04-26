package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
    @Autowired
    LocalizationRepository repository;
    private final static int EARTH_RADIUS = 6378; //Radius in Km

    public void searchOrderLocation(double longitude, double latitude){
        //TODO implementar tras resolver #20
    }

    private double radiansConversion(double radians){
        return (radians * Math.PI)/180;
    }

    // Distance in Kilometers(Km)
    public double distanceBetweenBothUsers(double latitudeA, double longitudeA, double latitudeB, double longitudeB){
        double distance, latitudeDiference, longitudDiference;

        latitudeDiference = radiansConversion(latitudeA - latitudeB);
        longitudDiference = radiansConversion(longitudeA - longitudeB);
        distance = Math.pow(Math.sin(latitudeDiference/2),2) +
                Math.cos(radiansConversion(latitudeA)) *
                Math.cos(radiansConversion(latitudeB)) *
                Math.pow(Math.sin(longitudDiference/2),2);
        distance = 2 * Math.atan2(Math.sqrt(distance), Math.sqrt(1-distance));

        return distance * EARTH_RADIUS; // Result in Kilometers(Km)
    }

    public void update(Localization locate){
        Localization l = repository.getOne(locate.getId());
        l.setAddress1(locate.getAddress1());
        l.setAddress2(locate.getAddress2());
        l.setCity(locate.getCity());
        l.setCountry(locate.getCountry());
        l.setLatitude(locate.getLatitude());
        l.setLongitude(locate.getLongitude());
        l.setZipCode(locate.getZipCode());
        repository.saveAndFlush(l);
    }



}