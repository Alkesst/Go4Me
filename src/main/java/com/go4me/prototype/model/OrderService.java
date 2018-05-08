package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
  @Autowired
  OrderRepository repository;

  public void update(OrderRequest orderRequest){
    OrderRequest o = repository.getOne(orderRequest.getID());

    o.setMaxTime(orderRequest.getMaxTime());
    o.setPublishedBy(orderRequest.getPublishedBy());
    o.setDescription(orderRequest.getDescription());
    o.setMaxCost(orderRequest.getMaxCost());

    repository.saveAndFlush(o);
  }

  /*                      PREGUNTAR A JAIME

  public void orderStart(){
    //TODO <=======================================================
  }

  public Localization getLocalizationFromPublisher(){
    return publishedBy.getLocalization();
  }

  public boolean verifedBy();

  public void orderFinished(){
    //TODO<========================================================
  }
  */

  public void add(OrderRequest orderRequest){
    repository.saveAndFlush(orderRequest);
  }

  public void delete(OrderRequest orderRequest){
    repository.deleteById(orderRequest.getID());
  }

  public OrderRequest searchByPublishedBy (User user){
    return repository.findByPublishedBy(user);
  }

  public OrderRequest getOrderById(long id){
    return repository.getOne(id);
  }
}
