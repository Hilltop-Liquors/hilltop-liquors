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
public class ExtrasController {
    private final ProductRepository productDao;
    private final SubcategoryRepository subCatDao;
    private final CategoryRepository catDao;
    private final ProductTypeRepository productTypeDao;

    public ExtrasController(ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao) {
        this.productDao = productDao;
        this.subCatDao = subCatDao;
        this.catDao = catDao;
        this.productTypeDao = productTypeDao;
    }

    //        Extras
    //        GET ALL POSTS and SEARCH BAR
    @GetMapping("/Extras")
    public String getExtrasProducts(Model model, String keyword) {
//        How to target productType ids 5 and 6?
        List<Product> products = productDao.findAllBySubCategoryCategoryProductTypeId(6);
        List<Category> catTags = catDao.findCategoriesByProductTypeId(6);

        if (keyword != null) {
            model.addAttribute("products", productDao.findByKeyWord(keyword));
            model.addAttribute("keyword", "Search results for: " + keyword);
        } else {
            model.addAttribute("products", products);
        }
        model.addAttribute("catTags", catTags);
        model.addAttribute("products", products);

        return "search/extras";
    }


}
