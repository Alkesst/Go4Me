package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizationRepository extends JpaRepository<Localization, Long>{
    Localization findByAddress1(String address1);
}
