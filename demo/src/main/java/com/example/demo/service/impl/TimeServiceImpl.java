package com.example.demo.service.impl;

import com.example.demo.dao.TimeRepository;
import com.example.demo.model.Time;
import com.example.demo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;
    @Autowired
    public TimeServiceImpl(TimeRepository timeRepository){
        this.timeRepository = timeRepository;
    }

    @Override
    public Time getTimeById(String id) {
//        Time time = timeRepository.findById(id)
//                .orElseThrow(() -> new IllegalStateException("time with id " + id + " does not exists"));
        return null;
    }

    @Override
    public Time getTimeByMonth(Integer month) {
        Time time = timeRepository.getTimeByMonth(month)
                .orElseThrow(() -> new IllegalStateException("time with month " + month + " does not exists"));
        return time;
    }
}
