package com.codeup.hilltopliquors.repositories;


import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
