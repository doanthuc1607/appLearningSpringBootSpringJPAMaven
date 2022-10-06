package com.example.demo.test;

import com.example.demo.controller.SaleController;
import com.example.demo.dto.SaleDTO;
import com.example.demo.model.Location;
import com.example.demo.model.Product;
import com.example.demo.model.Sale;
import com.example.demo.model.Time;
import com.example.demo.request.SaleRequest;
import com.example.demo.service.SaleService;
import com.example.demo.service.impl.LocationServiceImpl;
import com.example.demo.service.impl.SaleServiceImpl;
import com.example.demo.util.DateTimeUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(SaleController.class)
//Dùng test annotation và truyền vào controller class mà ta muốn test(load only controllers)
public class SaleRestControllerTest {
    private static String url = "/api/v1/sales";
    @Autowired
//    Đối tượng MockMvc do Spring cung cấp Có tác dụng giả lập request, thay thế việc khởi động Server
    private MockMvc mockMvc;

    @InjectMocks
    SaleController saleController;

    @Autowired
    private ObjectMapper objectMapper;//use to convert object to json and json to object

    @MockBean
    //mock dependencies (service or repository..): Đối tượng saleService sẽ được mock chứ không phải bean trong context
    private SaleServiceImpl saleService;

    @MockBean
    private LocationServiceImpl locationService;
    @Mock
    Sale sale;
    @Mock
    SaleRequest saleRequest;
    @Test
    public void testDeleteSale() {
        UUID saleId = UUID.fromString("703fdc1d-8317-4357-adb3-6a85a797a2a1");


    }

    @Test
    public void getAllSaleSuccessfull() {
        //step1: tạo mock data
        List<SaleDTO> listSaleDTO = new ArrayList<>();
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"), UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"), UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"), "2000000VND"));
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"), UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"), UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"), "2000000VND"));
        //step2:define behavior (có bao nhiêu định nghĩa bấy nhiêu)
        //In here, there is a behavior: getAllSale
        //if wen call saleService.getAllSale, return listSaleDTO (giả lập là pt trả về kết quả mong muốn)
        //mock input and ouput
        Mockito.when(saleService.getAllSale()).thenReturn(listSaleDTO);
        try {
            this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/sales").contentType(MediaType.APPLICATION_JSON))//thực hiện get request
                    .andExpect(status().isOk())//mong muốn server trả về status 200
                    .andExpect(jsonPath("$", hasSize(2)));//hy vọng server trả về list có độ dài là 2 ($: dữ liệu trả về của api
//                    .andExpect(jsonPath("$[0].id", is()))
            Mockito.verify(saleService, Mockito.times(1)).getAllSale();//đảm bảo việc getAllSale được thực hiện 1 lần
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //h2 database: Dữ liệu được tạo ra sẽ bị mấy đi sau mỗi lần ta chạy chương trình

    @Test
    public void saveSaleSuccessfull() throws Exception {
        //tạo dữ liệu request
        SaleRequest saleRequest = new SaleRequest();
        saleRequest.setClasses("tivi");
        saleRequest.setCity("TP. HCM");
        saleRequest.setMonth(1);
        saleRequest.setMoney("1900000VND");
        //tạo dữ liệu trả về
        Sale result = new Sale();
        result.setSaleId(UUID.randomUUID());
        result.setMoney("1900000VND");
        result.setMoney("1900000VND");
        Product p = new Product();
        p.setProductId(UUID.randomUUID());
        result.setProduct(p);
        p.setClasses("tivi");
        result.setCreatedAt(DateTimeUtil.getValueWithUTC());
        result.setModifiedAt(DateTimeUtil.getValueWithUTC());
        Location location = new Location();
        location.setLocationId(UUID.randomUUID());
        location.setCity("TP. HCM");
        result.setLocation(location);
        Time time = new Time();
        time.setTimeId(UUID.randomUUID());
        result.setTime(time);
        //giả lập kết quả trả về
//        Mockito.when(saleService.createOneSale(anyString(), anyInt(), anyString(), anyString())).thenReturn(sale);
          Mockito.when(saleService.createOneSale(saleRequest.getClasses(), saleRequest.getMonth(),saleRequest.getCity(), saleRequest.getMoney())).thenReturn(result);
//        Mockito.when(saleService.createOneSale(any())
        String url = "/api/v1/sales";
//        try {
            this.mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(saleRequest))).andDo(print()).andExpect(status().isOk())
//                    .andExpect(result1 -> Assertions.assertEquals(null, result));
//            int status = mvcResult.getResponse().getStatus();
//            Assertions.assertEquals(200, status);
//            Mockito.verify(saleService, Mockito.times(1)).createOneSale(saleRequest.getClasses(), saleRequest.getMonth(),saleRequest.getCity(), saleRequest.getMoney());//đảm bảo hàm

//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    //not found data
    @Test
    public void saveSaleWithStatusWithRequiredBodyIsMissing() throws Exception {
        Mockito.when(saleService.createOneSale(anyString(), anyInt(), anyString(), anyString())).thenReturn(sale);
        List<String> headers = new ArrayList<>();
        try {
            headers = this.mockMvc.perform(post(url)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(null))
            ).andDo(print())
                    .andExpect(status().is5xxServerError())
                    .andReturn().getResponse().getHeaders("log-detail-trace");
        }catch (Exception ex) {
            Assertions.assertEquals(ex.getLocalizedMessage(), headers.get(0));
        }

    }

    //bad request
    public void saveSaleWithStatus400() {

    }


}
