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
    public String getProducts(Model model, String keyword, Integer catId, Integer subId, Integer productTypeId, Long ProductId) {
        List<Product> products = productDao.findAll();
        List<ProductType> productTypes = productTypeDao.findAll();
        List<Category> categories = catDao.findAll();
        List<Subcategory> subCategories = subCatDao.findAll();

//        if (keyword != null) {
//            model.addAttribute("products", productDao.findByKeyWord(keyword));
//            model.addAttribute("keyword", "Search results for: " + keyword);
//        } else {
//            model.addAttribute("products", products);
//        }

//      CATEOGRY TAGS
        List<Product> catProducts = productDao.findAllBySubCategoryCategoryId(catId);
//      SUB-CAT TAGS
        List<Product> subProducts = productDao.findAllBySubCategoryId(subId);

//        SEARCH BOX
        if (keyword != null) {
            model.addAttribute("products", productDao.findByKeyWord(keyword));
            model.addAttribute("keyword", "Search results for: " + keyword);
        }
        if (catId != null) {
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

        return "search/search";
    }

    @PostMapping("/Search")
    public String addToCart(Model model, @SessionAttribute("cart") List<Product> cart, Long productId) {
        List<Product> products = productDao.findAll();

        model.addAttribute("products", products);

        Product product = productDao.getOne(productId);
        cart.add(product);
        return "search/search";
    }


}


