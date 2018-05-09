package com.go4me.prototype.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsOrderRepository extends JpaRepository<AdsOrder, Long>{
    List<AdsOrder> findByPublishedBy(User user);
}
