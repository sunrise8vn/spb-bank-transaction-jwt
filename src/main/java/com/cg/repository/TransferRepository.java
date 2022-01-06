package com.cg.repository;

import com.cg.model.Transfer;
import com.cg.model.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("SELECT NEW com.cg.model.dto.TransferDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.email, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id = ?1 "
    )
    Optional<TransferDTO> findTransferDTOById(Long id);


    @Query("SELECT NEW com.cg.model.dto.TransferFullDTO (" +
                "t.sender.id, " +
                "t.sender.fullName, " +
                "t.sender.email, " +
                "t.recipient.id, " +
                "t.recipient.fullName, " +
                "t.createdAt, " +
                "t.createdAt, " +
                "t.sender.balance, " +
                "t.transferAmount, " +
                "t.fees, " +
                "t.feesAmount, " +
                "t.transactionAmount" +
            ") " +
            "FROM Transfer t "
    )
    List<TransferFullDTO> findAllTransferFullDTO();


    @Query("SELECT " +
                "t.id AS id, " +
                "t.sender.id AS senderId, " +
                "t.sender.fullName as senderName, " +
                "t.recipient.id AS recipientId, " +
                "t.recipient.fullName AS recipientName, " +
                "t.createdAt AS createdAt, " +
                "t.createdAt AS createdOn, " +
                "t.transferAmount AS transferAmount, " +
                "t.fees AS fees, " +
                "t.feesAmount AS feesAmount, " +
                "t.transactionAmount AS transactionAmount " +
            "FROM Transfer t "
    )
    List<ITransferFullDTO> findAllITransferFullDTO();


    @Query("SELECT " +
                "t.id AS id, " +
                "t.sender.id AS senderId, " +
                "t.sender.fullName as senderName, " +
                "t.recipient.id AS recipientId, " +
                "t.recipient.fullName AS recipientName, " +
                "t.transferAmount AS transferAmount, " +
                "t.fees AS fees, " +
                "t.feesAmount AS feesAmount " +
            "FROM Transfer t "
    )
    List<ITransferDTO> findAllITransferDTO();


    @Query("SELECT NEW com.cg.model.dto.SumFeesAmountDTO (SUM(t.feesAmount)) FROM Transfer t ")
    Optional<SumFeesAmountDTO> sumFeesAmount();

}
