package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Order;
import com.codeup.hilltopliquors.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminOrdersController {

    private final OrderRepository orderDao;

    public AdminOrdersController(OrderRepository orderDao){
        this.orderDao = orderDao;
    }

    @GetMapping("/admin/orders")
    public String viewAllOrders(Model model){
        List<Order> storeOrders = orderDao.findAll();
        model.addAttribute("orders", storeOrders);
        return "admin/view-orders";
    }


}
