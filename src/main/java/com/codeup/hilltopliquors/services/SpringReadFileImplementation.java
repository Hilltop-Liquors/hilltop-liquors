package com.codeup.hilltopliquors.services;


import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.repositories.SpringReadFileRepository;
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
                if (row[3].isEmpty()) {
                    subCatId = 0;
                } else {
                    subCatId = Integer.parseInt(row[3]);
                }

                int incomingSku = Integer.parseInt(row[0]);
                int newProductCount = Integer.parseInt(row[6]);
                boolean recordExists = false;

                for (Product product : productList) {
                    if (incomingSku == product.getSku()) {
                        recordExists = true;
//                    System.out.println("These are equal: incomingSku " + incomingSku + " Existing Sku " + product.getSku()); // $$$ This WORKS!
                        System.out.println(newProductCount);    // $$ This shows the first 2 updates
                        System.out.println(product.getSku());  // $$  This shows the first 2 sku numbers
                        springReadFileRepository.setProductCount(product.getSku(), newProductCount);   // $$ This appears to have updated the FIRST row inStoreCount
                    } //else if (incomingSku != product.getSku()) {
                   //(else if) }
                }
//                System.out.println("Did This Run?");
                if(!recordExists) {
                    springReadFileRepository.save(new Product(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), subCatId, row[4], (int) (Double.parseDouble(row[5]) * 100), Integer.parseInt(row[6]), FilenameUtils.getExtension(file.getOriginalFilename())));
                }
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
                return false;
        }
    }



}
