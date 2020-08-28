package com.codeup.hilltopliquors.models;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 250, nullable = false)
    private int totalInCents;
    @Column(length = 250, nullable = false)
    private boolean isCurbside;

//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(length = 250, nullable = false)
    private Timestamp createdAt;

    @Column(length = 250, nullable = false)
    private  boolean orderIsFulfilled;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts;

    public Order() {
    }

    public Order(User user, List<OrderProduct> orderProducts) {
        this.user = user;
        this.orderProducts = orderProducts;
    }

    public Order(long id, int totalInCents, boolean isCurbside, Timestamp createdAt, boolean orderIsFulfilled) {
        this.id = id;
        this.totalInCents = totalInCents;
        this.isCurbside = isCurbside;
        this.createdAt = createdAt;
        this.orderIsFulfilled = orderIsFulfilled;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getTotalInCents() {
        return totalInCents;
    }
    public void setTotalInCents(int totalInCents) {
        this.totalInCents = totalInCents;
    }
    public boolean getIsCurbside() {
        return isCurbside;
    }
    public void setIsCurbside(boolean isCurbside) {
        this.isCurbside = isCurbside;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public boolean getOrderIsFulfilled() {
        return orderIsFulfilled;
    }
    public void setOrderIsFulfilled(boolean orderIsFulfilled) {
        this.orderIsFulfilled = orderIsFulfilled;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
//    public OrderProduct getOrderProduct() {
//        return orderProduct;
//    }
//
//    public void setOrderProduct(OrderProduct orderProduct) {
//        this.orderProduct = orderProduct;
//    }
}