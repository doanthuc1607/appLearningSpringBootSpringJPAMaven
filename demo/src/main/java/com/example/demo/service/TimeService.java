package com.example.demo.service;

import com.example.demo.model.Time;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface TimeService {
    Time getTimeById(String id);
    Time getTimeByMonth(Integer month);
}
