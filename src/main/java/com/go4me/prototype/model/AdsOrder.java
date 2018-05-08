package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class AdsOrder{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  private String description;

  @Column(nullable=false)
  private User publishedBy;

  @Column(nullable=false)
  private double maxCost;

  @Column(nullable=false)
  private Date whenTheUserWillGoToBuy;

  public AdsOrder(){}

  public AdsOrder(Long id){
    this.id = id;
  }

  public AdsOrder(String description, User publishedBy, double maxCost, Date whenTheUserWillGoToBuy){
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

  public String getDescription(){
    return description;
  }

  public User getPublishedBy(){
    return publishedBy;
  }

  public double getMaxCost(){
    return maxCost
  }

  public Date getWhenTheUserWillGoToBuy(){
    return whenTheUserWillGoToBuy;
  }

  public void setDescription (){
    return this.description;
  }

  public void setId (int id){
    this.id = id;
  }

  public void setPublishedBy (User publishedBy){
    this.publishedBy = publishedBy;
  }

  public void setMaxCost(double maxCost){
     this.maxCost = maxCost;
  }

  public void setWhenTheUserWillGoToBuy (date whenTheUserWillGoToBuy){
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
