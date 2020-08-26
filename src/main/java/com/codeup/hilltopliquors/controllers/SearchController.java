package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Category;
import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.ProductType;
import com.codeup.hilltopliquors.models.Subcategory;
import com.codeup.hilltopliquors.repositories.CategoryRepository;
import com.codeup.hilltopliquors.repositories.ProductRepository;
import com.codeup.hilltopliquors.repositories.ProductTypeRepository;
import com.codeup.hilltopliquors.repositories.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/cart")
public class SearchController {

    private final ProductRepository productDao;
    private final SubcategoryRepository subCatDao;
    private final CategoryRepository catDao;
    private final ProductTypeRepository productTypeDao;

    public SearchController(ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao) {
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
    }

    //        GET ALL POSTS and SEARCH BAR
    @GetMapping("/Search")
    public String getProducts(Model model, String keyword) {
        List<Product> products = productDao.findAll();
        List<ProductType> productTypes = productTypeDao.findAll();
        List<Category> categories = catDao.findAll();
        List<Subcategory> subCategories = subCatDao.findAll();

        if (keyword != null) {
            model.addAttribute("products", productDao.findByKeyWord(keyword));
            model.addAttribute("keyword", "Search results for: " + keyword);
        } else {
            model.addAttribute("products", products);
        }

        model.addAttribute("productTypes", productTypes);
        model.addAttribute("categories", categories);

        return "search/search";
    }

    @PostMapping("/Search")
    public String addToCart(Model model, @SessionAttribute("cart") List<Product> cart, long productId, String keyword) {
//        List<Product> cart;
//        cart = (List<Product>) request.getSession().getAttribute("cart");
        List<Product> products = productDao.findAll();
        List<ProductType> productTypes = productTypeDao.findAll();
        List<Category> categories = catDao.findAll();
        List<Subcategory> subCategories = subCatDao.findAll();

        if (keyword != null) {
            model.addAttribute("products", productDao.findByKeyWord(keyword));
            model.addAttribute("keyword", "Search results for: " + keyword);
        } else {
            model.addAttribute("products", products);
        }

        model.addAttribute("productTypes", productTypes);
        model.addAttribute("categories", categories);

        Product product = productDao.getOne(productId);
        cart.add(product);
        System.out.println("THE DAMN CART: " + cart);
        return "search/search";
    }


}


