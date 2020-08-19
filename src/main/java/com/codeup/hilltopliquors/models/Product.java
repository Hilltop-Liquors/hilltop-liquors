package com.codeup.hilltopliquors.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;



@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, unique = true)
    private int sku;
    @Column(length = 80, nullable = false)
    private String name;
    @Column(length = 5)
    private int categories;
    @Column(length = 5)
    private int subCategories;
    @Column(length = 25, nullable = false, name = "size_by_volume")
    private String size;
    //    @Column(name = "price", columnDefinition="Decimal(10,2) default '0.00'", nullable = false)
    @Column(name = "price")
    private int priceInCents;
    @Column(nullable = false)
    private int inStoreCount;
    @Column(name = "file_type")
    private String fileType;

    @Transient
    private MultipartFile file;

    public Product () {}

    public Product(int inStoreCount) {
        this.inStoreCount = inStoreCount;
    }

    public Product(Long id, int sku, String name, int categories, int subCategories, String size, int priceInCents, int inStoreCount, String fileType) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.categories = categories;
        this.subCategories = subCategories;
        this.size = size;
        this.priceInCents = priceInCents;
        this.inStoreCount = inStoreCount;
        this.fileType = fileType;
    }

    public Product(int sku, String name, int categories, int subCategories, String size, int priceInCents, int inStoreCount, String fileType) {
        this.sku = sku;
        this.name = name;
        this.categories = categories;
        this.subCategories = subCategories;
        this.size = size;
        this.priceInCents = priceInCents;
        this.inStoreCount = inStoreCount;
        this.fileType = fileType;
    }


    public Product(String s, int parseInt, String extension) {
    }

    public Product(String s, String s1, String s2, int i, int parseInt, String extension) {
    }

    public Product(long parseLong, String s1, String s2, int i, int parseInt, String extension) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSku() { return sku; }

    public void setSku(int sku) { this.sku = sku; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategories() {
        return categories;
    }

    public void setCategories(int categories) {
        this.categories = categories;
    }

    public int getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(int subCategories) {
        this.subCategories = subCategories;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public int getInStoreCount() {
        return inStoreCount;
    }

    public int setInStoreCount(int inStoreCount) {
        this.inStoreCount = inStoreCount;
//        intellij added this return statement
        return inStoreCount;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
