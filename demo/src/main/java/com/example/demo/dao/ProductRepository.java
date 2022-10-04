package com.example.demo.dao;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
//dao using access to db
//by using spring repository
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("select p from Product p where p.classes = ?1")
    Optional<Product> getProductByClasses(String classes);
}
