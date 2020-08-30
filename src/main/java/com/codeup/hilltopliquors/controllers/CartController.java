package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import com.codeup.hilltopliquors.services.EmailService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
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
    private final EmailService emailService;

    public CartController(OrderRepository orderDao, ProductRepository productDao, SubcategoryRepository subCatDao,
                          CategoryRepository catDao, ProductTypeRepository productTypeDao, UserRepository userDao,
                          OrderProductRepository orderProductDao, EmailService emailService) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
        this.userDao = userDao;
        this.orderProductDao = orderProductDao;
        this.emailService = emailService;
    }

    @ModelAttribute("order")
    public Order order(HttpServletRequest request) {
        Order order = new Order();
        if (request.getSession().getAttribute("order") == null) {
            order = new Order();
        } else {
            order = (Order) request.getSession().getAttribute("order");
        }

        System.out.println(order);

        request.getSession().setAttribute("order", order);

        return order;
    }

    @ModelAttribute("orderProduct")
    public OrderProduct orderProduct(HttpServletRequest request) {
        OrderProduct orderProduct = new OrderProduct();
        if (request.getSession().getAttribute("orderProduct") == null) {
            orderProduct = new OrderProduct();
        } else {
            orderProduct = (OrderProduct) request.getSession().getAttribute("orderProduct");
        }
        request.getSession().setAttribute("orderProduct", orderProduct);

        return orderProduct;
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

        System.out.println("incard");

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
            total += cartItem.getPriceInCents();
        }

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

        int total = 0;
        for (Product cartItem : cart) {
            total = +cartItem.getPriceInCents();
        }

        order.setTotalInCents(total);

        System.out.println("ORDER DETAILS" + orderDetails);
        System.out.println("ORDER" + order);

        return "cart/cart-checkout-receipt";
    }

    // POST MAPPING FOR SAVE ORDER AND SEND EMAIL
    @PostMapping("/Cart/checkout-receipt")
    public String saveCheckoutOrder
    (HttpServletRequest request, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails,
     @SessionAttribute("order") Order order, @SessionAttribute("orderProduct") OrderProduct orderProduct) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User authUser = userDao.findByUsername(auth.getName());


        List<OrderProduct> orderProducts = new ArrayList<>();

        System.out.println(order);
        if(order.getOrderProducts() == null) {
            order.setOrderProducts(orderProducts);
        }

//       try{
//           order.getId();
//       }catch(Exception e) {
//           e.printStackTrace();
//           orderDao.save(order);
//       }



        for (Product cartItem : cart) {
            OrderProduct addingProduct = new OrderProduct(1, order, cartItem);
            cartItem.getOrderProduct().add(addingProduct);
//            orderProducts.add(addingProduct);
            System.out.println("order.getId() = " + order.getId());
            order.getOrderProducts().add(addingProduct);
            System.out.println("order.getOrderProducts() = " + order.getOrderProducts());
//            productDao.save(cartItem);
//            orderProductDao.save(orderProduct);
        }

//        order.setOrderProducts(orderProducts);


//        Instant instant = Instant.now();
//        Timestamp timestamp = Timestamp.from(instant);
//        order.setCreatedAt(timestamp);
        order.setUser(authUser);


        orderDao.save(order);
        String[] recipients = new String[2];
        System.out.println("order.getUser().getEmail() = " + order.getUser().getEmail());
        recipients[0] = authUser.getEmail();
        recipients[1] = "hilltopliquorstx@gmail.com";
//        recipients[2] = "andrewbrought@gmail.com";
        String subject = authUser.getUsername() + "'s Order Receipt";

       List<String> items = new ArrayList<>();
        for(int i = 0; i < order.getOrderProducts().size(); i ++) {
             items.add(order.getOrderProducts().get(i).getProduct().getName() + "   " + order.getOrderProducts().get(i).getQuantity()
                    + "   $" + order.getOrderProducts().get(i).getProduct().getPriceInCents()/100 + "\n");

        }

        String body = authUser.getFirst_name() + " " + authUser.getLast_name() + ", \n"
                + "Thank you for joining us at the top! \nHere's Your Purchase Receipt: \n"
                + "\n" + authUser.getUsername() + "\n"
                + order.getId() + "\n"
                + order.getCreatedAt() + "\n"
                +" Items:                                               Qty:      Price:" + "\n"
                + items
                + "\n" + " Total: $" + order.getTotalInCents()/100 + "\n"
                + "\n Thank you for your purchase!";

        System.out.println("orderDetails = " + orderDetails.toString());
        emailService.prepareAndSend(recipients, subject, body);
        cart.clear();
        orderDetails.clear();
        request.getSession().removeAttribute("order");

        return "redirect:/Home?success";
    }


}



