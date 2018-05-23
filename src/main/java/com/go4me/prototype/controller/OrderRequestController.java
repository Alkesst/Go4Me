package com.go4me.prototype.controller;


import com.go4me.prototype.model.AdsOrderService;
import com.go4me.prototype.model.OrderRequest;
import com.go4me.prototype.model.OrderService;
import com.go4me.prototype.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class OrderRequestController {
    @Autowired
    OrderService orderService;

    @Autowired
    AdsOrderService adsOrderService;

    @GetMapping("/searchorders")
    public String searchOrderRequests(Model model) {
        model.addAttribute("OrderRequest", orderService.getAll());
        return "searchorder";
    }

    @GetMapping("/neworder")
    public String newOrderView(OrderRequest order, Model model) {
        model.addAttribute("newOrder", order);
        return "neworderview";
    }

    @GetMapping("/order/{id}")
    public String orderPanel(@PathVariable("id") Long id, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderRequest order = orderService.getOrderById(id);
        model.addAttribute("isMyOrder", order.getPublishedBy().getUserName().equals(user.getUserName()));
        model.addAttribute("Order", order);
        model.addAttribute("isAssigned", order.getBuyer() != null);
        model.addAttribute("isVerifiedBySeller", order.isVerifiedBySeller() == 1);
        model.addAttribute("isVerifiedByBuyer", order.isVerifiedByBuyer() == 1);
        return "orderpanel";
    }

    @PostMapping("/order/{id}")
    public RedirectView deleteOrder(@Valid OrderRequest order, Model model) {
        orderService.delete(order);
        return new RedirectView("/searchorders");
    }


    @PostMapping("/searchorders/")
    public RedirectView assignOrder(@Valid OrderRequest order,
                                    @RequestParam(name = "id", required = false, defaultValue = "empty") String id, Model model) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        orderService.assignOrder(orderService.getOrderById(Long.parseLong(id)), user.getId());
        return new RedirectView("/searchorders");
    }

    @PostMapping("/neworder")
    public RedirectView registerNewUser(@Valid OrderRequest neworder, BindingResult result, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        orderService.add(neworder, user.getId());
        model.addAttribute("create", true);
        return new RedirectView("/order/" + neworder.getID());
    }

    @PostMapping("/index/")
    public RedirectView verifyOrder(@RequestParam(name = "id", required = false, defaultValue = "empty") Long id,
                                    Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderRequest order = orderService.getOrderById(id);
        User buyer = order.getBuyer();
        User seller = order.getSeller();
        orderService.verifyUsers(order, user, buyer, seller);
        return new RedirectView("/searchorders");
    }

}
