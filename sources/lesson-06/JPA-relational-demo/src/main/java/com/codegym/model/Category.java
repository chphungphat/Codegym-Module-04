package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "categoryName")
    private String categoryMame;

    @OneToMany(targetEntity = Product.class, mappedBy = "category")
    private List<Product> productList;

    public Category(Long id, String categoryMame, List<Product> productList) {
        this.id = id;
        this.categoryMame = categoryMame;
        this.productList = productList;
    }

    public Category() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryMame() {
        return categoryMame;
    }

    public void setCategoryMame(String categoryMame) {
        this.categoryMame = categoryMame;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
