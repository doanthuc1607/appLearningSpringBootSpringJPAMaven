package com.example.demo.dao;

import com.example.demo.model.Sale;
import com.example.demo.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {//what is the UUID - is a String can be auto created
    @Query("select s from Sale s where s.saleId=?1")
    Optional<Sale> getSaleByID(UUID saleId);
}
