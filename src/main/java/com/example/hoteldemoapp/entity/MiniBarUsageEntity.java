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
    private String note;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public LocalDateTime getUsedAt() {
        return usedAt;
    }

    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }

    public boolean isCharged() {
        return isCharged;
    }

    public void setCharged(boolean charged) {
        isCharged = charged;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public BookingEntity getBookingEntity() {
        return bookingEntity;
    }

    public void setBookingEntity(BookingEntity bookingEntity) {
        this.bookingEntity = bookingEntity;
    }

    public MiniBarItemEntity getMiniBarItemEntity() {
        return miniBarItemEntity;
    }

    public void setMiniBarItemEntity(MiniBarItemEntity miniBarItemEntity) {
        this.miniBarItemEntity = miniBarItemEntity;
    }
}


