package com.cg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "withdraws")
@Accessors(chain = true)
public class Withdraw extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "transaction_amount", nullable= false)
    private BigDecimal transactionAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Override
    public String toString() {
        return "Withdraw{" +
                "id=" + id +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
