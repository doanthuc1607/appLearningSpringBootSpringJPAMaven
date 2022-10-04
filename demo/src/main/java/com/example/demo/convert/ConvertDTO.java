package com.example.demo.convert;

import com.example.demo.dto.LocationDTO;
import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Location;
import com.example.demo.model.Sale;

import java.util.HashSet;
import java.util.Set;

public class ConvertDTO {
    public static SaleDTO convertToSaleDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setProductId(sale.getProduct().getProductId());
        saleDTO.setMoney(sale.getMoney());
        saleDTO.setLocationId(sale.getLocation().getLocationId());
        saleDTO.setTimeId(sale.getTime().getTimeId());
        saleDTO.setCreatedAt(sale.getCreatedAt());
        saleDTO.setModifiedAt(sale.getModifiedAt());
        return saleDTO;
    }

    public static LocationDTO convertToLocationDTO(Location location) {
//        System.out.println(location.toString());
        LocationDTO locationDTO = new LocationDTO(location.getLocationId(), location.getCountry(), location.getCity());
        Set<SaleDTO> saleDTOs = new HashSet<>();
//        System.out.println(location.getSaleItems());
        for (Sale s : location.getSaleItems()) {
//            System.out.println(s.toString());
            saleDTOs.add(new SaleDTO(s.getProduct().getProductId(), s.getProduct().getClasses(), s.getTime().getTimeId(), s.getLocation().getCity(), s.getMoney()));
        }
        locationDTO.setSetSaleDTO(saleDTOs);
        return locationDTO;
    }
}
