package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringReadFileRepository extends CrudRepository<Product, Long> {
//can create custom update inventory method (hibernate method naming convention to update specific columns of table row)


}
