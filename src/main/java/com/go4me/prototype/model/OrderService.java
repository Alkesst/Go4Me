package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

  public java.util.Date parseToDate(int day, int month, String hora){
        java.util.Date date = new Date();
        date.setMonth(month - 1);
        date.setDate(day);
        date.setYear(118);
        String array[] = hora.split(":");
        date.setHours(Integer.valueOf(array[0]));
        date.setMinutes(Integer.valueOf(array[1]));
        return date;
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
