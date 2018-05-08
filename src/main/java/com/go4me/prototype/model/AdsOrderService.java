package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsOrderService {
  @Autowired
  AdsOrderRepository repository;

  public List<AdsOrder> getAll(){
      return repository.findAll();
  }

  public void update(AdsOrder ao){
    AdsOrder a = repository.getOne(ao.getID());

   a.setDescription(ao.getDescription());
   a.setPublishedBy(ao.getPublishedBy());
   a.setMaxCost(ao.getMaxCost());
   a.setWhenTheUserWillGoToBuy(ao.getWhenTheUserWillGoToBuy());

   repository.saveAndFlush(a);
  }

  public void add(AdsOrder ao){
    repository.saveAndFlush(ao);
  }

  public void delete(AdsOrder ao){
    repository.deleteById(ao.getId());
  }

  public AdsOrder getAdsOrderByID(Long id) { return repository.getOne(id); }

  public List<AdsOrder> searchByPublishedBy(User user) { return repository.findByPublishedBy(user); }


}