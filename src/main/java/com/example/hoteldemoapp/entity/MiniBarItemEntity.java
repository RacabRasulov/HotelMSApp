package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "mini_bar_items")
public class MiniBarItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal purchasePrice;
    private BigDecimal salePrice;
    private int warehouseStock;

    @OneToMany(mappedBy = "miniBarItemEntity")
    private List<MiniBarStockEntity> miniBarStocks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public int getWarehouseStock() {
        return warehouseStock;
    }

    public void setWarehouseStock(int warehouseStock) {
        this.warehouseStock = warehouseStock;
    }

    public List<MiniBarStockEntity> getMiniBarStocks() {
        return miniBarStocks;
    }

    public void setMiniBarStocks(List<MiniBarStockEntity> miniBarStocks) {
        this.miniBarStocks = miniBarStocks;
    }
}
