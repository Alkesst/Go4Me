package com.go4me.prototype.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private boolean isPremium = false;

    @Column(unique=true, nullable = false)
    private String userName;

    @Column(unique=true, nullable=false)
    private String email;

    private List<User> blockedUsers;
    private boolean isBanned;

    @Column(unique=true)
    private String twitterAccount;

    /*TODO ADD PUBLISHED ORDERS AND ADS ORDER VARIABLES*/


}
