import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserRepository;
import com.go4me.prototype.model.UserService;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UserService.class)
public class UserTesting {

    private static final double RATING_CHANGE = 1.5;
    private static final String PASSWORD = "hola123";

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
        assertEquals( RATING_CHANGE, (double) user.getRating());
    }


    @Test
    public void testPasswordCypher(){
        User user = new User();
        user.setPassword(PASSWORD);
        assertNotEquals(PASSWORD, userService.cypherPassword(PASSWORD));
    }


}
