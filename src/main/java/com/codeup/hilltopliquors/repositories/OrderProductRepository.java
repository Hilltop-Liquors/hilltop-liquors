package com.codeup.hilltopliquors.repositories;
import com.codeup.hilltopliquors.models.Order;
import com.codeup.hilltopliquors.models.OrderProduct;
import com.codeup.hilltopliquors.models.Product;
import com.codeup.hilltopliquors.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface OrderProductRepository  extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> findAllByOrderProductOrderId(Long id);

//
}