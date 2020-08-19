package com.codeup.hilltopliquors.services;


import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.repositories.SpringReadFileRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.util.List;


//import net.java.ao.builder.EntityManagerBuilder;

@Service
@Transactional
//made this an abstract class...check if problems occur later
public class SpringReadFileImplementation implements SpringReadFileService {

    @Autowired private SpringReadFileRepository springReadFileRepository;

//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("product");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();




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

//            entityManager.createNativeQuery("TRUNCATE TABLE product CASCADE")
//                    .executeUpdate();
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
            List<String[]> rows = csvReader.readAll();

            for(String[] row : rows) {



                springReadFileRepository.save(new Product(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]), Integer.parseInt(row[3]), row[4],(int) (Double.parseDouble(row[5]) * 100), Integer.parseInt(row[6]), FilenameUtils.getExtension(file.getOriginalFilename())));

            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
                return false;
        }
    }



}
