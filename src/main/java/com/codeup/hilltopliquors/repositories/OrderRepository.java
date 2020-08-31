package com.codeup.hilltopliquors.repositories;
import com.codeup.hilltopliquors.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserId(Long id);


    @Transactional
    @Modifying
//    query by itself threw a: Not supported for DML operations error...so we added the two a
    //https://www.baeldung.com/spring-data-jpa-query
    @Query("SELECT o FROM Order o WHERE o.orderIsFulfilled = false ORDER BY o.createdAt DESC")
   List<Order> FindAllUnfulfilled();

}