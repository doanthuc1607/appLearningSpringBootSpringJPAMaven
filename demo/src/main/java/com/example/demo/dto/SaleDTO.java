package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.joda.time.DateTime;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)//annotation này nghĩa là trường nào null thì không hiển thị nó ra bên ngoài json
public class SaleDTO {
    private UUID productId;
    private String classes;
    private UUID timeId;
    private UUID locationId;
    private String city;
    private String money;
    private DateTime createdAt;
    private DateTime modifiedAt;

    public UUID getProductId() {
        return productId;
    }

    public SaleDTO(){}

    public SaleDTO(UUID productId, String classes, UUID timeId, String city, String money) {
        this.productId = productId;
        this.timeId = timeId;
        this.classes = classes;
        this.city = city;
        this.money = money;
    }

    public SaleDTO(UUID productId, UUID timeId, UUID locationId, String money) {
        this.productId = productId;
        this.timeId = timeId;
        this.locationId = locationId;
        this.money = money;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public UUID getTimeId() {
        return timeId;
    }

    public void setTimeId(UUID timeId) {
        this.timeId = timeId;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(DateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
