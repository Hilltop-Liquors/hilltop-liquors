package com.codeup.hilltopliquors.models;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "total_in_cents")
    private int totalInCents;

    @Column(name = "is_curbside")
    private int isCurbside;

    @Column(name = "created_at")
    private int createdAt;

    @Column(name = "order_is_fulfilled")
    private  int orderIsFulfilled;


    public Order(long id, int userId, int totalInCents, int isCurbside, int createdAt, int orderIsFulfilled) {
        this.id = id;
        this.userId = userId;
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
    public long getUserId() {
        return id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public Long getTotalInCents() {
        return totalInCents;
    }

    public void setTotalInCents(Long totalInCents) {
        this.totalInCents = totalInCents;
    }
    public int getIsCurbside() {
        return isCurbside;
    }

    public void setIsCurbside(int isCurbside) {
        this.isCurbside = isCurbside;
    }
    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }
    public int getOrderIsFulfilled() {
        return orderIsFulfilled;
    }

    public void setOrderIsFulfilled(int orderIsFulfilled) {
        this.orderIsFulfilled = orderIsFulfilled;
    }


}
