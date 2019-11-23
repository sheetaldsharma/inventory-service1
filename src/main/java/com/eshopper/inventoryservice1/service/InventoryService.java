package com.eshopper.inventoryservice1.service;

import com.eshopper.inventoryservice1.model.Product;
import com.eshopper.inventoryservice1.repository.InventoryRepository;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService{
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Product> findProductDetailsByCustomerIdAndOrderId(List<Integer> productIds)
    {
        return inventoryRepository.findProductDetailsByCustomerIdAndOrderId(productIds);
    }

    public List<Product> findProductDetailsByCategoryId(List<Integer> categoryIds)
    {
        return inventoryRepository.findProductDetailsByCustomerIdAndOrderId(categoryIds);
    }

    public Product findAvailabilityOfProduct(String skuId)
    {
        return inventoryRepository.findAvailabilityOfProduct(skuId);
    }

    public List<Product> fetchAllProducts()
    {
        return inventoryRepository.findAll();
    }

    public void removeProduct(Product product)
    {
        inventoryRepository.delete(product);
    }

    public Product addProduct(Product product)
    {
        return inventoryRepository.save(product);
    }

    public Product getProductDetails(Integer productId)
    {
        return inventoryRepository.getOne(productId);
    }

}
