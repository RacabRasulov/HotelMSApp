package com.example.hoteldemoapp.minibar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @OneToMany(mappedBy = "product")
    private List<ProductPurchase> purchases;

    @OneToMany(mappedBy = "product")
    private List<WarehouseStock> warehouseStocks;

    @OneToMany(mappedBy = "product")
    private List<MiniBarStock> miniBarStocks;

    @OneToMany(mappedBy = "product")
    private List<RoomProductSale> productSales;


}
