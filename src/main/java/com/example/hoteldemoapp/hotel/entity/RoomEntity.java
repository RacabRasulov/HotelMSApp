package com.example.hoteldemoapp.hotel.entity;


import com.example.hoteldemoapp.minibar.entity.MiniBarStock;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Table(name = "Rooms")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String roomNumber;
    private Boolean isAvailable;
    private String note;

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingEntity> bookingEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomTypeEntity roomTypeEntity;

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomFeatureEntity> features = new ArrayList<>();


    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiniBarStock> miniBarStocks = new ArrayList<>();

}
