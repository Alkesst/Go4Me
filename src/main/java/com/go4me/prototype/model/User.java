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
    private boolean isPremium;

    @Column(unique=true, nullable = false)
    private String userName;

    @Column(unique=true, nullable=false)
    private String email;

    private List<User> blockedUsers;
    private boolean isBanned;

    @Column(unique=true)
    private String twitterAccount;

    private Localization localization;

    /*TODO ADD PUBLISHED ORDERS AND ADS ORDER VARIABLES*/



    public User() {

    }

    public User(Long userId) { this.id = userId; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPremium(boolean premium) {
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

    public void setBanned(boolean banned) {
        isBanned = banned;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public Long getId() {
        return id;
    }

    public boolean isPremium() {
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

    public boolean isBanned() {
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
