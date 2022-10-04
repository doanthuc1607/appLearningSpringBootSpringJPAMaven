package com.example.demo.dao;

import com.example.demo.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TimeRepository extends JpaRepository<Time, UUID> {
    @Query("select t from Time t where t.month=?1")
    Optional<Time> getTimeByMonth(Integer month);

}
