package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class LocationDTO {
    private UUID locationId;
    private String country;
    private String city;
    private Set<SaleDTO> setSaleDTO = new HashSet<>();

    public LocationDTO(UUID locationId, String country, String city) {
        this.locationId = locationId;
        this.country = country;
        this.city = city;
    }

    public LocationDTO(){}

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

    public Set<SaleDTO> getSetSaleDTO() {
        return setSaleDTO;
    }

    public void setSetSaleDTO(Set<SaleDTO> setSaleDTO) {
        this.setSaleDTO = setSaleDTO;
    }
}
