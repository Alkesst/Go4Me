package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService{
  @Autowired
  OrderRepository repository;

  public void update(Order order){
    Order o = repository.getOne(order.getID());

    o.setMaxTime(order.getMaxTime());
    o.setPublishedBy(order.getPublishedBy());
    o.setDescription(order.getDescription());
    o.setMaxCost(order.getMaxCost());

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

  public void add(Order order){
    repository.saveAndFlush(order);
  }

  public void delete(Order order){
    repository.deleteById(order.getID());
  }

  public Order searchByPublishedBy (User user){
    return repository.findByPublishedBy(user);
  }

  public Order getOrderById(long id){
    return repository.getOne(id);
  }
}
