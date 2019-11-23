package com.eshopper.inventoryservice1.controller;

import com.eshopper.inventoryservice1.model.Product;
//import com.eshopper.inventoryservice1.service.InventoryService;
import com.eshopper.inventoryservice1.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping(path = "/all")
    public List<Product> findProductDetailsByCustomerIdAndOrderId(@RequestParam List<Integer> productIds)
    {
        System.out.println("List = " +productIds.size());
        return inventoryService.findProductDetailsByCustomerIdAndOrderId(Arrays.asList(1,2));
    }

    @GetMapping(path = "/hello")
    public String hello()
    {
        return "hello";
    }
}
