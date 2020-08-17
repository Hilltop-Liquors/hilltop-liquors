package com.codeup.hilltopliquors.services;

import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface SpringReadFileService {
    List<Product> findAll();

    boolean saveDataFromUploadFile(MultipartFile file);

}
