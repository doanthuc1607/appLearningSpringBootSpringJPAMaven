package com.example.demo.service.impl;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import com.example.demo.model.Time;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(UUID id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent())
            throw new IllegalStateException("id " + id + " don't exist in Database");//id is not exist
        return productOptional.get();
    }

    @Override
    public Product getProductByClasses(String classes) {
        Optional<Product> productOptional = productRepository.getProductByClasses(classes);
        if(!productOptional.isPresent())
            throw new IllegalStateException("classes " + classes + " don't exist in Database");//name is not exist
        return productOptional.get();
    }
}
