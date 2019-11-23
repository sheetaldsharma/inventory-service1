package com.eshopper.inventoryservice1.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="supplier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "phone")
    @NonNull
    private Integer phone;
}
