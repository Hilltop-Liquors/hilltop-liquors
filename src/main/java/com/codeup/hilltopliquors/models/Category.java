package com.codeup.hilltopliquors.models;

import javax.persistence.*;

@Entity
@Table(name = "cat")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150, nullable = false)
    private String name;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_types_id")
    @OneToOne
    @JoinColumn(name = "product_types_id", referencedColumnName = "id")
    private ProductType productTypes;

    @OneToOne(mappedBy = "categories")
    private Subcategory subcategory;

    public Category () {}

    public Category(int id, String name, ProductType productTypes) {
        this.id = id;
        this.name = name;
        this.productTypes = productTypes;
    }

    public Category(int id, String name, ProductType productTypes, Subcategory subcategory) {
        this.id = id;
        this.name = name;
        this.productTypes = productTypes;
        this.subcategory = subcategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ProductType productTypes) {
        this.productTypes = productTypes;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }
}
