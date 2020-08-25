package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

//        only conditional logic is if there is not anything in their cart and if their cart has not been created yet then this is when we would create the cart in the session. Because when they first load up a session their session does not have a cart.

    // check if cart exists
    // if not set a cart in the session with one item
    // if it does exist, extract the cart and add a new item to it
        /*
            List<Product> cart;
            if (request.getSession().getAttribute("cart") == null) {
                cart = new ArrayList<>();
            } else {
                cart = request.getSession().getAttribute("cart");
            }
            cart.add the product to the cart
            request.getSession().setAttribute("cart", cart);
         */
    @PostMapping("/add/{productId}")
    public String addToCart(Model model, HttpServletRequest request, @PathVariable("productId") Long id, @ModelAttribute("order") Order userOrder) {

        List<Product> cart;
        cart = (List<Product>) request.getSession().getAttribute("cart");

        Product product = productDao.getOne(id);

        if (request.getSession().getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<Product>) request.getSession().getAttribute("cart");
        }
        request.getSession().setAttribute("cart", cart);

        cart.add(product);

//        System.out.println(cart);
//        model.addAttribute("cart", cart);

//        Have to redirect to cart because on /cart
        return "search/search";

    }

    @GetMapping("/Cart")
    public String showCart(Model model, HttpServletRequest request) {


//        List<Product> cart;
//        if (request.getSession().getAttribute("cart") == null) {
//            cart = new ArrayList<>();
//        } else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }
//        request.getSession().setAttribute("cart", cart);

//        List<Product> cart;
//        cart = (List<Product>) session.getAttribute("cart");
//        model.addAttribute("cart", cart);

        return "cart";
    }

}