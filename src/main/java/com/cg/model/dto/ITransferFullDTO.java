package com.cg.model.dto;

import java.math.BigDecimal;
import java.util.Date;

public interface ITransferFullDTO {
    int getId();
    Long getSenderId();
    String getSenderName();
    Long getRecipientId();
    String getRecipientName();
    Date getCreatedOn();
    Date getCreatedAt();
    BigDecimal getTransferAmount();
    int getFees();
    BigDecimal getFeesAmount();
    BigDecimal getTransactionAmount();
}
