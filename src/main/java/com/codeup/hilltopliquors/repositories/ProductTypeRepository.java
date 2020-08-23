package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.ProductType;
import com.codeup.hilltopliquors.models.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {


}

