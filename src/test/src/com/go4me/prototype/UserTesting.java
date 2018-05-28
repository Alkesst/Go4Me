package com.go4me.prototype;

import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserRepository;
import com.go4me.prototype.model.UserService;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTesting {

    private static User user;
    private static final double RATING_CHANGE = 1.5;
    private static final String PASSWORD = "hola123";
    private static final double DELTA = 0.01;
    private static final String EMAIL = "test@test.org";
    private static final double INITIAL_RATING = 1.5;
    private static final String USERNAME = "ImNotATest";
    private static final String TWITTER_ACC = "@test";
    private static final long ID = 1L;

    @BeforeClass
    public static void createUser(){
        user = new User();
        user.setEmail(EMAIL);
        user.setPassword(PASSWORD);
        user.setRating(INITIAL_RATING);
        user.setUserName(USERNAME);
        user.setTwitterAccount(TWITTER_ACC);
        user.setId(ID);
    }

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        assertNotNull(userService);
    }

    @Test
    public void userRatingTest(){
        user.setRating(RATING_CHANGE);
        assertEquals( RATING_CHANGE, user.getRating(), DELTA);
    }

    @Test
    public void testPasswordCypher(){
        assertNotEquals(user.getPassword(), userService.cypherPassword(PASSWORD));
    }

    @Test
    public void testGetUserByUserName(){
        when(userRepository.findByUserName(anyString())).thenReturn(user);
        User resultUser = userService.searchByUserName(USERNAME);
        verify(userRepository, times(1)).findByUserName(USERNAME);
        assertEquals(user, resultUser);
    }

    @Test
    public void testGetByEmail(){
        when(userRepository.findByEmail(anyString())).thenReturn(user);
        User resultUser = userService.searchByEmail(EMAIL);
        assertEquals(user, resultUser);
    }

    @Test
    public void testGetByID() {
        when(userRepository.findByid(anyLong())).thenReturn(user);
        User resultUser3 = userService.searchByid(ID);
        verify(userRepository, times(1)).findByid(ID);
        assertEquals(user, resultUser3);
    }


    @Test
    public void testDeleteUser(){
        userService.delete(user);
        verify(userRepository, times(1)).deleteById(ID);
    }

    @Test
    public void testGetAllUsers(){
        List<User> allUsers = userService.getAll();
        verify(userRepository, times(1)).findAll();
        assertEquals(new ArrayList<>(), allUsers);
    }
}
