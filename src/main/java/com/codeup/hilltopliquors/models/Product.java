package com.codeup.hilltopliquors.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long sku;

    @Column(length = 80)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id")
    private Subcategory subCategory;

    @Column(length = 25, name = "size_by_volume")
    private String size;

    @Column(name = "price")
    private int priceInCents;

    @Column(nullable = false)
    private int inStoreCount;

    @Column(name = "file_type")
    private String fileType;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderProduct> orderProducts;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_product_id", referencedColumnName = "id")
//    private OrderProduct orderProduct;

    @Transient
    private MultipartFile file;

    public Product () {}

    public Product(int inStoreCount) {
        this.inStoreCount = inStoreCount;
    }



    public Product(Long id, Long sku, String name, Subcategory subCategory, String size, int priceInCents, int inStoreCount, String fileType, List<OrderProduct> orderProducts) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.subCategory = subCategory;
        this.size = size;
        this.priceInCents = priceInCents;
        this.inStoreCount = inStoreCount;
        this.fileType = fileType;
        this.orderProducts = orderProducts;
    }

// NO TOUCHY
    public Product(Long sku, String name, Subcategory subCategory, String size, int priceInCents, int inStoreCount, String fileType) {
        this.sku = sku;
        this.name = name;
        this.subCategory = subCategory;
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

    public Product(String extension, int parseInt, String s, int i, String s1, long parseLong, int subCatId) {
    }

    public List<OrderProduct> getOrderProduct() {
        return orderProducts;
    }

    public void setOrderProduct(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSku() { return sku; }

    public void setSku(Long sku) { this.sku = sku; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getCategories() {
//        return categories;
//    }
//
//    public void setCategories(int categories) {
//        this.categories = categories;
//    }


    public Subcategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(Subcategory subCategory) {
        this.subCategory = subCategory;
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
