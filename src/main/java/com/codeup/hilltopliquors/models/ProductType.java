package com.codeup.hilltopliquors.models;

import javax.persistence.*;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 75, nullable = false)
    private String name;
    @OneToOne(mappedBy = "productTypes")
    private Category category;

    public ProductType () {}

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductType(int id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
