package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Buyer extends User{

  @Column(nullable=false)
  private Order ofOrder;

  public Buyer(){ }

  public Buyer(Order ofOrder,User u){
    super(u.getId());
    this.ofOrder = ofOrder;
  }

  @Override
  public String toString() {
      return "User{" +
              "id=" + id +
              ", rating=" + rating +
              ", isPremium=" + isPremium +
              ", userName='" + userName + '\'' +
              ", email='" + email + '\'' +
              ", blockedUsers=" + blockedUsers +
              ", isBanned=" + isBanned +
              ", twitterAccount='" + twitterAccount + '\'' +
              ", localization=" + localization +
              ", ofOrder=" + ofOrder +
              '}';
  }

}
