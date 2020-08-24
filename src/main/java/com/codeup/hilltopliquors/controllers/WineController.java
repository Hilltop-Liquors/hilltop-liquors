package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Category;
import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.repositories.CategoryRepository;
import com.codeup.hilltopliquors.repositories.ProductRepository;
import com.codeup.hilltopliquors.repositories.ProductTypeRepository;
import com.codeup.hilltopliquors.repositories.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WineController {

    private final ProductRepository productDao;
    private final SubcategoryRepository subCatDao;
    private final CategoryRepository catDao;
    private final ProductTypeRepository productTypeDao;

    public WineController(ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao) {
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
    }

    //        WINE
    //        GET ALL POSTS and SEARCH BAR
    @GetMapping("/Wine")
    public String getWineProducts(Model model, String keyword) {
        List<Product> products = productDao.findAllBySubCategoryCategoryProductTypeId(3);
        List<Category> catTags = catDao.findCategoriesByProductTypeId(3);


        if (keyword != null) {
            model.addAttribute("products", productDao.findByKeyWord(keyword));
            model.addAttribute("keyword", "Search results for: " + keyword);
        } else {
            model.addAttribute("products", products);
        }
        model.addAttribute("catTags", catTags);
        model.addAttribute("products", products);

        return "search/wine";
    }
}
