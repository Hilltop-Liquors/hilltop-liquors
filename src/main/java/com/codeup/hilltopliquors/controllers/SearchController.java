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
public class SearchController {

        private final ProductRepository productDao;
        private final SubcategoryRepository subCatDao;
        private final CategoryRepository catDao;
        private final ProductTypeRepository productTypeDao;

        public SearchController(ProductRepository productDao, SubcategoryRepository subCatDao, CategoryRepository catDao, ProductTypeRepository productTypeDao){
                this.productDao = productDao;
                this.subCatDao = subCatDao;
                this.catDao = catDao;
                this.productTypeDao = productTypeDao;
        }

//        GET ALL POSTS
        @GetMapping("/Search")
        public String getProducts(Model model, String keyword){
                List<Product> products = productDao.findAll();

                if(keyword != null){
                        model.addAttribute("products", productDao.findByKeyWord(keyword));
                }
                else {
                        model.addAttribute("products", products);
                }

                return "search/search";
        }

}
