package com.example.hoteldemoapp.entity;

import com.example.hoteldemoapp.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Column(nullable = false)
    private LocalDateTime paymentDate;
    private Boolean isConfirmed;
    private String note;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private BookingEntity bookingEntity;
}
