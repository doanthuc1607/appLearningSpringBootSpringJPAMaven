package com.example.demo.dao;

import com.example.demo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {//tại đây phải truyền đúng entity và KDL id của nó thì mới có thể dùng được các pt của JPA
    @Query(value = "select l from Location l where l.city=?1")
    Optional<Location> getLocationByCity(String city);
}
