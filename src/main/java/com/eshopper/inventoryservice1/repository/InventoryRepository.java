package com.eshopper.inventoryservice1.repository;

import com.eshopper.inventoryservice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM Products WHERE id in (:productIds)", nativeQuery = true)
    List<Product> findProductDetailsByCustomerIdAndOrderId(@Param("productIds") List<Integer> productIds);

    @Query(value = "SELECT * FROM Products WHERE categoryid in (:categoryIds)", nativeQuery = true)
    List<Product> findProductDetailsByCategoryId(@Param("categoryIds") List<Integer> categoryIds);

    @Query(value = "SELECT * FROM Products WHERE sku = ?1", nativeQuery = true)
    Product findAvailabilityOfProduct(String skuId);
}


