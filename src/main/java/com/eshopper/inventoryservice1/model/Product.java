package com.eshopper.inventoryservice1.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "sku")
    @NonNull
    private String sku;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "description")
    @NonNull
    private String description;

    @Column(name = "brandname")
    @NonNull
    private String brandName;

    @Column(name = "supplierid")
    @NonNull
    private Integer supplierId;

    @Column(name = "categoryid")
    @NonNull
    private Integer categoryId;

    @Column(name = "quantityperunit")
    @NonNull
    private Integer quantityPerUnit;

    @Column(name = "unitprice")
    @NonNull
    private Float unitPrice;

    @Column(name = "size")
    @NonNull
    private String size;

    @Column(name = "color")
    @NonNull
    private String color;

    @Column(name = "discount")
    @NonNull
    private Float discount;

    @Column(name = "discountavailable")
    @NonNull
    private Boolean discountAvailable;

    @Column(name = "picture")
    @NonNull
    private String picture;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brandName='" + brandName + '\'' +
                ", supplierId=" + supplierId +
                ", categoryId=" + categoryId +
                ", quantityPerUnit=" + quantityPerUnit +
                ", unitPrice=" + unitPrice +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", discount=" + discount +
                ", discountAvailable=" + discountAvailable +
                ", picture='" + picture + '\'' +
                '}';
    }
}
