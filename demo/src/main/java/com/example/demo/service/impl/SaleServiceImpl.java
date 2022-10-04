package com.example.demo.service.impl;

import com.example.demo.convert.ConvertDTO;
import com.example.demo.dao.SaleRepository;
import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Location;
import com.example.demo.model.Product;
import com.example.demo.model.Sale;
import com.example.demo.model.Time;
import com.example.demo.service.LocationService;
import com.example.demo.service.ProductService;
import com.example.demo.service.SaleService;
import com.example.demo.service.TimeService;
import com.example.demo.util.DateTimeUtil;
import com.example.demo.util.LogUtil;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SaleServiceImpl implements SaleService {
    private final TimeService timeService;
    private final ProductService productService;
    private final LocationService locationService;
    private final SaleRepository saleRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public SaleServiceImpl(TimeService timeService, ProductService productService, LocationService locationService, SaleRepository saleRepository) {
        this.locationService = locationService;
        this.productService = productService;
        this.timeService = timeService;
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale createOneSale(String classes, int month, String country, String money) {
        LogUtil.logDebug(logger, "create new sale");
        //b1: check data classes, month, country matches with db. isn't it?
        Product product = productService.getProductByClasses(classes);
        Time time = timeService.getTimeByMonth(month);
        Location location = locationService.getLocationByCity(country);
        DateTime dateTime = DateTimeUtil.getValueWithUTC();
        Sale sale = new Sale(product, time, location, money, dateTime, dateTime);
        saleRepository.save(sale);
        LogUtil.logDebug(logger, "create new sale done");
        return sale;


    }


    //get all sales
    @Override
    public List<SaleDTO> getAllSale() {
        LogUtil.logDebug(logger, "get all sale begin");
        List<Sale> listSale = saleRepository.findAll();
        List<SaleDTO> listSaleDTO = new ArrayList<>();
        for (int i = 0; i < listSale.size(); i++) {
            listSaleDTO.add(ConvertDTO.convertToSaleDTO(listSale.get(i)));
        }
        LogUtil.logDebug(logger, "get all sale end");
        return listSaleDTO;
    }

    @Override
    public void deleteSale(UUID saleId) {
        LogUtil.logDebug(logger, "delete sale with " + saleId + " begins");
        Sale sale = saleRepository.getSaleByID(saleId).orElseThrow(() -> new IllegalStateException("Id is not exists!"));
        saleRepository.delete(sale);
        LogUtil.logDebug(logger, "delete sale with " + saleId + " ends");
    }


    @Transactional
    // mục đích là khi có exception xảy ra thì transaction sẽ rollback lại các thao tác trước đó và cso thể định nghĩa cho nó rollback rule luôn  ((rollbackFor = {Exception.class, Throwable.class}))
    @Override
    public void updateSale(UUID saleId, String money) {
        LogUtil.logDebug(logger, "update money for saleId " + saleId + " begins");
        // update sale
        Sale sale = saleRepository.getSaleByID(saleId).orElseThrow(() -> new IllegalStateException("sale is not exists!"));

        if (money != null && !sale.getMoney().equals(money)) {
            sale.setMoney(money);
            LogUtil.logDebug(logger, "update money for saleId " + saleId + " ends");
        }
    }


}
