package com.eshopper.inventoryservice1.listener;

import com.eshopper.inventoryservice1.dto.ProductIdDTO;
import com.eshopper.inventoryservice1.service.InventoryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



@Service
public class InventoryListener {

    @Autowired
    private InventoryService inventoryService;


    //@KafkaListener(topics = "ORDER_PRODUCT_DETAILS")
    public void orderProductDetailsListener(String message) throws IOException {
        System.out.println("==================== inventoryService: " + message);
//        ObjectMapper mapper = new ObjectMapper();
//        UserDTO userDTO = mapper.readValue(message.getBytes(), UserDTO.class);
//        System.out.println(userDTO.toString());
//        List<OrderProducts> orderProductsList = new ArrayList<>();
//        orderProductsList = orderProductsService.getDetailedProductsInAnOrder(userDTO.getOrderId());
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("==================== Bfore ===========");
        ProductIdDTO productIdDTO = mapper.readValue(message.getBytes(), ProductIdDTO.class);

//        ProductIdDTO productIdDTO = new ProductIdDTO();
//        productIdDTO = mapper.readValue(message, ProductIdDTO.class);
//        List<Integer> temp = mapper.readValue(message.getBytes(), new TypeReference<>() {
//            @Override
//            public Type getType() {
//                return super.getType();
//            }
//        });

        System.out.println("==================== productIdDTO.getProductIds(): " + productIdDTO.getProductIds());
        inventoryService.findProductDetailsByCustomerIdAndOrderId(productIdDTO.getProductIds());
    }
//
//    @KafkaListener(topics = "CUSTOMER_PRODUCER")
//    public void consumeJson(UserDTO userDto) {
//        System.out.println("_________________________________________ Consumed JSON Message: " + userDto);
//    }


}

