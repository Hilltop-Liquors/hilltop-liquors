package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Category;
import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.ProductType;
import com.codeup.hilltopliquors.repositories.CategoryRepository;
import com.codeup.hilltopliquors.repositories.ProductRepository;
import com.codeup.hilltopliquors.repositories.ProductTypeRepository;
import com.codeup.hilltopliquors.repositories.SubcategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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


                if(keyword != null){
                        model.addAttribute("products", productDao.findByKeyWord(keyword));
                }
//                else if() {
//
//                }
                else {
                        model.addAttribute("products", products);
                }
                return "search/search";
        }

        @GetMapping("/Search/Beer/{id}")
        public String getBeer(@PathVariable(value = "id") int id, Model model) {
                ProductType productType = productTypeDao.getOne(id);
                List<Category>


        }
                Post indPost = postsDao.getOne(id);
                List<Comment> getComments = postsDao.getOne(id).getComments();

                model.addAttribute("comments", getComments);
                model.addAttribute("post", indPost);

                return "posts/show";




}
