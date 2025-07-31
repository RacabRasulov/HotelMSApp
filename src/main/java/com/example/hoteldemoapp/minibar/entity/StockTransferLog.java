package com.example.hoteldemoapp.minibar.entity;

import com.example.hoteldemoapp.hotel.entity.RoomEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "stock_transfer_log")
public class StockTransferLog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "from_warehouse_id", nullable = true)
    private WarehouseStock fromWarehouse;

    @ManyToOne
    @JoinColumn(name = "to_minibar_id", nullable = true)
    private MiniBarStock toMiniBar;



    @ManyToOne
    @JoinColumn(name = "to_room_id")
    private RoomEntity toRoom;


    private LocalDate transferDate;

    private String performedBy; // Operator adı və ya user ID (opsional)
}


