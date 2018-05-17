package com.go4me.prototype.controller;


import com.go4me.prototype.model.User;
import com.go4me.prototype.model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public RedirectView registerNewUser(@Valid User newUser, BindingResult result, Model model) {
        userService.register(newUser);
        model.addAttribute("create", true);
        return new RedirectView("/profile/" + newUser.getUserName());
    }

}
