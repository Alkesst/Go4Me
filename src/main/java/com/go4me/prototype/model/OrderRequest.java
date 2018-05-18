package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @Column
    private int verifiedByBuyer;
    @Column
    private int verifiedBySeller;

    @Column
    private int day;

    @Column
    private String month;

    @Column
    private String hour;

    public OrderRequest(){
    }

    public OrderRequest(Long OrderId){
        this.id = OrderId;
    }

    public OrderRequest(User publishedBy, String description, double maxCost, int day, String month, String hour){
        this.publishedBy=publishedBy;
        this.description=description;
        this.maxCost=maxCost;
        this.day = day;
        this.month = month;
        this.hour = hour;
    }

    public OrderRequest(AdsOrder ao){
      this.publishedBy = ao.getPublishedBy();
      this.description = ao.getDescription();
      this.maxCost = ao.getMaxCost();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() { return day; }

    public void setDay(int day) { this.day = day; }

    public String getMonth() { return month; }

    public void setMonth(String month) { this.month = month; }

    public String getHour() { return hour; }

    public void setHour(String hour) { this.hour = hour; }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest orderRequest = (OrderRequest) o;
        return Double.compare(orderRequest.maxCost, maxCost) == 0 &&
                Objects.equals(publishedBy, orderRequest.publishedBy) &&
                Objects.equals(description, orderRequest.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publishedBy, description, maxCost);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "id=" + id +
                ", publishedBy=" + publishedBy +
                ", description='" + description + '\'' +
                ", maxCost=" + maxCost +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", verifiedByBuyer=" + verifiedByBuyer +
                ", verifiedBySeller=" + verifiedBySeller +
                ", day=" + day +
                ", month='" + month + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}
