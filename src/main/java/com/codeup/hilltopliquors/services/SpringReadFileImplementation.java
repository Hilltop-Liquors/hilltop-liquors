package com.codeup.hilltopliquors.services;


import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.Subcategory;
import com.codeup.hilltopliquors.repositories.SpringReadFileRepository;
import com.codeup.hilltopliquors.repositories.SubcategoryRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.util.List;




@Service
@Transactional
//made this an abstract class...check if problems occur later
public class SpringReadFileImplementation implements SpringReadFileService {

    @Autowired private SpringReadFileRepository springReadFileRepository;

    @Autowired private SubcategoryRepository subcategoryRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) springReadFileRepository.findAll();
    }

    @Override
    public boolean saveDataFromUploadFile(MultipartFile file) {
        boolean isFlag = false;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (extension.equalsIgnoreCase("csv")) {
            isFlag = readDataFromCsv(file);
        }
        return isFlag;
    }
    private boolean readDataFromCsv(MultipartFile file) {
        try {

            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();
            List<Product> productList = (List<Product>) springReadFileRepository.findAll();
            for(String[] row : rows) {


                int subCatId = 0;
                if (row[2].isEmpty()) {
                    subCatId = 0;
                } else {
                    subCatId = Integer.parseInt(row[2]);
                }

                long incomingSku = Long.parseLong(row[0]);
                int newProductCount = Integer.parseInt(row[5]);
                boolean recordExists = false;

                for (Product product : productList) {
                    if (incomingSku == product.getSku()) {
                        recordExists = true;
//                    System.out.println("These are equal: incomingSku " + incomingSku + " Existing Sku " + product.getSku()); // $$$ This WORKS!
//                        System.out.println(newProductCount);    // $$ This shows the first 2 updates
//                        System.out.println(product.getSku());  // $$  This shows the first 2 sku numbers
                        springReadFileRepository.setProductCount(product.getSku(), newProductCount);   // $$ This appears to have updated the FIRST row inStoreCount
                    } //else if (incomingSku != product.getSku()) {
                   //(else if) }
                }
//                System.out.println("Did This Run?");
                if(!recordExists) {
                    System.out.println(row[0]);
                    System.out.println(row[1]);
                    System.out.println(row[2]);
                    System.out.println(row[3]);
                    System.out.println(row[4]);
                    System.out.println(row[5]);

                    Subcategory subCat = subcategoryRepository.getOne(subCatId);


                    Product testProduct = new Product(Long.parseLong(row[0]), row[1], subCat, row[3], (int) (Double.parseDouble(row[4]) * 100), Integer.parseInt(row[5]), FilenameUtils.getExtension(file.getOriginalFilename()));

                    System.out.println("testProduct.getName() = " + testProduct.getName());

//                    springReadFileRepository.save(new Product(Long.parseLong(row[0]), row[1], subCatId, row[3], (int) (Double.parseDouble(row[4]) * 100), Integer.parseInt(row[5]), FilenameUtils.getExtension(file.getOriginalFilename())));

//                    springReadFileRepository.save(new Product(FilenameUtils.getExtension(file.getOriginalFilename()), Integer.parseInt(row[5]), row[1], (int) (Double.parseDouble(row[4]) * 100), row[3], Long.parseLong(row[0]), subCatId));
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
                return false;
        }
    }



}
