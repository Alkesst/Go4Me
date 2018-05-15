package com.go4me.prototype.controller;

import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("User", userService.searchByUserName(username));
        return "userpanel";
    }

    @GetMapping("profile/config/{id:[\\d]+}")
    public String editUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("User", userService.searchByid(id));
        return "configuser";
    }

    @GetMapping("/register")
    public String registerPanelView(User newUser, Model model){
        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", newUser);
        return "registerUser";
    }

    @PostMapping("/profile/{username}")
    public String registerNewUser(@Valid User newUser, BindingResult result, Model model, @PathVariable("username") String username) {
        userService.add(newUser);
        model.addAttribute("create", true);
        return userPanelView(newUser.getUserName(), model);
    }

    @PostMapping("/profile/config/{id}")
    public String updateUser(@Valid User modifiedUser, BindingResult result, Model model, @PathVariable("id") Long id){
        userService.update(modifiedUser);
        model.addAttribute("create", true);
        return userPanelView(modifiedUser.getUserName(), model);
    }

}
