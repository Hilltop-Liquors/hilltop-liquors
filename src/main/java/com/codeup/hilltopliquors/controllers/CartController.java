package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Controller
public class CartController {
    private final OrderRepository orderDao;
    private final ProductRepository productDao;
    private final SubcategoryRepository subCatDao;
    private final CategoryRepository catDao;
    private final ProductTypeRepository productTypeDao;
    private final UserRepository userDao;
    private final OrderProductRepository orderProductDao;

    public CartController(OrderRepository orderDao, ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao, UserRepository userDao, OrderProductRepository orderProductDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
        this.userDao = userDao;
        this.orderProductDao = orderProductDao;
    }

    @ModelAttribute("order")
    public Order order() {
        Order newOrder = new Order();
//        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        newOrder.setCreatedAt(timestamp);
//        newOrder.setUser(user);
        return newOrder;
    }


    @GetMapping("/Cart")
    public String showCart(Model model, @SessionAttribute("cart") List<Product> cart) {
        model.addAttribute("cart", cart);

        return "cart/cart";
    }

//    Will set name of values in modal and then call to save them on button click to database

    @PostMapping("/Cart")
    public String orderDetails(String pickUpDate, boolean isCurbside, String pickupTime) {
//        Order newOrder = new Order();
////        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Instant instant = Instant.now();
//        Timestamp timestamp = Timestamp.from(instant);
//        newOrder.setCreatedAt(timestamp);
//        System.out.println("WHAT TIME IS IT!!!!!!!!!! " + timestamp);
//        System.out.println("HERE WE ARE" + pickUpDate);
//        System.out.println("HERE WE ARE" + isCurbside);
//        System.out.println("HERE WE ARE" + pickupTime);

        return "cart/cart";
    }

    //  CHECKOUT STOP 1
    @GetMapping("/Cart/confirm-details")
    public String getCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart) {
        model.addAttribute("cart", cart);

        return "cart/cart-checkout-details";
    }

    @PostMapping("/Cart/confirm-details")
    public String saveCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, String pickUpDate, boolean isCurbside, String pickupTime) {
        Order newOrder = new Order();
//        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        newOrder.setCreatedAt(timestamp);
        System.out.println("WHAT TIME IS IT!!!!!!!!!! " + timestamp);
        System.out.println("HERE WE ARE" + pickUpDate);
        System.out.println("HERE WE ARE" + isCurbside);
        System.out.println("HERE WE ARE" + pickupTime);

        model.addAttribute("cart", cart);

        return "cart/cart-checkout-receipt";
    }

    //  CHECKOUT STOP 2
    @GetMapping("/Cart/checkout-receipt")
    public String getCheckoutReceipt(Model model, @SessionAttribute("cart") List<Product> cart) {
        model.addAttribute("cart", cart);

        return "cart/cart";
    }

    @PostMapping("/Cart/checkout-receipt")
    public String saveCheckoutOrder(@SessionAttribute("cart") List<Product> cart) {
//        List<Product> cart;
        cart.clear();



//        else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }

        return "cart/cart";
    }


}