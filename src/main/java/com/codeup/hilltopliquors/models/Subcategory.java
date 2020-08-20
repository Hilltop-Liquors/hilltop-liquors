package com.codeup.hilltopliquors.models;

import javax.persistence.*;

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
    @OneToOne
    @JoinColumn(name = "categories_id", referencedColumnName = "id")
    private Category categories;

    @OneToOne(mappedBy = "subCategories")
    private Product product;

    public Subcategory () {}

    public Subcategory(int id, String name, Category categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    public Subcategory(int id, String name, Category categories, Product product) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.product = product;
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

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
