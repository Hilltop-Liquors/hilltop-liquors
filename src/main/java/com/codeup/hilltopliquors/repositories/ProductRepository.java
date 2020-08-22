package com.codeup.hilltopliquors.repositories;


import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value="SELECT * FROM product p WHERE p.name LIKE %:keyword%", nativeQuery = true)
    List<Product> findByKeyWord(@Param("keyword") String keyword);

    List<Product> findProductsBySubCategoryId(int subId);

//    @Query(value="SELECT * FROM cat c WHERE c.product_type_id LIKE %:productCat%", nativeQuery = true)
//    List<Product> findByKeyWord(@Param("keyword") String keyword);

//    List<Product> getProductsBySubCategory(int subId);

    @Override
    List<Product> findAll();

}
