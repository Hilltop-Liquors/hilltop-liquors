package com.codeup.hilltopliquors.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 75, nullable = false)
    private String name;
    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Category> categories;

    public ProductType () {}

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductType(int id, String name, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
