package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mini_bar_usages")
public class MiniBarUsageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int quantityUsed;
    @Column(nullable = false, updatable = false)
    private LocalDateTime usedAt;
    private boolean isCharged;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity bookingEntity;

    @ManyToOne
    @JoinColumn(name = "mini_bar_item_id")
    private MiniBarItemEntity miniBarItemEntity;

    @PrePersist
    public void prePersist() {
        if (usedAt == null) {
            usedAt = LocalDateTime.now();
        }

    }

    @Transient
    public BigDecimal getProfit() {
        if (miniBarItemEntity == null || quantityUsed <= 0) {
            return BigDecimal.ZERO;
        }
        return miniBarItemEntity.getSalePrice()
                .subtract(miniBarItemEntity.getPurchasePrice())
                .multiply(BigDecimal.valueOf(quantityUsed));
    }

}
