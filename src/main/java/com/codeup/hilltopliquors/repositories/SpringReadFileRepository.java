package com.codeup.hilltopliquors.repositories;

import com.codeup.hilltopliquors.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SpringReadFileRepository extends CrudRepository<Product, Long> {
//can create custom update inventory method (hibernate method naming convention to update specific columns of table row)

    //    Found here: https://stackoverflow.com/questions/31503103/not-supported-for-dml-operations-with-jpa-update-query
    @Transactional
    @Modifying
//    query by itself threw a: Not supported for DML operations error...so we added the two above
    //https://stackoverflow.com/questions/39741102/how-to-beautifully-update-a-jpa-entity-in-spring-data
    @Query("update Product p set p.inStoreCount = :inStoreCount WHERE p.sku = :sku")
    void setProductCount(@Param("sku") Long sku, @Param("inStoreCount") int inStoreCount);

}
