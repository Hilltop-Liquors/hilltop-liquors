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
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        newOrder.setCreatedAt(timestamp);

        return newOrder;
    }

    @ModelAttribute("orderDetails")
    public List<String> order(HttpServletRequest request) {
        List<String> orderDetails;
        if (request.getSession().getAttribute("orderDetails") == null) {
            orderDetails = new ArrayList<>();
        } else {
            orderDetails = (List<String>) request.getSession().getAttribute("orderDetails");
        }
        request.getSession().setAttribute("orderDetails", orderDetails);
        return orderDetails;
    }


    @GetMapping("/Cart")
    public String showCart(Model model, @SessionAttribute("cart") List<Product> cart) {
        model.addAttribute("cart", cart);
        return "cart/cart";
    }

//    Will set name of values in modal and then call to save them on button click to database

    @PostMapping("/Cart")
    public String orderDetails(Model model ,String delete, @SessionAttribute("cart") List<Product> cart) {
        model.addAttribute("cart", cart);

        cart.removeIf(cartItem -> delete.equalsIgnoreCase(cartItem.getName()));

//        if (cart == null) {
//            request.getSession().setAttribute("cart", cart);
//        }



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
    public String saveCheckoutDetails( Model model ,@SessionAttribute("cart") List<Product> cart ,@SessionAttribute("orderDetails") List<String> orderDetails, String pickUpDate, String isCurbside, String pickupTime) {
        orderDetails.add(pickupTime);
        orderDetails.add(isCurbside);
        orderDetails.add(pickUpDate);

        System.out.println(orderDetails);
        model.addAttribute("cart", cart);

        return "cart/cart-checkout-receipt";
    }

    //  CHECKOUT STOP 2
    @GetMapping("/Cart/checkout-receipt")
    public String getCheckoutReceipt(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("cart", cart);

        System.out.println(orderDetails);

        return "cart/cart";
    }

    @PostMapping("/Cart/checkout-receipt")
    public String saveCheckoutOrder(@SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
//        List<Product> cart;
        cart.clear();
        orderDetails.clear();



//        else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }

        return "redirect:/Home?success";
    }


}