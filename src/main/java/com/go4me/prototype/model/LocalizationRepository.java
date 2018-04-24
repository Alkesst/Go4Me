package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalizationRepository extends JpaRepository<Localization, Long>{
    List<Localization> findByAdress1(String address1);
}
