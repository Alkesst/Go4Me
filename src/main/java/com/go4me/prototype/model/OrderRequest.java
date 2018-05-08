package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private Date maxTime;

    @ManyToOne
    private User publishedBy;

    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private double maxCost;

    @ManyToOne
    private User buyer;

    @ManyToOne
    private User seller;

    @Column(nullable = false)
    private int timeout;

    @Column
    private int verifiedByBuyer;
    @Column
    private int verifiedBySeller;

    public OrderRequest(){
        this.timeout = 0;
    }

    public OrderRequest(Long OrderId){
        this.id = OrderId;
        this.timeout = 0;
    }

    public OrderRequest(User publishedBy, String description, double maxCost){
        this.publishedBy=publishedBy;
        this.description=description;
        this.maxCost=maxCost;
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

    public int isVerifiedByBuyer() { return verifiedByBuyer; }

    public int isVerifiedBySeller() { return verifiedBySeller; }

    public void setVerifiedByBuyer(int verifiedByBuyer) { this.verifiedByBuyer = verifiedByBuyer; }

    public void setVerifiedBySeller(int verifiedBySeller) { this.verifiedBySeller = verifiedBySeller; }

    private void setTimeOut(int timeout){
      this.timeout = timeout;
    }

    /*private void checkTimeOut(){
        // TODO está mal
      LocalDateTime now = LocalDateTime.now();
      Date sysdate = new Date(now.getYear(), now.getMonth(), now.getDay(), now.getHour(), now.getMinute());
      if(maxTime.compare(sysdate) >= 0){
        setTimeOut(1);
      }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest orderRequest = (OrderRequest) o;
        return Double.compare(orderRequest.maxCost, maxCost) == 0 &&
                Objects.equals(maxTime, orderRequest.maxTime) &&
                Objects.equals(publishedBy, orderRequest.publishedBy) &&
                Objects.equals(description, orderRequest.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxTime, publishedBy, description, maxCost);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
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
