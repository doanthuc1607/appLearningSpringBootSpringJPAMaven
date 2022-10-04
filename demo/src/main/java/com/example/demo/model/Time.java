package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity(name = "Time")
@Table(name = "time")
public class Time implements Serializable {
    private static final long serialVersionUID = 1L;//đảm bảo chắc chắn rằng đối tượng trước và sau khi serilization là một
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "time_id", updatable = false)
    private UUID timeId;
    @Column(name = "month")
    private Integer month;
    @Column(name = "quarter")
    private Integer quarter;
    @Column(name = "year")
    private Integer year;
    @OneToMany(mappedBy = "time", fetch = FetchType.LAZY, cascade = CascadeType.ALL)//map with attribute of entity
    private Set<Sale> sales = new HashSet<>();
    @Column(name = "created_at")
    private DateTime createdAt;
    @Column(name = "modified_at")
    private DateTime modifiedAt;
    public Time(){}

    public Time(Integer month, Integer quarter, Integer year) {
        this.month = month;
        this.quarter = quarter;
        this.year = year;
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

    public UUID getTimeId() {
        return timeId;
    }

    public void setTimeId(UUID timeId) {
        this.timeId = timeId;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Time{" +
                "timeId=" + timeId +
                ", month=" + month +
                ", quarter=" + quarter +
                ", year=" + year +
                ", sales=" + sales +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
