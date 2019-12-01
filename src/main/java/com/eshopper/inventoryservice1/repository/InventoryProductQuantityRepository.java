package com.eshopper.inventoryservice1.repository;

import com.eshopper.inventoryservice1.model.ProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryProductQuantityRepository extends JpaRepository<ProductQuantity, Integer> {
}
