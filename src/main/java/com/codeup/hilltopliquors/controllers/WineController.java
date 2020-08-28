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
        public String getLiquorProducts(Model model, String keyword, Integer catId, Integer subId, Integer productTypeId) {

//        NAV DISPLAY
            List<Product> products = productDao.findAllBySubCategoryCategoryProductTypeId(3);
            List<Category> catTags = catDao.findCategoriesByProductTypeId(3);

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

            model.addAttribute("catTags", catTags);

            return "search/wine";
        }


    }
