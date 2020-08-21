package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    RETURN LIST OF PRODUCTS
//    public List<Product> getProducts(){
//        return ProductRepository
//    }

//    GET PRODUCTS BY KEYWORDS
//    public List<Product> findByKeyword(String keyword){
//        return productRepository.findByKeyWord(keyword);
//    }


}
