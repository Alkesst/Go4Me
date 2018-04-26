package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizationService {
    @Autowired
    LocalizationRepository repository;

    public void searchOrderLocation(double longitude, double latitude){
        //TODO implementar tras resolver #20
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
