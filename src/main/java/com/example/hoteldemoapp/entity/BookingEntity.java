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
    @Column(nullable = false)
    private BookingStatus status;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private int numberOfGuests;

    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt ;
    private boolean withBreakfast;
    private boolean extraBed;
    private boolean babyCrib;


    @ManyToOne
    @JoinColumn(name = "employee_id") // və ya istədiyin sütun adı
    private EmployeeEntity handleBy;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt  = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt  = LocalDateTime.now();
    }




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

    public BigDecimal getTotalPaid() {
        if (paymentEntities == null || paymentEntities.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return paymentEntities.stream()
                .map(PaymentEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isFullyPaid() {
        return getTotalPaid().compareTo(totalPrice) >= 0;
    }

    public boolean isCheckedOut() {
        return this.status == BookingStatus.CHECKED_OUT;
    }

    public boolean isCustomerInDebt() {
        return getTotalPaid().compareTo(totalPrice) < 0;
    }



}




