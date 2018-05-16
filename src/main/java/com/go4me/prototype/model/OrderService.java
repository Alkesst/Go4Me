package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class OrderService{
  @Autowired
  OrderRepository repository;

    public List<OrderRequest> getAll(){
        return repository.findAll();
    }

    public void update(OrderRequest orderRequest){
    OrderRequest o = repository.getOne(orderRequest.getID());

    o.setMaxTime(orderRequest.getMaxTime());
    o.setPublishedBy(orderRequest.getPublishedBy());
    o.setDescription(orderRequest.getDescription());
    o.setMaxCost(orderRequest.getMaxCost());

    repository.saveAndFlush(o);
  }

  public boolean timeout(OrderRequest order){
    java.util.Date currentDate= new Date();
    return  (currentDate.compareTo(order.getMaxTime()) < 0);
  }

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
