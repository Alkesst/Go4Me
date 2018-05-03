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

    @Column(nullable = false)
    private User buyer;

    @Column(nullable = false)
    private User seller;

    @Column(nullable = false)
    private boolean timeout;

    private boolean verifiedByBuyer;
    private boolean verifiedBySeller;

    public Order (){
        this.timeout = false;
    }

    public Order(Long OrderId){
        this.id = OrderId;
        this.timeout = false;
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

    public void setBuyer(User buyer) { this.buyer = buyer; }

    public void setSeller(User seller) { this.seller = seller; }

    public User getBuyer() { return buyer; }

    public User getSeller() { return seller; }

    public boolean isVerifiedByBuyer() { return verifiedByBuyer; }

    public boolean isVerifiedBySeller() { return verifiedBySeller; }

    public void setVerifiedByBuyer(boolean verifiedByBuyer) { this.verifiedByBuyer = verifiedByBuyer; }

    public void setVerifiedBySeller(boolean verifiedBySeller) { this.verifiedBySeller = verifiedBySeller; }

    private void setTimeOut(boolean timeout){
      this.timeout = timeout;
    }

    private void checkTimeOut(){
      LocalDateTime now = LocalDateTime.now();
      Date sysdate = new Date(now.getYear(), now.getMonth(), now.getDay(), now.getHour(), now.getMinute());
      if(compare(maxTime,sysdate) >= 0){
        setTimeOut(true);
      }
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
                "id=" + id +
                ", maxTime=" + maxTime +
                ", publishedBy=" + publishedBy +
                ", description='" + description + '\'' +
                ", maxCost=" + maxCost +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", verifiedByBuyer=" + verifiedByBuyer +
                ", verifiedBySeller=" + verifiedBySeller +
                '}';
    }
}

/*===================================================================
class TimeoutChecker extends Thread {
  public void run(){

    while(true){
      LocalDateTime now = LocalDateTime.now();
      Date sysdate = new Date(now.getYear(), now.getMonth(), now.getDay(), now.getHour(), now.getMinute());
      if(compare(maxTime,sysdate) >= 0){
        setTimeOut(true);
        Thread.stop();
      }
      Thread.sleep(60000)
    }

  }
}
*/ //================================================================
