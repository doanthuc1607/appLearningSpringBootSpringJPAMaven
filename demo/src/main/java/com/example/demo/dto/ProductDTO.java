package com.example.demo.dto;

import java.util.UUID;

public class ProductDTO {
    private UUID productId;
    private Integer item;
    private String classes;
    private String investory;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getInvestory() {
        return investory;
    }

    public void setInvestory(String investory) {
        this.investory = investory;
    }
}
