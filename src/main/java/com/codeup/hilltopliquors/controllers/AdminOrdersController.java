package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Order;
import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/admin/fulfill")
    public String viewFulfillOrders(Model model) {
        List<Order> ordersToFill = orderDao.FindAllUnfulfilled();
        model.addAttribute("orders", ordersToFill);
        return "admin/fulfill-orders";
    }

    @PostMapping("/admin/fulfill/{id}")
        public String updateOrder(@ModelAttribute Order order, @PathVariable long id, Model model) {

        Order updatingOrder = orderDao.getOne(id);
        updatingOrder.setTotalInCents(order.getTotalInCents());
        updatingOrder.setOrderProducts(order.getOrderProducts());
        updatingOrder.setCreatedAt(order.getCreatedAt());
        updatingOrder.setUser(order.getUser());
        updatingOrder.setIsCurbside(order.getIsCurbside());
        updatingOrder.setOrderIsFulfilled(true);
        orderDao.save(updatingOrder);
        model.addAttribute("orderFilled", updatingOrder);
        return "redirect:/admin/fulfill?success";
    }


}
