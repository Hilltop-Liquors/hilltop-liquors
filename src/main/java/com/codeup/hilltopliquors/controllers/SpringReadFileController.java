package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.services.SpringReadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SpringReadFileController {

    @Autowired private SpringReadFileService springReadFileService;

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("product", new Product());
        List<Product> products = springReadFileService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/fileupload")
    public String uploadFile(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        boolean isFlag = springReadFileService.saveDataFromUploadFile(product.getFile());
        if(isFlag){
            redirectAttributes.addFlashAttribute("successmessage", "File uploaded Successfully!");
        } else {
            redirectAttributes.addFlashAttribute("errormessage", "File upload failed. Please try again!");
        }
        return "redirect:/products";
    }
}
