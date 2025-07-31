package com.example.hoteldemoapp.hotel.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "room_transfer_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class RoomTransferLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "from_room_id")
    private RoomEntity fromRoom;

    @ManyToOne
    @JoinColumn(name = "to_room_id")
    private RoomEntity toRoom;

    private LocalDateTime transferTime;

    private String transferredBy; // optional: for audit


}
