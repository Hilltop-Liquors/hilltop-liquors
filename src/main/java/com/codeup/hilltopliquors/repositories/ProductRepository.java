package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
