package com.go4me.prototype;

import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserRepository;
import com.go4me.prototype.model.UserService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTesting {

    private static final double RATING_CHANGE = 1.5;
    private static final String PASSWORD = "hola123";
    private static final double DELTA = 0.01;

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
        User user = new User();
        user.setRating(RATING_CHANGE);
        assertEquals( RATING_CHANGE, user.getRating(), DELTA);
    }

    @Test
    public void testPasswordCypher(){
        User user = new User();
        user.setPassword(PASSWORD);
        assertNotEquals(PASSWORD, userService.cypherPassword(PASSWORD));
    }
}
