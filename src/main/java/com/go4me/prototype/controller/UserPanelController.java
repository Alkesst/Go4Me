package com.go4me.prototype.controller;

import com.go4me.prototype.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserPanelController {
    @Autowired
    UserService userService;

    @GetMapping("/profile/{username}")
    public String userPanelView(@PathVariable("username") String username, Model model) {
        model.addAttribute("User", userService.searchByUserName(username));
        return "userpanel";
    }

    @GetMapping("profile/config/{id}")
    public String editUser(@PathVariable("id") String id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("User", userService.searchByid(Long.valueOf(id)));
        return "configuser";
    }
}