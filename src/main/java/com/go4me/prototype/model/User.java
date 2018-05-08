package com.go4me.prototype.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private Double rating;

    @Column(nullable = false)
    private int isPremium;

    @Column(unique=true, nullable = false)
    private String userName;

    @Column(unique=true, nullable=false)
    private String email;

    @OneToMany
    private List<User> blockedUsers;

    @Column
    private int isBanned;

    @Column(unique=true)
    private String twitterAccount;

    @OneToOne(cascade=CascadeType.ALL)
    private Localization localization;

    @OneToMany
    private List<OrderRequest> publishedOrderRequests;

    // TODO ADD @OneToMany private List<AdsOrder> publishedAds;


    public User() {
        isPremium = 0;
        isBanned = 0;
    }

    public User(Long userId) { this.id = userId; }

    public User(Double rating, int isPremium, String userName, String email,
                List<User> blockedUsers, int isBanned, String twitterAccount,
                Localization localization, List<OrderRequest> publishedOrderRequests) {
        this.rating = rating;
        this.isPremium = isPremium;
        this.userName = userName;
        this.email = email;
        this.blockedUsers = blockedUsers;
        this.isBanned = isBanned;
        this.twitterAccount = twitterAccount;
        this.localization = localization;
        this.publishedOrderRequests = publishedOrderRequests;
    }

    public void setPremium(int premium) {
        isPremium = premium;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlockedUsers(List<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public void setBanned(int banned) {
        isBanned = banned;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public Long getId() {
        return id;
    }

    public int isPremium() {
        return isPremium;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public List<User> getBlockedUsers() {
        return blockedUsers;
    }

    public int isBanned() {
        return isBanned;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public Double getRating() { return rating; }

    public void setRating(Double rating) { this.rating = rating; }

    public Localization getLocalization() { return localization; }

    public void setLocalization(Localization localization) { this.localization = localization; }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
                '}';
    }
}
