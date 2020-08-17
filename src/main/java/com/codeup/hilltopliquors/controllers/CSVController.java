package com.codeup.hilltopliquors.controllers;

import com.codeup.hilltopliquors.models.Product;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

//from first document approach
//@CrossOrigin("http://localhost:8081")
//@RequestMapping("/api/csv")

@Controller
public class CSVController {

//    @Autowired
//    CSVService fileService;

    @GetMapping("/upload")
    public String fileUpload() {
        return "file-upload";
    }

    @PostMapping("/upload-csv-file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {
        
//        validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a csv file to upload.");
            model.addAttribute("status", false);
        } else {
            
//            parse CSV file to create a list of 'User' objects 
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                
//                create csv bean reader
                CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Product.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                
//                convert `CsvToBean` object to list of products
                List<Product> products = csvToBean.parse();
                
//                TODO: save users in DB
                
//                save products list on model
                model.addAttribute("products", products);
                model.addAttribute("status", true);
                
            } catch (Exception e) {
                model.addAttribute("message", "An error occured while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        return "file-upload-status";
    }
    
//    @PostMapping("/upload")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile file) {
//        String message;
//
//        if (CSVHelper.hasCSVFormat(file)) {
//            try {
//                fileService.save(file);
//
//                message = "Upload the file successfully: " + file.getOriginalFilename();
//                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//            } catch (Exception e) {
//                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//            }
//        }
//
//        message = "Please upload a csv file!";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
//    }

//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        try {
//            List<Product> products = fileService.getAllProducts();
//
//            if (products.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(products, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/download")
//    public ResponseEntity<InputStreamResource> getFile() {
//        String filename = "products.csv";
//        InputStreamResource file = new InputStreamResource(fileService.load());
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
//                .contentType(MediaType.parseMediaType("application/csv"))
//                .body(file);
//    }

}
