package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import jdk.swing.interop.SwingInterOpUtils;
import org.apache.poi.ss.usermodel.charts.ScatterChartData;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


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
    public Order order(HttpServletRequest request) {
        Order order = new Order();
        if (request.getSession().getAttribute("order") == null) {
            order = new Order();
        } else {
            order = (Order) request.getSession().getAttribute("order");
        }
        request.getSession().setAttribute("order", order);

        return order;
    }

    @ModelAttribute("orderDetails")
    public List<String> orderDetails(HttpServletRequest request) {
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

//        BigDecimal price;
//        for (Product cartItem : cart) {
//            long itemPrice = cartItem.getPriceInCents()/ 100;
//            price = new BigDecimal(Math.round(itemPrice));
//            cartItem.setPriceInCents(Integer.parseInt(String.valueOf(price)));
//        }

        int total = 0;
        for (Product cartItem : cart) {
            total += cartItem.getPriceInCents();
        }

//        model.addAttribute("price", price);
        model.addAttribute("total", total);
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
    public String saveCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, String pickUpDate, String isCurbside, String pickupTime, @SessionAttribute("order") Order order) {
        orderDetails.add(pickUpDate);
        orderDetails.add(pickupTime);
//        orderDetails.add(isCurbside);

//        Null POINTER EXCEPTION
        boolean pickupType = false;
        if (isCurbside.equals("on")) {
            pickupType = true;
            orderDetails.add(String.valueOf(pickupType));
        }


        List<String> titles = new ArrayList<>();
        titles.add("Pickup Date");
        titles.add("Pickup Time");

        model.addAttribute("titles", titles);
        model.addAttribute("orderDetails", orderDetails);

        int total = 0;
        for (Product cartItem : cart) {
            total = +cartItem.getPriceInCents();
        }

//        SETTING CURBSIDE
        order.setIsCurbside(pickupType);
        order.setTotalInCents(total);


        System.out.println(orderDetails);
        model.addAttribute("cart", cart);
        model.addAttribute("total", total);
        return "cart/cart-checkout-receipt";
    }


    //  CHECKOUT STOP 2
    @GetMapping("/Cart/checkout-receipt")
    public String getCheckoutReceipt(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, @SessionAttribute("order") Order order) {
        model.addAttribute("cart", cart);

        System.out.println("ORDER DETAILS" + orderDetails);
        System.out.println("ORDER" + order);

        return "cart/cart-checkout-receipt";
    }

    // POST MAPPING FOR SAVE ORDER AND SEND EMAIL
    @PostMapping("/Cart/checkout-receipt")
    public String saveCheckoutOrder
    (@SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, @SessionAttribute("order") Order order) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       User authUser = userDao.findByUsername(auth.getName());

        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        order.setCreatedAt(timestamp);
        order.setUser(authUser);

        orderDao.save(order);

        System.out.println("CREATED AT " + order.getCreatedAt());
        System.out.println("IS CURBSIDE "+ order.getIsCurbside());
        System.out.println("FULLFILLED " + order.getOrderIsFulfilled());
        System.out.println("TOTAL IN CENTS " + order.getTotalInCents());
        System.out.println("USER ID " + order.getUser());

//        System.out.println("ID " + authUser.getId() + "USERNAME " +authUser.getUsername());

        System.out.println("Auth what is here" + auth.getName());
        System.out.println("WHAT IS IN HERE " + order);
        System.out.println("WHAT TIME IS IT!!!!!!!!!! " + timestamp);
//    System.out.println("HERE WE ARE" + pickUpDate);
//    System.out.println("HERE WE ARE" + isCurbside);
//    System.out.println("HERE WE ARE" + pickupTime);

        cart.clear();
        orderDetails.clear();

        return "redirect:/Home?success";
    }


}