package com.example.demo.test;

import com.example.demo.controller.SaleController;
import com.example.demo.dto.SaleDTO;
import com.example.demo.service.impl.LocationServiceImpl;
import com.example.demo.service.impl.SaleServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebMvcTest(SaleController.class)//Dùng test annotation và truyền vào controller class mà ta muốn test
public class SaleRestControllerTest {
    private static String url="/api/v1/sales";
    @Autowired
    //chúng ta cần mockMVC object để perform request
    private MockMvc mockMvc;

    @MockBean //mock bean này khác gì so với mockmvc?
    private SaleServiceImpl saleService;

    @MockBean
    private LocationServiceImpl locationService;

    @Test
    public void testDeleteSale(){
        UUID saleId = UUID.fromString("703fdc1d-8317-4357-adb3-6a85a797a2a1");


    }

    public void getAllSaleSuccessfull(){
        //step1: tạo mock data
        List<SaleDTO> listSaleDTO = new ArrayList<>();
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"),UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"),UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"),"2000000VND"));
        listSaleDTO.add(new SaleDTO(UUID.fromString("eadc38d7-6f97-4124-a23f-b2a17c63c708"),UUID.fromString("8abadf7f-f8d0-46e6-bc40-391882549a7d"),UUID.fromString("2c9a21c9-4cc9-40b0-ae31-cc9b0508f9ef"),"2000000VND"));
        //step2:define behavior (có bao nhiêu định nghĩa bấy nhiêu)
        //In here, there is a behavior: getAllSale
        //if wen call saleService.getAllSale, return listSaleDTO (giả lập là pt trả về kết quả mong muốn)
        Mockito.when(saleService.getAllSale()).thenReturn(listSaleDTO);
        try {
//            this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/sales")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
