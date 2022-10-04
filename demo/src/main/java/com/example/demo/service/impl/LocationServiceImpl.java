package com.example.demo.service.impl;

import com.example.demo.dao.LocationRepository;
import com.example.demo.model.Location;
import com.example.demo.model.Product;
import com.example.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }


    @Override
    public Location getLocationById(String id) {
        return null;
    }

    @Override
    public Location getLocationByCity(String city) {
        Location location = locationRepository.getLocationByCity(city).orElseThrow(()-> new IllegalStateException("location with city "+city+ " doesn't exist in Database"));
        return location;
    }

    @Override
    public List<Location> getLocations() {
        return null;
    }

    @Override
    public Location getLocationById(UUID locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(()-> new IllegalStateException("location with id " + locationId + " does not exists"));
//        System.out.println(location.toString());
        return location;

    }

    @Override
    public void addLocation(Location location) {

    }

    @Override
    public void updateLocation(Integer locationId, String country, String city) {

    }

    @Override
    public void deleteLocation(Integer locationId) {

    }
}
