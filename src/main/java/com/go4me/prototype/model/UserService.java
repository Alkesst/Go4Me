package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public void register(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	this.add(user);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public void update(User user){
        User u = repository.getOne(user.getId());
        u.setNumberOfRatings(user.getNumberOfRatings());
        u.setRating(user.getRating());
        u.setIsPremium(user.getIsPremium());
        u.setBanned(user.getIsBanned());
        u.setUserName(user.getUserName());
        u.setEmail(user.getEmail());
        u.setBlockedUsers(user.getBlockedUsers());
        u.setTwitterAccount(user.getTwitterAccount());
        u.setLocalization(user.getLocalization());
        u.setPublishedAds(user.getPublishedAds());
        u.setPublishedOrderRequests(user.getPublishedOrderRequests());
        repository.saveAndFlush(u);
    }

    public void add(User user){
        repository.saveAndFlush(user);
    }

    public void delete(User user){
        repository.deleteById(user.getId());
    }

    public OrderRequest publishOrder(Long id, String description, double cost, int day, String month, String hour){
        return new OrderRequest(searchByid(id), description, cost, day, month, hour);
    }

    public AdsOrder publishAdsOrder(Long id, String description, double cost, java.util.Date whenTheUserWillGoToBuy){
        return new AdsOrder(description, searchByid(id), cost, whenTheUserWillGoToBuy);
    }

    public User searchByUserName(String userName){ return repository.findByUserName(userName); }

    public User searchByEmail(String email){ return repository.findByEmail(email); }

    public List<User> searchByLocation(Localization location) { return repository.findByLocalization(location); }

    public User searchByid(Long id){ return repository.findByid(id); }

    public User getUserByID(Long id) { return repository.getOne(id); }

    public List<User> findUsersByUsername(String queryValue) {
        return this.getAll().stream()
                .filter(u -> u.getUserName().toLowerCase().contains(queryValue.toLowerCase()))
                .collect(Collectors.toList());
    }

}
