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

            for(String[] row : rows) {
//                Search by title to get the primary key id = productsDao.getIdbyTitle - this is where we set the id
//                if primary key is not null, set the primary key in the following line
//                pass in to constructor that sets id with other fields.
//                create constructor that gets id and column count to
               // springReadFileRepository.save(new Product(row[0] = String.valueOf(product.getId()), row[1], (int) (Double.parseDouble(row[2]) * 100), Integer.parseInt(row[3]), FilenameUtils.getExtension(file.getOriginalFilename())));
                springReadFileRepository.save(new Product(row[0], row[1], (int) (Double.parseDouble(row[2]) * 100), Integer.parseInt(row[3]), FilenameUtils.getExtension(file.getOriginalFilename())));
//                if id is not found, we can create a new record in db below
//                springReadFileRepository.save(new Product(row[0], row[1], (int) (Double.parseDouble(row[2]) * 100), Integer.parseInt(row[3]), FilenameUtils.getExtension(file.getOriginalFilename())));

            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
                return false;
        }
    }



}
