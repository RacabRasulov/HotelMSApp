package com.example.hoteldemoapp.entity;

import com.example.hoteldemoapp.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "bookings")
public class BookingEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private LocalDate checkOutDate;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private BigDecimal totalPrice;

    @Column(nullable = false)
    private int numberOfGuests;

    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private boolean withBreakfast;
    private boolean extraBed;
    private boolean babyCrib;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = LocalDateTime.now();
    }


    @ManyToOne
    @JoinColumn(name = "handled_by_id")
    private EmployeeEntity handleBy;

    @OneToMany(mappedBy = "bookingEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentEntity> paymentEntities = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    @OneToMany(mappedBy = "bookingEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MiniBarUsageEntity> miniBarUsages = new ArrayList<>();

}




