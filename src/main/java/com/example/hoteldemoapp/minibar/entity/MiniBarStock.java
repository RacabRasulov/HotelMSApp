package com.example.hoteldemoapp.minibar.entity;

import com.example.hoteldemoapp.hotel.entity.RoomEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "mini_bar_stock")
public class MiniBarStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;




}
