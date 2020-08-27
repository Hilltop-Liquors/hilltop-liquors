package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
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
    public String orderDetails(Model model, Long delete, Long quantityBtnPlus, Long quantityBtnMinus, @SessionAttribute("cart") List<Product> cart) {

//        cart.removeIf(cartItem -> delete.equalsIgnoreCase(cartItem.getName()));

        cart.removeIf(cartItem -> delete.equals(cartItem.getSku()));

//            assert quantityBtnMinus != null;
//            assert quantityBtnPlus != null;


        System.out.println(quantityBtnMinus);
        System.out.println(quantityBtnPlus);

//            for (Product cartItem : cart) {
//                int minus = cartItem.getInStoreCount();
//                if (quantityBtnMinus == cartItem.getSku()) {
//                    int minusCalc = minus - 1;
//                    if (minusCalc > 0) {
//                        cartItem.setInStoreCount(minusCalc);
//                    } else if (minusCalc < 0) {
//                        cartItem.setInStoreCount(minus);
//                    }
//                }
//
//
////                if (quantityBtnPlus != null) {
////            for (Product cartItem : cart) {
//                    int plus = cartItem.getInStoreCount();
//                    int plusCalc = plus + 1;
//                    if (quantityBtnPlus == cartItem.getSku()) {
//                        cartItem.setInStoreCount(plusCalc);
//                    }
//                }


//            }
//            cart.add(null);
////            cart.retainAll(Collections.singleton(quantityBtnPlus));
//        }

//        if (quantityBtnMinus != null) {
//            for (Product cartItem : cart) {
//                int minus = cartItem.getInStoreCount();
//                if (quantityBtnMinus == cartItem.getSku()) {
//                    int minusCalc = minus - 1;
//                    if (minusCalc > 0) {
//                        cartItem.setInStoreCount(minusCalc);
//                    } else if (minusCalc < 0) {
//                        cartItem.setInStoreCount(minus);
//                    }
//                }
//                cartItem.setInStoreCount(minus);
//            }
//            cart.add(null);
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

        model.addAttribute("cart", cart);
        return "cart/cart";

    }


    //  CHECKOUT STOP 1
    @GetMapping("/Cart/confirm-details")
    public String getCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
        orderDetails.clear();
        model.addAttribute("cart", cart);

        return "cart/cart-checkout-details";
    }

    //    POST MAPPING FOR CONFIRM DETAILS
    @PostMapping("/Cart/confirm-details")
    public String saveCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, String pickUpDate, String isCurbside, String pickupTime) {
        orderDetails.add(pickUpDate);
        orderDetails.add(pickupTime);

        if (isCurbside.equals("on")) {
            orderDetails.add("curbside");
        } else if (isCurbside == null) {
            orderDetails.add("in-store");
        }


//    thymeleaf if cu

        System.out.println(orderDetails);
        model.addAttribute("cart", cart);

        return "cart/cart-checkout-receipt";
    }


    //  CHECKOUT STOP 2
    @GetMapping("/Cart/checkout-receipt")
    public String getCheckoutReceipt(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
        model.addAttribute("cart", cart);

//        String str[] = num.split(" ");

//        String time = String.valueOf(orderDetails.subList(0,1));
//        String wantCurbside = String.valueOf(orderDetails.subList(1,2));
//        String pickupDate = String.valueOf(orderDetails.subList(2,3));
//
//String orderString;
//        for(<l order : orderDetails){
////            System.out.println(order.toString());
//            System.out.println(order.split(","));
//        }

        //        String pickupDate = orderDetails.get(2);
////
//        System.out.println("TIME ===== " + time);
//        System.out.println("WANT CURBSIDE ===== " + wantCurbside);
//        System.out.println("PICKUP =======" + pickupDate);


//        model.addAttribute("pickupTime", time);
//        model.addAttribute("wantCurbside", wantCurbside);
//        model.addAttribute("pickupDate", pickupDate);

        List<String> titles = new ArrayList<>();
        titles.add("Pickup Date");
        titles.add("Pickup Time");
        titles.add("Type Pickup");

        System.out.println(titles);
        model.addAttribute("titles", titles);
        model.addAttribute("orderDetails", orderDetails);
//        System.out.println(orderDetails);

        return "cart/cart-checkout-receipt";
    }

    // POST MAPPING FOR SAVE ORDER AND SEND EMAIL
    @PostMapping("/Cart/checkout-receipt")
    public String saveCheckoutOrder
    (@SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
//        List<Product> cart;


        cart.clear();
        orderDetails.clear();


//        else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }

        return "redirect:/Home?success";
    }


}