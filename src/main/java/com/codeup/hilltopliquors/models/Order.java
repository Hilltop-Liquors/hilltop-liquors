package com.codeup.hilltopliquors.models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 250, nullable = false, unique = true)
    private int totalInCents;

    @Column(length = 250, nullable = false, unique = true)
    private int isCurbside;

    @Column(length = 250, nullable = false, unique = true)
    private Timestamp createdAt;

    @Column(length = 250, nullable = false, unique = true)
    private  int orderIsFulfilled;

//    JOINING COLUMNS
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    @OneToOne
    private User user;

//??????


//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_product_id")
//    private OrderProduct orderProduct;





    public Order() {
    }

    public Order(long id, int totalInCents, int isCurbside, Timestamp createdAt, int orderIsFulfilled) {
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
    public int getIsCurbside() {
        return isCurbside;
    }

    public void setIsCurbside(int isCurbside) {
        this.isCurbside = isCurbside;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public int getOrderIsFulfilled() {
        return orderIsFulfilled;
    }

    public void setOrderIsFulfilled(int orderIsFulfilled) {
        this.orderIsFulfilled = orderIsFulfilled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public OrderProduct getOrderProduct() {
//        return orderProduct;
//    }
//
//    public void setOrderProduct(OrderProduct orderProduct) {
//        this.orderProduct = orderProduct;
//    }
}
