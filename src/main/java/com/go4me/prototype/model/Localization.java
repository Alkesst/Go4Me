package com.go4me.prototype.model;


import javax.persistence.*;

@Entity
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String address1;

    private String address2;

    @Column(nullable = false)
    private String city;

    @Column(nullable=false)
    private String country;

    @Column(nullable = false)
    private int zipCode;

    private double latitude;

    private double longitude;
}
