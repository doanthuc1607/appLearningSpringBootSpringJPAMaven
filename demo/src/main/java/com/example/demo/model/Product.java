package com.example.demo.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Product")
@Table(name = "product")

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;//đảm bảo chắc chắn rằng đối tượng trước và sau khi serilization là một
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id", updatable = false)
    private UUID productId;
    @Column(name = "item")
    private Integer item;
    @Column(name = "classes")
    private String classes;
    @Column(name = "investory")
    private String investory;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sale> sales = new HashSet<>();
    @Column(name = "created_at")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdAt;
    @Column(name = "modified_at")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modifiedAt;
    //empty contructor
    public Product(){}

    public Product(Integer item, String classes, String investory) {
        this.item = item;
        this.classes = classes;
        this.investory = investory;
    }

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

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
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
        return "Product{" +
                "productId=" + productId +
                ", item=" + item +
                ", classes='" + classes + '\'' +
                ", investory='" + investory + '\'' +
                ", sales=" + sales +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
