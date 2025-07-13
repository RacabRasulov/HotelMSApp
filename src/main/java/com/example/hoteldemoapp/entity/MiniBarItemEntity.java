package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private BigDecimal salePrice;
    private String note;

    @OneToMany(mappedBy = "miniBarItem")
    private List<MiniBarPurchaseEntity> purchases;
    @OneToMany(mappedBy = "miniBarItemEntity")
    private List<MiniBarUsageEntity> usages;

    @Transient
    public BigDecimal getAveragePurchasePrice() {
        if (purchases == null || purchases.isEmpty()) return BigDecimal.ZERO;
        BigDecimal totalCost = purchases.stream()
                .map(p -> p.getUnitPrice().multiply(BigDecimal.valueOf(p.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        int totalQuantity = purchases.stream().mapToInt(MiniBarPurchaseEntity::getQuantity).sum();
        return totalQuantity == 0 ? BigDecimal.ZERO : totalCost.divide(BigDecimal.valueOf(totalQuantity), 2, RoundingMode.HALF_UP);
    }


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

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<MiniBarPurchaseEntity> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<MiniBarPurchaseEntity> purchases) {
        this.purchases = purchases;
    }

    public List<MiniBarUsageEntity> getUsages() {
        return usages;
    }

    public void setUsages(List<MiniBarUsageEntity> usages) {
        this.usages = usages;
    }
}
