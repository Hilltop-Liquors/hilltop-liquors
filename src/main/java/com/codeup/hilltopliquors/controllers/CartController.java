package com.codeup.hilltopliquors.controllers;
import com.codeup.hilltopliquors.models.Order;
import com.codeup.hilltopliquors.models.OrderProduct;
import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.User;
import com.codeup.hilltopliquors.repositories.*;
import com.codeup.hilltopliquors.security.UserRegistrationDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public CartController(OrderRepository orderDao, ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao, UserRepository userDao,  OrderProductRepository orderProductDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
        this.userDao = userDao;
        this.orderProductDao = orderProductDao;
    }
    @ModelAttribute("order")
    public Order order(){
        Order newOrder = new Order();
//        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        newOrder.setCreatedAt(timestamp);
//        newOrder.setUser(user);
        return newOrder;
    }

    @PostMapping("/add/{productId}")
    public String addToCart(Model model, @PathVariable("productId") Long id, @ModelAttribute("order") Order userOrder, Authentication auth) {
        System.out.println(userOrder.getId() + " " + userOrder.getCreatedAt());
//        User user =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Product product = productDao.getOne(id);
//
//        Order newOrder = new Order();
//
        String username = auth.getName();
        User currentUser = userDao.findByUsername(username);

//        connect the user to the order
        userOrder.setUser(currentUser);


//
//        Instant instant = Instant.now();
//        Timestamp timestamp = Timestamp.from(instant);
//        newOrder.setCreatedAt(timestamp);
//        newOrder.setUser(user);
//
//        orderDao.save(newOrder);
        List<OrderProduct> cart = new ArrayList<>();
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(product);
        orderProduct.setQuantity(1);
        orderProduct.setOrder(userOrder);
//        WE NEED TO SAVE TOOOOO INSTANTIATE AN ORDER
        orderDao.save(userOrder);
        orderProductDao.save(orderProduct);
        cart.add(orderProduct);
//        shoppingUser.setId(userId);
        userOrder.setOrderProducts(cart);


//        model.addAttribute("user", currentUser);
        model.addAttribute("newOrder", userOrder);
        return "search/search";
    }


    @GetMapping("/Cart")
    public String showCart(Model model,@ModelAttribute ("order") Order userOrder, Authentication authentication) {
//        List<OrderProduct> orderProducts = orderProductDao.findAll();

      //  List<OrderProduct> orderProducts = orderProductDao.findAllByOrderById();
        String username = authentication.getName();
        User currentUser = userDao.findByUsername(username);
        Long userId = currentUser.getId();

//        List<OrderProduct> orderProducts = orderProductDao.findAllByOrderProductsOrderUserId(userId);
        List<Order> orders = orderDao.findAllByUserId(userId);
        System.out.println("THIS IS WHAT WE'RE LOOKING FOR " + orders.toString());



        List<OrderProduct> orderProducts = (List<OrderProduct>) orderDao.findAllByUserId(userId);

//        We Need to get orderproducts by orderiD

//        vModel.addAttribute("order", new Order());
//        System.out.println("THIS IS THE SOUT:" + currentUser);
//        System.out.println("HOWDY PARTNERS: " +orderProducts);
        model.addAttribute("cart", orders);
        model.addAttribute("user", currentUser);
//        We need to target orders where user = CURRENT
        return "cart";
    }
}