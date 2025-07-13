package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "suppliers")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String company;
    private String note;
    @OneToMany(mappedBy = "supplier")
    private List<MiniBarPurchaseEntity> purchases;

    @OneToMany(mappedBy = "supplier")
    private List<SupplierPaymentEntity> payments;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public List<SupplierPaymentEntity> getPayments() {
        return payments;
    }

    public void setPayments(List<SupplierPaymentEntity> payments) {
        this.payments = payments;
    }
}
