package com.example.hoteldemoapp.hotel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "room_status_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomStatusLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    private boolean isAvailable;

    private LocalDateTime changedAt;

    private String changedBy; // optional: for admin tracking


}
