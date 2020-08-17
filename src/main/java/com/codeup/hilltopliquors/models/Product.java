package com.codeup.hilltopliquors.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 80, nullable = false)
    private String products;
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
    
    public Product(Long id, int inStoreCount) {
        this.id = id;
        this.inStoreCount = inStoreCount;
    }

    public Product(Long id, String products, String size, int priceInCents, int inStoreCount) {
        this.id = id;
        this.products = products;
        this.size = size;
        this.priceInCents = priceInCents;
        this.inStoreCount = inStoreCount;
    }

    public Product(String products, String size, int priceInCents, int inStoreCount, String fileType) {
        this.products = products;
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

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public int getInStoreCount() {
        return inStoreCount;
    }

    public void setInStoreCount(int inStoreCount) {
        this.inStoreCount = inStoreCount;
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
