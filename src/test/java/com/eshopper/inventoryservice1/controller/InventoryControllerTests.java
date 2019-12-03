package com.eshopper.inventoryservice1.controller;

import com.eshopper.inventoryservice1.model.Product;
import com.eshopper.inventoryservice1.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InventoryController.class)
public class InventoryControllerTests {
    @MockBean
    InventoryService inventoryService;

    @InjectMocks
    InventoryController inventoryController;

    @MockBean
    RestTemplate restTemplate;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplateString;

    @Autowired
    MockMvc mockMvc;

    public Product getProductDetails1()
    {
        Product product1 = new Product();
        product1.setId(1);
        product1.setSku("AA");
        product1.setName("tshirt");
        product1.setDescription("casual");
        product1.setBrandName("Nike");
        product1.setSupplierId(1);
        product1.setCategoryId(1);
        product1.setQuantityPerUnit(100);
        product1.setUnitPrice(10f);
        product1.setSize("M");
        product1.setColor("Red");
        product1.setDiscount(2f);
        product1.setDiscountAvailable(true);
        product1.setPicture("C:") ;

        return product1;
    }

    public Product getProductDetails2()
    {
        Product product2 = new Product();
        product2.setId(2);
        product2.setSku("AA");
        product2.setName("tshirt");
        product2.setDescription("casual");
        product2.setBrandName("Nike");
        product2.setSupplierId(1);
        product2.setCategoryId(1);
        product2.setQuantityPerUnit(100);
        product2.setUnitPrice(10f);
        product2.setSize("M");
        product2.setColor("Red");
        product2.setDiscount(2f);
        product2.setDiscountAvailable(true);
        product2.setPicture("C:") ;

        return product2;
    }

    @Test
    public void shouldFetchAllProducts() throws Exception {

        List<Product> productList = new ArrayList<>();
        productList.add(getProductDetails1());
        productList.add(getProductDetails2());

        given(inventoryService.fetchAllProducts()).willReturn(productList);

        mockMvc.perform(get("/inventory/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].sku").value("AA"))
                .andDo(MockMvcResultHandlers.print());
    }

//    @GetMapping(path = "/productIds/details")
//    public List<Product> findProductDetailsByCustomerIdAndOrderId(@RequestParam List<Integer> productIds)
//    {
//        System.out.println("List = " +productIds.size());
//        return inventoryService.findProductDetailsByCustomerIdAndOrderId(productIds);
//    }
//
//    @GetMapping(path = "/categoryIds/products")
//    public List<Product> findProductDetailsByCategoryId(@RequestParam List<Integer> categoryIds)
//    {
//        return inventoryService.findProductDetailsByCategoryId(categoryIds);
//    }
//
//    @GetMapping(path = "/{skuId}")
//    public Product findAvailabilityOfProduct(@PathVariable String skuId)
//    {
//        return inventoryService.findAvailabilityOfProduct(skuId);
//    }
//
//    @GetMapping("/{productId}/productDetails")
//    public Product getProductDetails(@PathVariable("productId") Integer productId)
//    {
//        System.out.println("in getCustomerDetails"+productId);
//        return inventoryService.getProductDetails(productId) ;
//    }
//
//    @DeleteMapping(path = "/remove/{productId}")
//    public String removeProduct(@PathVariable Integer productId)
//    {
//        Product product = inventoryService.getProductDetails(productId);
//        String msg;
//        try {
//            inventoryService.removeProduct(product);
//            msg= "Success";
//        }catch (Exception e)
//        {
//            System.out.println("CAtch");
//            msg= "Error";
//        }
//        return msg;
//
//    }
//
//    @PutMapping(path = "/{id}/updateQuantity")
//    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product)
//    {
//        System.out.println("+++++++++++++++++++++ in inven ++++++++++" +product.toString());
//
//        return inventoryService.updateProduct(product);
//    }
//
//
//    @PutMapping(path = "/multiple/updateQuantity")
//    public String updateProductQuantity(@RequestBody  List<ProductQuantity> productQuantityList)
//    {
//        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+productQuantityList.toString());
//        inventoryService.updateProductQuantity(productQuantityList);
//        kafkaTemplateString.send("SEND_ORDER_PLACED_MAIL", "send mail");
//        System.out.println("-----------------------------------after kafka call");
//        return "UpdatedProductQuantity";
//    }
//
//    @PostMapping(path = "/add")
//    public Product addProduct(@RequestBody Product product)
//    {
//        inventoryService.addProduct(product);
//        return product;
//    }

}
