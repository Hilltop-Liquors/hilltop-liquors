package com.codeup.hilltopliquors.models;


import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "total_in_cents", length = 250, nullable = false, unique = true)
    private int totalInCents;

    @Column(name = "is_curbside", length = 250, nullable = false, unique = true)
    private int isCurbside;

    @Column(name = "created_at", length = 250, nullable = false, unique = true)
    private int createdAt;

    @Column(name = "order_is_fulfilled", length = 250, nullable = false, unique = true)
    private  int orderIsFulfilled;



//    JOINING COLUMNS
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private User user;
//??????
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;





    public Order() {
    }

    public Order(long id, int totalInCents, int isCurbside, int createdAt, int orderIsFulfilled) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
