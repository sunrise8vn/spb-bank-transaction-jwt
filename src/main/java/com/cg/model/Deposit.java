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
@Table(name = "deposits")
@Accessors(chain = true)
public class Deposit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Digits(integer = 14, fraction = 2)
    @Column(name = "transaction_amount", nullable= false)
    private BigDecimal transactionAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Deposit(Customer customer, BigDecimal transactionAmount) {
        this.customer = customer;
        this.transactionAmount = transactionAmount;
    }


    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}
