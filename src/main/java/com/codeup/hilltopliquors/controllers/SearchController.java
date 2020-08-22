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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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

//        GET ALL POSTS and SEARCH BAR
        @GetMapping("/Search")
        public String getProducts(Model model, String keyword){
                List<Product> products = productDao.findAll();
                List<ProductType> productTypes = productTypeDao.findAll();

                if(keyword != null){
                        model.addAttribute("products", productDao.findByKeyWord(keyword));
                        model.addAttribute("keyword", "Search results for: " + keyword);
                }
                else {
                        model.addAttribute("products", products);
                }
                model.addAttribute("productTypes", productTypes);
                return "search/search";
        }

//        @GetMapping("/searchCat/{id}")
//        public String getProductCat(@PathVariable(value = "id") Integer id, Model model){
//                ProductType productType = productTypeDao.getOne(id);
//
//                model.addAttribute("productTypes", productType);
//
//                return"search/search";
//
//        }




}
