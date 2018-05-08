package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Seller extends User{

  @Column(nullable=false)
  private Order ofOrder;

  public Seller(){

  }

  public Seller(Order order){

  }

}
