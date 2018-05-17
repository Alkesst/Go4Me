package com.go4me.prototype.controller;


import com.go4me.prototype.model.AdsOrderService;
import com.go4me.prototype.model.OrderRequest;
import com.go4me.prototype.model.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class OrderRequestController {
    @Autowired
    OrderService orderService;

    @Autowired
    AdsOrderService adsOrderService;

    @GetMapping("/search")
    public String searchOrderRequests(@RequestParam(name="lat", required=true) double latitude,
     @RequestParam(name="long", required=true) double longitude, Model model){
        model.addAttribute("AdsOrder", adsOrderService.getAll());
        return "searchorder";
    }

    @GetMapping("/neworder")
    public String newOrderView(OrderRequest order, Model model){
        model.addAttribute("newOrder", order);
        //order.setMaxTime(orderService.parseToDate(order.getDay(), order.getMonth(), order.getHour()));
        return "neworderview";
    }

    @GetMapping("/order/{id}")
    public String orderPanel(@PathVariable("id") Long id, Model model){
        model.addAttribute("myOrder",false);
        model.addAttribute("Order", orderService.getOrderById(id));
        return "orderpanel";
    }


    @GetMapping("/order/")
    public String ownOrderPanel(Long id, Model model){
        model.addAttribute("myOrder", true);
        model.addAttribute("Order", orderService.getOrderById(id));
        return "orderpanel";
    }

}
