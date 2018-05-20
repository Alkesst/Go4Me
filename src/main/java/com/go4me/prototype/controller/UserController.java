package com.go4me.prototype.controller;

import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserRepository;
import com.go4me.prototype.model.UserRepositoryDetailsService;
import com.go4me.prototype.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@SuppressWarnings("unused")
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/profile/{username}")
    public String userPanelView(@RequestParam(name="username") String username,
                                @RequestParam(name="rating", required=false, defaultValue="empty") String rating, Model model) {
        User user = userService.searchByUserName(username);
        if (!rating.equals("empty")){
            user.setRating(user.getRating() + Double.parseDouble(rating));
            user.setNumberOfRatings(user.getNumberOfRatings() + 1);
            userService.update(user);
        }
        model.addAttribute("myUser", false);
        model.addAttribute("User", user);
        return "userpanel";
    }

    @GetMapping("profile/config/")
    public String editUser(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("User", auth.getPrincipal());
        return "configuser";
    }

    @GetMapping("/register")
    public String registerPanelView(User newUser, Model model){
        model.addAttribute("user", newUser);
        return "registerUser";
    }

    @PostMapping("/profile/config/")
    public String updateUser(@Valid User modifiedUser, BindingResult result, Model model){
        userService.update(modifiedUser);
        model.addAttribute("create", true);
        return userPanelView(modifiedUser.getUserName(), "empty", model);
    }

    @GetMapping("/profile")
    public String ownUserPanelView(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("myUser", true);
        model.addAttribute("User", userService.searchByUserName(user.getUserName()));
        return "userpanel";
    }
}
