package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mini_bar_purchases")
public class MiniBarPurchaseEntity { //satinalma

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity; // miqdari
    private BigDecimal unitPrice; // vahidin qiymeti
    private LocalDateTime purchaseDate; //satinalma tarixi
    private String note;


    @ManyToOne
    private MiniBarItemEntity miniBarItem;
    @ManyToOne
    private SupplierEntity supplier;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public MiniBarItemEntity getMiniBarItem() {
        return miniBarItem;
    }

    public void setMiniBarItem(MiniBarItemEntity miniBarItem) {
        this.miniBarItem = miniBarItem;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }
}
