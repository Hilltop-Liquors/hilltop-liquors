package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Category;
import com.codeup.hilltopliquors.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

//    @Query(value="SELECT * FROM product_type p WHERE p.id LIKE %:keyword%", nativeQuery = true)
    List<Category> findByProductTypeId(@Param("productTypeKeyWord") int productTypeKeyWord);



}
