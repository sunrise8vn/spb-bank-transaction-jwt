package com.cg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferFullDTO {

    private Long senderId;
    private String senderName;
    private String email;
    private Long recipientId;
    private String recipientName;
    private Date createdOn;
    private Date createdAt;
    private BigDecimal balance;
    private BigDecimal transferAmount;
    private int fees;
    private BigDecimal feesAmount;
    private BigDecimal transactionAmount;

}
