package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "Sale")
@Table(name="sale")
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;//đảm bảo chắc chắn rằng đối tượng trước và sau khi serilization là một
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "sale_id", updatable = false)
    private UUID saleId;

    @ManyToOne
    @JoinColumn(name = "product_id")//để đặt tên cho cột liên kết với product
    private Product product;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")//để đặt tên cho cột liên kết với location
    private Location location;
    @Column(name = "money")
    private String money;
    @Column(name = "created_at")
    private DateTime createdAt;
    @Column(name = "modified_at")
    private DateTime modifiedAt;

    //empty contructor
    public Sale(){}

    public Sale(Product product, Time time, Location location, String money) {
        this.product = product;
        this.time = time;
        this.location = location;
        this.money = money;
    }
    public Sale(Product product, Time time, Location location, String money, DateTime createdAt, DateTime modifiedAt) {
        this.product = product;
        this.time = time;
        this.location = location;
        this.money = money;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation_id(Location location) {
        this.location = location;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public UUID getSaleId() {
        return saleId;
    }

    public void setSaleId(UUID saleId) {
        this.saleId = saleId;
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

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", product=" + product +
                ", time=" + time +
                ", location=" + location +
                ", money='" + money + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
