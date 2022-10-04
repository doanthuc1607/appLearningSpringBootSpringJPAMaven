package com.example.demo.controller;

import com.example.demo.convert.ConvertDTO;
import com.example.demo.dto.LocationDTO;
import com.example.demo.model.Location;
import com.example.demo.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/locations")
public class LocationController {
    private final LocationService locationService;
    // creating a logger
    Logger logger
            = LoggerFactory.getLogger(LocationController.class);
    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations(){
        logger.info("get all location");
        return ResponseEntity.ok().body(this.locationService.getLocations());
    }

    @GetMapping(path = "/{locationId}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable("locationId") UUID locationId){
        logger.info("get location by id");
        Location result = locationService.getLocationById(locationId);
//        logger.info(result.toString());
//        logger.info(result.getSaleItems().toString());
        return ResponseEntity.ok(ConvertDTO.convertToLocationDTO(result));
    }
    @PostMapping
    public void createLocation(@RequestBody Location location){
        logger.info("create location");
        locationService.addLocation(location);
    }

    // /api/v1/location/{id}?country={country}&city={city}
    @PutMapping(path = "/{locationId}")
    public void updateLocation(
            @PathVariable("locationId") Integer locationId,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) String city
    ){
        logger.info("update location");
        locationService.updateLocation(locationId, country, city);
    }

    @DeleteMapping(path = "/{locationId}")
    public void deleteLocation(@PathVariable("locationId") Integer locationId){
        logger.info("delete location");
        locationService.deleteLocation(locationId);
    }
//
//    @GetMapping(path = "/{locationId}")
//    public ResponseEntity<Location> getLocationById(@PathVariable("locationId") UUID locationId){
//        logger.info("get location by id");
//        Location result = locationService.getLocationById(locationId);
////        logger.info(result.toString());
////        logger.info(result.getSaleItems().toString());
//        return ResponseEntity.ok(result);
//    }

}
