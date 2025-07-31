package com.example.hoteldemoapp.minibar.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String company;
    private String voen;
    private String note;


    @OneToMany(mappedBy = "supplier")
    private List<SupplierPaymentEntity> payments;

    @OneToMany(mappedBy = "supplier")
    private List<ProductPurchase> purchases;


}
