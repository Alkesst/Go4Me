package com.go4me.prototype.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<User> getAll(){
        return repository.findAll();
    }

    public void update(User user){
        User u = repository.getOne(user.getId());
        u.setRating(user.getRating());
        u.setBanned(user.isBanned());
        u.setBlockedUsers(user.getBlockedUsers());
        u.setEmail(user.getEmail());
        u.setTwitterAccount(user.getTwitterAccount());
        u.setPremium(user.isPremium());
        u.setUserName(user.getUserName());
        u.setLocalization(user.getLocalization());
        u.setId(user.getId());
        repository.saveAndFlush(u);
    }

    public void add(User user){
        repository.saveAndFlush(user);
    }

    public void delete(User user){
        repository.deleteById(user.getId());
    }

    public OrderRequest publishOrder(Long id, String description, double cost, java.util.Date maxTime){
        return new OrderRequest(searchByid(id), description, cost, maxTime);
    }

    public AdsOrder publishAdsOrder(Long id, String description, double cost, java.util.Date whenTheUserWillGoToBuy){
        return new AdsOrder(description, searchByid(id), cost, whenTheUserWillGoToBuy);
    }

    public User searchByUserName(String userName){ return repository.findByUserName(userName); }

    public User searchByEmail(String email){ return repository.findByEmail(email); }

    public List<User> searchByLocation(Localization location) { return repository.findByLocalization(location); }

    public User searchByid(Long id){ return repository.findByid(id); }

    public User getUserByID(Long id) { return repository.getOne(id); }

}
