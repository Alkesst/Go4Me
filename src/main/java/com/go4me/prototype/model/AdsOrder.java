package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class AdsOrder{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  private java.util.Date maxTime;

  @Column(nullable=false)
  private String description;

  @ManyToOne
  private User publishedBy;

  @Column(nullable=false)
  private double maxCost;

  @Column(nullable=false)
  private Date whenTheUserWillGoToBuy;

  public AdsOrder(){}

  public AdsOrder(Long id){
    this.id = id;
  }

  public AdsOrder(String description, User publishedBy, double maxCost, java.util.Date whenTheUserWillGoToBuy){
    this.description = description;
    this.publishedBy = publishedBy;
    this.maxCost = maxCost;
    this.whenTheUserWillGoToBuy = whenTheUserWillGoToBuy;
  }

  public Localization getLocalizationFromPublisher(){
    return publishedBy.getLocalization();
  }

  public Long getId(){
    return id;
  }

  public java.util.Date getMaxTime(){
      return maxTime;
  }

  public String getDescription(){
    return description;
  }

  public User getPublishedBy(){
    return publishedBy;
  }

  public double getMaxCost(){
    return maxCost;
  }

  public Date getWhenTheUserWillGoToBuy(){
    return whenTheUserWillGoToBuy;
  }

  public void setDescription (String d){
    description = d;
  }

  public void setId (Long id){
    this.id = id;
  }

  public void setMaxTime(java.util.Date maxTime){
      this.maxTime = maxTime;
  }

  public void setPublishedBy (User publishedBy){
    this.publishedBy = publishedBy;
  }

  public void setMaxCost(double maxCost){
     this.maxCost = maxCost;
  }

  public void setWhenTheUserWillGoToBuy (Date whenTheUserWillGoToBuy){
      this.whenTheUserWillGoToBuy = whenTheUserWillGoToBuy;
  }

  @Override
  public int hashCode() {
      return Objects.hash(publishedBy, description, maxCost);
  }

  @Override
  public String toString() {
      return "Order{" +
              "id=" + id +
              ", publishedBy=" + publishedBy +
              ", description='" + description + '\'' +
              ", maxCost=" + maxCost +
              ", whenTheUserWillGoToBuy=" + whenTheUserWillGoToBuy +
              '}';
  }

}
