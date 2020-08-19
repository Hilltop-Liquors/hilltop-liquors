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
    @OneToOne
    private Category categories;

    public Subcategory () {}

    public Subcategory(int id, String name, Category categories) {
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

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }
}
