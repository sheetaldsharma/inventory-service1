package com.eshopper.inventoryservice1.controller;

import com.eshopper.inventoryservice1.model.Product;
//import com.eshopper.inventoryservice1.service.InventoryService;
import com.eshopper.inventoryservice1.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/all")
    public List<Product> fetchAllProducts()
    {
        return inventoryService.fetchAllProducts();
    }

    @GetMapping(path = "/productIds/details")
    public List<Product> findProductDetailsByCustomerIdAndOrderId(@RequestParam List<Integer> productIds)
    {
        System.out.println("List = " +productIds.size());
        return inventoryService.findProductDetailsByCustomerIdAndOrderId(productIds);
    }

    @GetMapping(path = "/categoryIds/products")
    public List<Product> findProductDetailsByCategoryId(@RequestParam List<Integer> categoryIds)
    {
        return inventoryService.findProductDetailsByCategoryId(categoryIds);
    }

    @GetMapping(path = "/{skuId}")
    public Product findAvailabilityOfProduct(@PathVariable String skuId)
    {
        return inventoryService.findAvailabilityOfProduct(skuId);
    }

    @GetMapping("/{productId}/productDetails")
    public Product getProductDetails(@PathVariable("productId") Integer productId)
    {
        System.out.println("in getCustomerDetails"+productId);
        return inventoryService.getProductDetails(productId) ;
    }

    @DeleteMapping(path = "/remove/{productId}")
    public String removeProduct(@PathVariable Integer productId)
    {
        Product product = inventoryService.getProductDetails(productId);
        String msg;
        try {
            inventoryService.removeProduct(product);
            msg= "Success";
        }catch (Exception e)
        {
            System.out.println("CAtch");
            msg= "Error";
        }
        return msg;

    }

    @PutMapping(path = "/{id}/updateQuantity")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product)
    {
        System.out.println("+++++++++++++++++++++ in inven ++++++++++" +product.toString());

        return inventoryService.updateProduct(product);
    }


    @PutMapping(path = "/multiple/updateQuantity")
    public List<Product> updateProduct(@RequestBody  List<Product> productList)
    {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return inventoryService.updateProductQuantity(productList);
    }

    @PostMapping(path = "/add")
    public Product addProduct(@RequestBody Product product)
    {
        inventoryService.addProduct(product);
        return product;
    }
}
