package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @PrePersist
    public void prePersist() {
        if (usedAt == null) {
            usedAt = LocalDateTime.now();
        }
    }
    private LocalDateTime usedAt;


    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity roomEntity;



    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity bookingEntity;


    @ManyToOne
    @JoinColumn(name = "mini_bar_item_id")
    private MiniBarItemEntity miniBarItemEntity;

    private boolean isCharged;
}
