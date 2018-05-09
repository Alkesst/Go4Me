package com.go4me.prototype.model;

import javax.persistence.*;
import java.util.*;


@Entity
public class Message{

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  @Column(nullable=false)
  private String content;

  @OneToOne
  private User wroteBy;

  @OneToOne
  private User sentTo;


  public String getContent(){
    return content;
  }

  public Long getId(){
    return id;
  }

  public User getWroteBy(){
    return wroteBy;
  }

  public User getSentTo(){
    return sentTo;
  }

  public void setContent(String content){
    this.content = content;
  }

  public void setWroteBy(User wroteBy){
    this.wroteBy = wroteBy;
  }

  public void setSentTo(User sentTo){
    this.sentTo = sentTo;
  }

  public void setId(Long id){
    this.id = id;
  }


  @Override
  public int hashCode() {
      return Objects.hash(id);
  }

  @Override
  public String toString() {
      return "User{" +
              "id=" + id +
              ", content=" + content +
              ", wroteBy=" + wroteBy +
              ", sentTo=" + sentTo +
              '}';
  }

}
