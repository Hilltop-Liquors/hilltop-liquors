package com.codeup.hilltopliquors.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_category")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 120, nullable = false)
    private String name;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "categories_id")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Product> products;

    public Subcategory () {}

    public Subcategory(int id, String name, Category category, List<Product> products) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
