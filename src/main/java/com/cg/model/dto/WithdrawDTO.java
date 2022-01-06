package com.cg.model.dto;

import com.cg.model.Withdraw;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawDTO {
    private long customerId;
    private String fullName;
    private BigDecimal balance;

    @NotNull(message = "The transaction amount is required")
    @DecimalMin(value = "50", message = "Transaction Amount must be greater than or equal to 50")
    @DecimalMax(value = "10000000000", message = "Transaction Amount must be less than or equal to 10.000.000.000")
    private BigDecimal transactionAmount;

    public WithdrawDTO(long customerId, String fullName, BigDecimal balance) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.balance = balance;
    }


    public Withdraw toWithdraw(CustomerDTO customerDTO) {
        return new Withdraw()
            .setCustomer(customerDTO.toCustomer())
            .setTransactionAmount(transactionAmount);
    }
}
