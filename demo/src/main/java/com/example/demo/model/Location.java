package com.example.demo.model;

//import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
//import org.hibernate.annotations.UpdateTimestamp;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity(name = "Location")//name have to be mapped with class, it's wrong if they aren't the same
@Table(name = "location")
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;//đảm bảo chắc chắn rằng đối tượng trước và sau khi serilization là một
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID locationId;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    //eager là load hết các bảng liên quan lên luôn
    @JsonIgnore
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//mappedBy với biến mà nó nó muốn map bên sale (ở trong sale được được đặt là location)
    //lazy là không load hết các bảng liên quan mà ghi dùng get thì mới lấy mấy bảng cần get lên
    private Set<Sale> saleItems = new HashSet<>();
    //    @CreationTimestamp//tự động
//    @UpdateTimestamp
    @Column(name = "created_at")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdAt;
    @Column(name = "modified_at")
//    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modifiedAt;

    //empty contructor
    public Location() {
    }


    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public Set<Sale> getSaleItems() {
        return saleItems;
    }

    public void setSaleItems(Set<Sale> saleItems) {
        this.saleItems = saleItems;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", saleItems=" + saleItems +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
