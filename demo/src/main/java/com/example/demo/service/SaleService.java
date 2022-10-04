package com.example.demo.service;

import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Sale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface SaleService {
     Sale createOneSale(String classes, int month, String country, String money);

     List<SaleDTO> getAllSale();

     void deleteSale(UUID saleId);

     void updateSale(UUID sale_id, String money);
}
