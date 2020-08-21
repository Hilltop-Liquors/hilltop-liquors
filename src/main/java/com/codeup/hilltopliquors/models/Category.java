package com.codeup.hilltopliquors.models;

import javax.persistence.*;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductType productType;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Subcategory> subcategories;

    public Category () {}

    public Category(int id, String name, ProductType productType, List<Subcategory> subcategories) {
        this.id = id;
        this.name = name;
        this.productType = productType;
        this.subcategories = subcategories;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subcategories) {
        this.subcategories = subcategories;
    }
}

