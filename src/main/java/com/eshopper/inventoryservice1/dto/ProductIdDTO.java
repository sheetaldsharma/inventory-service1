package com.eshopper.inventoryservice1.dto;

import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductIdDTO {
    List<Integer> productIds;
}

