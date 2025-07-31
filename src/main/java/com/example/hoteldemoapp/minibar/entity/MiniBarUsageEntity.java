package com.example.hoteldemoapp.minibar.entity;

import com.example.hoteldemoapp.hotel.entity.BookingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "minibar_usage")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MiniBarUsageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "minibar_stock_id")
    private MiniBarStock miniBarStock;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantityUsed;

    private LocalDateTime usedAt;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;






}
