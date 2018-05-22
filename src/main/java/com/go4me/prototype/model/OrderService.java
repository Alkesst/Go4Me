package com.go4me.prototype.model;

import org.hibernate.criterion.Order;
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

        o.setDay(orderRequest.getDay());
        o.setHour(orderRequest.getHour());
        o.setMonth(orderRequest.getMonth());
        o.setPublishedBy(orderRequest.getPublishedBy());
        o.setDescription(orderRequest.getDescription());
        o.setMaxCost(orderRequest.getMaxCost());

        repository.saveAndFlush(o);
    }

  public void deleteOrder(OrderRequest order){
        repository.delete(order);
  }

  public boolean timeout(OrderRequest order){
    java.util.Date currentDate= new Date();
    java.util.Date date = new Date();
    date = parseToDate(order.getDay(), order.getMonth(), order.getHour());
    return  (currentDate.compareTo(date) < 0);
  }

  public java.util.Date parseToDate(int day, String mes, String hora){
        java.util.Date date = new Date();
        int month = parseToMonth(mes);
        String array[] = hora.split(":");
        date.setMonth(month - 1);
        date.setDate(day);
        date.setYear(118);
        date.setHours(Integer.valueOf(array[0]));
        date.setMinutes(Integer.valueOf(array[1]));
        return date;
   }

   private int parseToMonth(String mes){
     int month;
      switch (mes) {
        case "January":  month = 1;
         break;
        case "February":  month = 2;
          break;
        case "March":  month = 3;
          break;
        case "April":  month = 4;
          break;
        case "May":  month = 5;
          break;
        case "June":  month = 6;
          break;
        case "July":  month = 7;
          break;
        case "August":  month = 8;
          break;
        case "September":  month = 9;
          break;
        case "October":  month = 10;
          break;
        case "November":  month = 11;
          break;
        case "December":  month = 12;
          break;
        default:  month = -1;
          break;
     }
     return month;
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
