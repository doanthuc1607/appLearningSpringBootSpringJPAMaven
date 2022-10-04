package com.example.demo.test;

import com.example.demo.controller.SaleController;
import com.example.demo.dao.SaleRepository;
import com.example.demo.dto.SaleDTO;
import com.example.demo.service.LocationService;
import com.example.demo.service.SaleService;
import com.example.demo.service.impl.LocationServiceImpl;
import com.example.demo.service.impl.SaleServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SaleController.class)//chỉ định test cho lớp SaleController (chúng ta có thể chỉ định 1 hoặc nhiều)
public class SaleControllerTest {
    //dùng autowired để tạo instance cho một Mock mvc object để thể hiện get or post REQUEST đến controller
    @Autowired
    private MockMvc mockMvc;


    //Tạo mockbean cho service trong controller mà ta đang test dùng đến
    //Tạo hết các dependence mà controller cần test có
    @MockBean
    private SaleServiceImpl service;//sử dụng class service

//    @MockBean
//    private SaleRepository saleRepository;

    @MockBean
    private LocationServiceImpl locationService;

    //tạo test method
    @Test
    public void testGetAllSale() throws Exception{
        List<SaleDTO> listSaleDTO = new ArrayList<>();
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"),UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"),UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"),"2000000VND"));
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"),UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"),UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"),"2000000VND"));
       //Khi service.getAllsale được gọi hãy trả về listSaleDTO (giả sử nó trả về đúng cái ta cần để test pt mà ta muốn test có ổn ko)
        Mockito.when(service.getAllSale()).thenReturn(listSaleDTO);
        String url = "http://localhost:8082/api/v1/sales";//url dẫn đến phương thức cần test
        MvcResult mvcResult  = this.mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }


}
