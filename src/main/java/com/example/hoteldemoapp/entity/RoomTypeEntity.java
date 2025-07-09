package com.example.hoteldemoapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RoomTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    private BigDecimal priceWithBreakfast;
    private BigDecimal priceWithoutBreakfast;
    private BigDecimal extraBedPrice;
    private BigDecimal babyCribPrice;

    @OneToMany(mappedBy = "roomTypeEntity")
    private List<RoomEntity> roomEntities;


}
