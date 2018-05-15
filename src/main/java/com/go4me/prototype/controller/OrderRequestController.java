package com.go4me.prototype.controller;


import com.go4me.prototype.model.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderRequestController {
    @Autowired
    OrderService orderService;

    @Autowired
    AdsOrderSevice adsOrderService;

    @GetMapping("search")
    public String searchOrderRequests(@RequestParam(name="lat", required=true) double latitude,
     @RequestParam(name="long", required=true) double longitude, Model model){
        model.addAttribute("AdsOrder", adsOrderService.getAll());
        return "searchorder";
    }

}