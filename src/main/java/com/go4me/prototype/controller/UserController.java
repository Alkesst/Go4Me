package com.go4me.prototype.controller;

import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/profile/{username}")
    public String userPanelView(@PathVariable("username") String username, Model model) {
        model.addAttribute("myUser", false);
        model.addAttribute("User", userService.searchByUserName(username));
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
        return userPanelView(modifiedUser.getUserName(), model);
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
