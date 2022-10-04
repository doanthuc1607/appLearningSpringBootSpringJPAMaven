package com.example.demo.controller;

import com.example.demo.convert.ConvertDTO;
import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Sale;
import com.example.demo.request.SaleRequest;
import com.example.demo.service.SaleService;
import com.example.demo.service.impl.LocationServiceImpl;
import com.example.demo.util.LogUtil;
//import org.jboss.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;
import java.util.UUID;

@RestController
//name in path have to be call by plural noun
//name in path have
@RequestMapping(path = "api/v1/sales")
public class SaleController {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    //insert 1 sale
    @Autowired
    private LocationServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> insertSale(@Valid @RequestBody SaleRequest sale) {
//        if (sale.getClasses() == null || sale.getMonth() == 0 || sale.getCity() == null || sale.getMoney() == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST);//badrequest
//        }
        Sale result = saleService.createOneSale(sale.getClasses(), sale.getMonth(), sale.getCity(), sale.getMoney());
        if (result != null) {
            LogUtil.logDebug(logger, "inser sale in DB");
            logger.info(result.toString());
            return ResponseEntity.ok(ConvertDTO.convertToSaleDTO(result));
        }
        LogUtil.logError(logger, "insert sale failure");
//        return ResponseEntity.status(404).body("NOT FOUND DATA: param not exist in the database");//not found data with request that client provides
        return null;
    }

//    @GetMapping("/{saleId}")
//    @RequestMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(
            value = "/{saleId}",
            method = RequestMethod.GET
           )
    public ResponseEntity<SaleDTO> getSale(@PathVariable UUID saleId) {
        return null;
    }

    @GetMapping
    public List<SaleDTO> getAllSale() {
        logger.info("get all sale");
        LogUtil.logDebug(logger, "get all sale");
        List<SaleDTO> result = saleService.getAllSale();
        LogUtil.logDebug(logger, "get all sale done");
        logger.info("get all sale done");
        return result;
    }

    // api/v1/{id}?country={country}&city={city}
    @PutMapping(path = "{saleId}")
    public ResponseEntity<String> updateSale(
            @PathVariable("saleId") UUID saleId,
            @RequestParam(required = false) String money

    ) {
        LogUtil.logDebug(logger, "update money for sale id: " + saleId);
        saleService.updateSale(saleId, money);
        LogUtil.logDebug(logger, "update money for sale successfully: ");
        return ResponseEntity.ok("update money for sale successfully");
    }

    @DeleteMapping(path = "{saleId}")
    public ResponseEntity<String> deleteSale(@PathVariable("saleId") UUID saleId) {
        LogUtil.logDebug(logger, "start to delete sale id: " + saleId);
        saleService.deleteSale(saleId);
        LogUtil.logDebug(logger, "delete sale successful");
        return ResponseEntity.ok("delete successfully");

    }


}
