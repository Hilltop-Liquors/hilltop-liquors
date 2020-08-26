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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
@SessionAttributes("cart")
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


//    @ModelAttribute("cart")
//    public List<Product> cart(List<Product> cart) {
//        return  cart;
//    }


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

//    public String addToCart(@ModelAttribute Product product, @ModelAttribute("cart") List<Product> cart, RedirectAttributes attributes) {
//        cart.add(product);
//        attributes.addFlashAttribute("cart", cart);
//        return String.valueOf(new RedirectView("/sessionattributes/cart.html"));
//    }
//        ========== was using
    @PostMapping("/{productId}")
    public String addToCart(Model model, @SessionAttribute("cart") List<Product> cart, @PathVariable("productId") Long id) {
//        List<Product> cart;
//        cart = (List<Product>) request.getSession().getAttribute("cart");
        Product product = productDao.getOne(id);
        cart.add(product);
        return "cart";
    }

//  ===============      =====================
//        if (request.getSession().getAttribute("cart") == null) {
//            cart = new ArrayList<>();
//        } else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }
//        request.getSession().setAttribute("cart", cart);
//
//        System.out.println(cart);
//        model.addAttribute("cart", cart);
//=============   =======================


//        Have to redirect to cart because on /cart

//    }

    @GetMapping("/Cart")
    public String showForm(
            Model model,
            @SessionAttribute("cart") List<Product> cart) {
//        List<Product> cart;
//        cart = (List<Product>) request.getSession().getAttribute("cart");
//        Product product = productDao.getOne(id);
//        cart.add(product);
//        if (!todos.isEmpty()) {
//            model.addAttribute("
//        } else {
//            model.addAttribute("
//        }
        model.addAttribute("cart", cart);
        return "cart";
    }

//    @GetMapping("/Cart")
//    public String showCart(Model model, @ModelAttribute("cart") List<Product> cart) {

//        List<Product> cart;
//        List<Product> cart = (List<Product>)
//        cart = (List<Product>) session.getAttribute("cart");
//                session.getAttribute("cart");

//        List<Product> cart;
//        if (request.getSession().getAttribute("cart") == null) {
//            cart = new ArrayList<>();
//        } else {
//            cart = (List<Product>) request.getSession().getAttribute("cart");
//        }
//        request.getSession().setAttribute("cart", cart);
//
//        List<Product> cart;
//        cart = (List<Product>) response.
//                getSession().getAttribute("cart");
//        model.addAttribute("cart", cart);

//        return "cart";
//    }

//    @PostMapping("/Cart")
//    public String addToCart(Model model, HttpServletRequest request) {
//        List<Product> cart;
//        cart = (List<Product>) request.getSession().getAttribute("cart");
//        model.addAttribute("cart", cart);
//        return "cart";
//    }

}