package com.codeup.hilltopliquors.controllers;
import com.codeup.hilltopliquors.models.*;
import com.codeup.hilltopliquors.repositories.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("cart")
public class HomeController {


    @Value("${cocktail.api.key}")
    private String cocktailApiKey;

    public final UserRepository userDao;
    private final ProductRepository productDao;
    private final SubcategoryRepository subCatDao;
    private final CategoryRepository catDao;
    private final ProductTypeRepository productTypeDao;

    public HomeController(UserRepository userDao, ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
    }


//    public HomeController(UserRepository userDao) {
//        this.userDao = userDao;
//    }

    @GetMapping("/")
    public String showLanding(HttpServletRequest request) {
        request.getSession().invalidate();
        return "landing";
    }

    @ModelAttribute("cart")
    public String showHome(HttpServletRequest request) {
        List<Product> cart;
        if (request.getSession().getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<Product>) request.getSession().getAttribute("cart");
        }
        request.getSession().setAttribute("cart", cart);
        return "cart";
    }

    @GetMapping("/Home")
    public String showHome(Model model, String keyword, Integer catId, Integer subId, Integer productTypeId, Long ProductId) {
        model.addAttribute("cocktailApiKey", cocktailApiKey);

            List<Product> products = productDao.findAll();
            List<ProductType> productTypes = productTypeDao.findAll();
            List<Category> categories = catDao.findAll();
            List<Subcategory> subCategories = subCatDao.findAll();

//      CATEOGRY TAGS
            List<Product> catProducts = productDao.findAllBySubCategoryCategoryId(catId);
//      SUB-CAT TAGS
            List<Product> subProducts = productDao.findAllBySubCategoryId(subId);

//        SEARCH BOX
            if (keyword != null) {
                model.addAttribute("products", productDao.findByKeyWord(keyword));
                model.addAttribute("keyword", "Search results for: " + keyword);
            } else if (catId != null) {
                model.addAttribute("catProducts", catProducts);
                model.addAttribute("subProducts", subProducts);
            } else if (subId != null) {
                System.out.println(subId);
                model.addAttribute("catProducts", catProducts);
                model.addAttribute("subProducts", subProducts);
            } else if (productTypeId != null){
                model.addAttribute("catProducts", catProducts);
                model.addAttribute("subProducts", subProducts);
            } else {
                model.addAttribute("products", products);
            }

            model.addAttribute("productTypes", productTypes);
            model.addAttribute("categories", categories);

//            return "home/home";


        return "home";
    }

//    @GetMapping("/About")
//    public String showAbout() {
//
//        return "about";
//    }
    @GetMapping("/AboutUs")
    public String showAboutUs() {

        return "aboutUs";
    }

    @GetMapping("/Developers")
    public String showDevelopers(){
        return "developers";
    }

    @GetMapping("/EventSupply")
    public String showCatering() {
        return "eventSupply";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    //        GET ALL POSTS and SEARCH BAR
//    @GetMapping("/HomeShop")
//    public String getProducts(Model model, String keyword, Integer catId, Integer subId, Integer productTypeId, Long ProductId) {
//        List<Product> products = productDao.findAll();
//        List<ProductType> productTypes = productTypeDao.findAll();
//        List<Category> categories = catDao.findAll();
//        List<Subcategory> subCategories = subCatDao.findAll();
//
////      CATEOGRY TAGS
//        List<Product> catProducts = productDao.findAllBySubCategoryCategoryId(catId);
////      SUB-CAT TAGS
//        List<Product> subProducts = productDao.findAllBySubCategoryId(subId);
//
////        SEARCH BOX
//        if (keyword != null) {
//            model.addAttribute("products", productDao.findByKeyWord(keyword));
//            model.addAttribute("keyword", "Search results for: " + keyword);
//        } else if (catId != null) {
//            model.addAttribute("catProducts", catProducts);
//            model.addAttribute("subProducts", subProducts);
//        } else if (subId != null) {
//            System.out.println(subId);
//            model.addAttribute("catProducts", catProducts);
//            model.addAttribute("subProducts", subProducts);
//        } else if (productTypeId != null){
//            model.addAttribute("catProducts", catProducts);
//            model.addAttribute("subProducts", subProducts);
//        } else {
//            model.addAttribute("products", products);
//        }
//
//        model.addAttribute("productTypes", productTypes);
//        model.addAttribute("categories", categories);
//
//        return "home/home";
//    }

    @PostMapping("/Home")
    public String addToCart(HttpServletRequest request, Model model, @SessionAttribute("cart") List<Product> cart, Long productId) {
        List<Product> products = productDao.findAll();
        model.addAttribute("products", products);

        if (request.getSession().getAttribute("cart") == null) {
            cart = new ArrayList<>();
        } else {
            cart = (List<Product>) request.getSession().getAttribute("cart");
        }


        Product product = productDao.getOne(productId);
        cart.add(product);
        request.getSession().setAttribute("cart", cart);
//        return "search/search";
        return  "redirect:/Home?success";
    }



}