package com.example.demo.config;

import com.example.demo.dao.LocationRepository;
import com.example.demo.dao.ProductRepository;
import com.example.demo.dao.TimeRepository;
import com.example.demo.model.Location;
import com.example.demo.model.Product;
import com.example.demo.model.Sale;
import com.example.demo.model.Time;
import com.example.demo.util.DateTimeUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Configuration
@Component
public class InitialConfiguration {
    //in here we want to have a bean
    //save information into database
//    @Bean
//    CommandLineRunner commandLineRunner(LocationRepository locationRepository, ProductRepository productRepository, TimeRepository timeRepository) {
//        return args -> {
//            Location l1 = new Location("Viet Nam","TP. HCM");
//            Location l2 = new Location("Viet Nam","TP. Da Nang");
//            l1.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            l2.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            Product p1 = new Product(12,"tivi","tồn kho");
//            Product p2 = new Product(14,"tủ lạnh","tồn kho");
//            p1.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            p2.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            Time t1 = new Time(1,1,2021);
//            Time t2 = new Time(2,1,2021);
//            Time t3 = new Time(3,1,2021);
//            Time t4 = new Time(4,2,2021);
//            Time t5 = new Time(5,2,2021);
//            Time t6 = new Time(6,2,2021);
//            Time t7 = new Time(7,3,2021);
//            Time t8 = new Time(8,3,2021);
//            Time t9 = new Time(9,3,2021);
//            Time t10 = new Time(10,4,2021);
//            Time t11 = new Time(11,4,2021);
//            Time t12 = new Time(12,4,2021);
//            t1.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t2.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t3.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t4.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t5.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t6.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t7.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t8.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t9.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t10.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t11.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            t12.setCreatedAt(DateTimeUtil.getValueWithUTC());
//            System.out.println(locationRepository.save(l1));
//            locationRepository.save(l2);
//            productRepository.save(p1);
//            productRepository.save(p2);
//            timeRepository.save(t1);
//            timeRepository.save(t2);
//            timeRepository.save(t3);
//            timeRepository.save(t4);
//            timeRepository.save(t5);
//            timeRepository.save(t6);
//            timeRepository.save(t7);
//            timeRepository.save(t8);
//            timeRepository.save(t9);
//            timeRepository.save(t10);
//            timeRepository.save(t11);
//            timeRepository.save(t12);
//        };
//    }
}
