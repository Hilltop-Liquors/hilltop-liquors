package com.codeup.hilltopliquors.models;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(length = 80, nullable = false)
    @CsvBindByName
    private String products;
//    @Column(length = 25, nullable = false)
    @CsvBindByName
    private String size;
//    @Column(columnDefinition="Decimal(10,2) default '0.00'", nullable = false)
    @CsvBindByName
    private double price_in_cents;
//    @Column(nullable = false)
    @CsvBindByName
    private int in_store_count;

    public Product() {}

    public Product(long id, String products, String size, double price_in_cents, int in_store_count) {
        this.id = id;
        this.products = products;
        this.size = size;
        this.price_in_cents = price_in_cents;
        this.in_store_count = in_store_count;
    }

    public Product(String products, String size, double price_in_cents, int in_store_count) {
        this.products = products;
        this.size = size;
        this.price_in_cents = price_in_cents;
        this.in_store_count = in_store_count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice_in_cents() {
        return price_in_cents;
    }

    public void setPrice_in_cents(double price_in_cents) {
        this.price_in_cents = price_in_cents;
    }

    public int getIn_store_count() {
        return in_store_count;
    }

    public void setIn_store_count(int in_store_count) {
        this.in_store_count = in_store_count;
    }
}
