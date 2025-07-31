package com.example.hoteldemoapp.hotel.entity;

import com.example.hoteldemoapp.hotel.enums.PriceCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "room_prices")
public class RoomPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @ManyToOne
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomTypeEntity roomType;

    @Enumerated(EnumType.STRING)
    private PriceCategory priceCategory;  // STANDARD, HOLIDAY, DISCOUNTED

    private BigDecimal priceWithBreakfast;
    private BigDecimal priceWithoutBreakfast;
    private BigDecimal extraBedPrice;
    private BigDecimal babyCribPrice;

    private LocalDate validFrom;
    private LocalDate validTo;
}








