package com.example.hoteldemoapp.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "mini_bar_stocks")
public class MiniBarStockEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    private int quantity;  // Bu otaqda neçə dənə var

    @Column(nullable = false)
    private BigDecimal price;
    private int stockCount;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @ManyToOne
    @JoinColumn(name = "mini_bar_item_id")
    private MiniBarItemEntity miniBarItemEntity;


}
