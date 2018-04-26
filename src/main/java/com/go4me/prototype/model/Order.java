package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Order{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

@Column(nullable=false)
private Date maxTime;

@Column(nullable=false)
private User publishedBy;

@Column(nullable=false)
private String description;

@Column(nullable=false)
private double maxCost;

public Order (){

}

public Order(Long OrderId){
  this.id = OrderId;
}

public Order (User publishedBy, String description, double maxCost){
  this.publishedBy=publishedBy;
  this.description=description;
  this.maxCost=maxCost;
}

public void setId(Long id) {
  this.id = id;
}

public void setMaxTime(Date maxTime){
  this.maxTime = maxTime;
}

public void setPublishedBy (User publishedBy){
this.publishedBy = publishedBy;
}

public void setDescription (String description){
this.description = description;
}

public void setMaxCost(double maxCost){
this.maxCost = maxCost;
}

public Long getID(){
  return id;
}

public Date getMaxTime(){
  return maxTime;
}

public User getPublishedBy(){
  return publishedBy;
}

public String getDescription(){
  return description;
}

public double getMaxCost(){
  return maxCost;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.maxCost, maxCost) == 0 &&
                Objects.equals(maxTime, order.maxTime) &&
                Objects.equals(publishedBy, order.publishedBy) &&
                Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTime, publishedBy, description, maxCost);
    }

    @Override
    public String toString() {
        return "Order{" +
                "maxTime=" + maxTime +
                ", publishedBy=" + publishedBy +
                ", description='" + description + '\'' +
                ", maxCost=" + maxCost +
                '}';
    }
}
