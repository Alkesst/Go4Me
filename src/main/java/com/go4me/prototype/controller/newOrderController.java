package com.go4me.prototype.controller;

import com.go4me.prototype.model.OrderRequest;
import com.go4me.prototype.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

public class newOrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public RedirectView newOrderViewPanel(@Valid OrderRequest newOrder, BindingResult result, Model model){
        orderService.add(newOrder);
        model.addAttribute("create", true);
        return new RedirectView("/order/" + newOrder.getID());
    }
}
