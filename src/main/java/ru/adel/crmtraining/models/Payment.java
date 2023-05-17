package ru.adel.crmtraining.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @DecimalMin(value = "0.01", message = "Сумма должна быть больше или равна 0.01")
    @Column(name = "amount")
    private BigDecimal amount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

}
