package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.Time;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


public interface ProductService {
    Product getProductById(UUID id);
    Product getProductByClasses(String classes);
}
