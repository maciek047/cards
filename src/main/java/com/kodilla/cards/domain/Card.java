package com.kodilla.cards.domain;

import io.micrometer.core.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="currency")
    private String currency;

    @Column(name="available_funds")
    private BigDecimal availableFunds;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customers_id")
    @Nullable
    private Customer customer;
}
