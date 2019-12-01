package com.eshopper.inventoryservice1.repository;

import com.eshopper.inventoryservice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM Products WHERE id in (:productIds)", nativeQuery = true)
    List<Product> findProductDetailsByCustomerIdAndOrderId(@Param("productIds") List<Integer> productIds);

    @Query(value = "SELECT * FROM Products WHERE categoryid in (:categoryIds)", nativeQuery = true)
    List<Product> findProductDetailsByCategoryId(@Param("categoryIds") List<Integer> categoryIds);

    @Query(value = "SELECT * FROM Products WHERE sku = ?1", nativeQuery = true)
    Product findAvailabilityOfProduct(String skuId);

    @Query(value = "UPDATE Products SET quantityperunit = (quantityperunit - 1) FROM Products WHERE sku = ?1", nativeQuery = true)
    Product updateProductQuantity(String skuId);

    //@Query(value = "UPDATE Products SET quantityperunit = quantityperunit - productquantity.quantity FROM ProductQuantity WHERE quantity.productid = Products.id;", nativeQuery = true)
    @Modifying
    @Transactional(readOnly=false)
//    @Query(value = "UPDATE products SET quantityperunit = ?1 WHERE id = ?2", nativeQuery = true)
    @Query(value = "UPDATE Products SET quantityperunit = quantityperunit - productquantity.quantity FROM productquantity WHERE productquantity.productid = Products.id", nativeQuery = true)
    void updateEachProductQuantity();
}