//@Controller
//public class CartController {
//    private final OrderRepository orderDao;
//    private final ProductRepository productDao;
//    private final SubcategoryRepository subCatDao;
//    private final CategoryRepository catDao;
//    private final ProductTypeRepository productTypeDao;
//    private final UserRepository userDao;
//    private final OrderProductRepository orderProductDao;
//
//    public CartController(OrderRepository orderDao, ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao, UserRepository userDao, OrderProductRepository orderProductDao) {
//        this.orderDao = orderDao;
//        this.productDao = productDao;
//        this.subCatDao = subCatDao;
//        this.catDao = catDao;
//        this.productTypeDao = productTypeDao;
//        this.userDao = userDao;
//        this.orderProductDao = orderProductDao;
//    }

//    @ModelAttribute("order")
//    public Order order(HttpServletRequest request) {
//        Order order = new Order();
//        if (request.getSession().getAttribute("order") == null) {
//            order = new Order();
//            Instant instant = Instant.now();
//            Timestamp timestamp = Timestamp.from(instant);
//            order.setCreatedAt(timestamp);
//            orderDao.save(order);
//        } else {
//            order = (Order) request.getSession().getAttribute("order");
//        }
//
//
//        request.getSession().setAttribute("order", order);
//
//        return order;
//    }
//
//    @ModelAttribute("orderProduct")
//    public OrderProduct orderProduct(HttpServletRequest request) {
//        OrderProduct orderProduct = new OrderProduct();
//        if (request.getSession().getAttribute("orderProduct") == null) {
//            orderProduct = new OrderProduct();
//        } else {
//            orderProduct = (OrderProduct) request.getSession().getAttribute("orderProduct");
//        }
//        request.getSession().setAttribute("orderProduct", orderProduct);
//
//        return orderProduct;
//    }
//
//
//    @ModelAttribute("orderDetails")
//    public List<String> orderDetails(HttpServletRequest request) {
//        List<String> orderDetails;
//        if (request.getSession().getAttribute("orderDetails") == null) {
//            orderDetails = new ArrayList<>();
//        } else {
//            orderDetails = (List<String>) request.getSession().getAttribute("orderDetails");
//        }
//        request.getSession().setAttribute("orderDetails", orderDetails);
//        return orderDetails;
//    }
//
//
//    @GetMapping("/Cart")
//    public String showCart(Model model, @SessionAttribute("cart") List<Product> cart) {
//
////        BigDecimal price;
////        for (Product cartItem : cart) {
////            long itemPrice = cartItem.getPriceInCents()/ 100;
////            price = new BigDecimal(Math.round(itemPrice));
////            cartItem.setPriceInCents(Integer.parseInt(String.valueOf(price)));
////        }
//
//        int total = 0;
//        for (Product cartItem : cart) {
//            total += cartItem.getPriceInCents();
//        }
//
////        model.addAttribute("price", price);
//        model.addAttribute("total", total);
//        model.addAttribute("cart", cart);
//        return "cart/cart";
//    }
//
////    Will set name of values in modal and then call to save them on button click to database
//
//    @PostMapping("/Cart")
//    public String orderDetails(Model model, Long delete, Long quantityBtnPlus, Long quantityBtnMinus, @SessionAttribute("cart") List<Product> cart) {
//
////        cart.removeIf(cartItem -> delete.equalsIgnoreCase(cartItem.getName()));
//
//        cart.removeIf(cartItem -> delete.equals(cartItem.getSku()));
//
////            assert quantityBtnMinus != null;
////            assert quantityBtnPlus != null;
//
//
//        System.out.println(quantityBtnMinus);
//        System.out.println(quantityBtnPlus);
//
////            for (Product cartItem : cart) {
////                int minus = cartItem.getInStoreCount();
////                if (quantityBtnMinus == cartItem.getSku()) {
////                    int minusCalc = minus - 1;
////                    if (minusCalc > 0) {
////                        cartItem.setInStoreCount(minusCalc);
////                    } else if (minusCalc < 0) {
////                        cartItem.setInStoreCount(minus);
////                    }
////                }
////
////
//////                if (quantityBtnPlus != null) {
//////            for (Product cartItem : cart) {
////                    int plus = cartItem.getInStoreCount();
////                    int plusCalc = plus + 1;
////                    if (quantityBtnPlus == cartItem.getSku()) {
////                        cartItem.setInStoreCount(plusCalc);
////                    }
////                }
//
//
////            }
////            cart.add(null);
//////            cart.retainAll(Collections.singleton(quantityBtnPlus));
////        }
//
////        if (quantityBtnMinus != null) {
////            for (Product cartItem : cart) {
////                int minus = cartItem.getInStoreCount();
////                if (quantityBtnMinus == cartItem.getSku()) {
////                    int minusCalc = minus - 1;
////                    if (minusCalc > 0) {
////                        cartItem.setInStoreCount(minusCalc);
////                    } else if (minusCalc < 0) {
////                        cartItem.setInStoreCount(minus);
////                    }
////                }
////                cartItem.setInStoreCount(minus);
////            }
////            cart.add(null);
////        }
//
//        model.addAttribute("cart", cart);
//        return "cart/cart";
//
//    }
//
//
//    //  CHECKOUT STOP 1
//    @GetMapping("/Cart/confirm-details")
//    public String getCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails) {
//        orderDetails.clear();
//        model.addAttribute("cart", cart);
//
//        return "cart/cart-checkout-details";
//    }
//
//    //    POST MAPPING FOR CONFIRM DETAILS
//    @PostMapping("/Cart/confirm-details")
//    public String saveCheckoutDetails(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, String pickUpDate, String isCurbside, String pickupTime, @SessionAttribute("order") Order order) {
//        orderDetails.add(pickUpDate);
//        orderDetails.add(pickupTime);
////        orderDetails.add(isCurbside);
//
////        Null POINTER EXCEPTION
//        boolean pickupType = false;
//        if (isCurbside.equals("on")) {
//            pickupType = true;
//            orderDetails.add(String.valueOf(pickupType));
//        }
//
//
//        List<String> titles = new ArrayList<>();
//        titles.add("Pickup Date");
//        titles.add("Pickup Time");
//
//        model.addAttribute("titles", titles);
//        model.addAttribute("orderDetails", orderDetails);
//
//        int total = 0;
//        for (Product cartItem : cart) {
//            total += cartItem.getPriceInCents();
//        }
//
//        order.setIsCurbside(pickupType);
//        order.setTotalInCents(total);
//
//
//        System.out.println(orderDetails);
//        model.addAttribute("cart", cart);
//        model.addAttribute("total", total);
//        return "cart/cart-checkout-receipt";
//    }
//
//
//    //  CHECKOUT STOP 2
//    @GetMapping("/Cart/checkout-receipt")
//    public String getCheckoutReceipt(Model model, @SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails, @SessionAttribute("order") Order order) {
//        model.addAttribute("cart", cart);
//
//        int total = 0;
//        for (Product cartItem : cart) {
//            total = +cartItem.getPriceInCents();
//        }
//
//        order.setTotalInCents(total);
//
//        System.out.println("ORDER DETAILS" + orderDetails);
//        System.out.println("ORDER" + order);
//
//        return "cart/cart-checkout-receipt";
//    }
//
//    // POST MAPPING FOR SAVE ORDER AND SEND EMAIL
//    @PostMapping("/Cart/checkout-receipt")
//    public String saveCheckoutOrder
//    (@SessionAttribute("cart") List<Product> cart, @SessionAttribute("orderDetails") List<String> orderDetails,
//     @SessionAttribute("order") Order order, @SessionAttribute("orderProduct") OrderProduct orderProduct) {
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User authUser = userDao.findByUsername(auth.getName());
//
//
//        List<OrderProduct> orderProducts = new ArrayList<>();
//
//
//        if(order.getOrderProducts() == null) {
//            order.setOrderProducts(orderProducts);
//        }
//
////      if(order.getId() == 0) {
////        Instant instant = Instant.now();
////        Timestamp timestamp = Timestamp.from(instant);
////        order.setCreatedAt(timestamp);
////          orderDao.save(order);
////      }
//
//
//        List<OrderProduct> check = new ArrayList<>();
//
//        for (Product cartItem : cart) {
//            OrderProduct addingProduct = new OrderProduct(1, order, cartItem);
//            cartItem.getOrderProduct().add(addingProduct);
////            orderProducts.add(addingProduct);
//            check.add(addingProduct);
////            order.getOrderProducts().add(addingProduct);
//
//            orderProduct.setOrder(order);
//            orderProduct.setProduct(cartItem);
////            productDao.save(cartItem);
//            orderProductDao.save(orderProduct);
//        }
//
//        order.setOrderProducts(check);
//
//
////        Instant instant = Instant.now();
////        Timestamp timestamp = Timestamp.from(instant);
////        order.setCreatedAt(timestamp);
//
//
//        order.setUser(authUser);
//        orderDao.save(order);
//
//        cart.clear();
//        orderDetails.clear();
//
//        return "redirect:/Home?success";
//    }

//    }