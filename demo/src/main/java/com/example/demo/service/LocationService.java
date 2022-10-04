package com.example.demo.service;

import com.example.demo.model.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface LocationService {
    Location getLocationById(String id);

    Location getLocationByCity(String city);

    List<Location> getLocations();

    Location getLocationById(UUID locationId);

    void addLocation(Location location);

    void updateLocation(Integer locationId, String country, String city);

    void deleteLocation(Integer locationId);
}
