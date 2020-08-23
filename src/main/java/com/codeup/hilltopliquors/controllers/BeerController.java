package com.codeup.hilltopliquors.controllers;

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
public class BeerController {

        private final ProductRepository productDao;
        private final SubcategoryRepository subCatDao;
        private final CategoryRepository catDao;
        private final ProductTypeRepository productTypeDao;

        public BeerController(ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao) {
            this.productDao = productDao;
            this.subCatDao = subCatDao;
            this.catDao = catDao;
            this.productTypeDao = productTypeDao;
        }

        //        BEER
        //        GET ALL POSTS and SEARCH BAR
        @GetMapping("/Beer")
        public String getBeerProducts(Model model, String keyword) {
            List<Product> products = productDao.findAllBySubCategoryCategoryProductTypeId(1);

            if (keyword != null) {
                model.addAttribute("products", productDao.findByKeyWord(keyword));
                model.addAttribute("keyword", "Search results for: " + keyword);
            } else {
                model.addAttribute("products", products);
            }

            model.addAttribute("products", products);

            return "search/beer";
        }


}
