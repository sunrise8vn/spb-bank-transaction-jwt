package com.cg.repository;

import com.cg.model.Customer;
import com.cg.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByDeletedIsFalse();

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndIdIsNot(String email, Long id);

    Boolean existsByIdAndDeletedIsFalse(Long id);

    Optional<Customer> findByIdAndDeletedIsFalse(Long id);


    @Query("SELECT NEW com.cg.model.dto.CustomerDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.email, " +
                "c.phone, " +
                "c.locationRegion, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.deleted = false ")
    List<CustomerDTO> findAllCustomerDTOByDeletedIsFalse();


    @Query("SELECT NEW com.cg.model.dto.CustomerDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.email, " +
                "c.phone, " +
                "c.locationRegion, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id = ?1 ")
    CustomerDTO getCustomerDTOById(Long id);


    @Query("SELECT NEW com.cg.model.dto.CustomerDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.email, " +
                "c.phone, " +
                "c.locationRegion, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id = ?1 ")
    Optional<CustomerDTO> findCustomerDTOById(Long id);


    @Query("SELECT NEW com.cg.model.dto.DepositDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id = ?1 ")
    Optional<DepositDTO> findDepositDTOById(Long id);


    @Query("SELECT NEW com.cg.model.dto.WithdrawDTO (" +
                "c.id, " +
                "c.fullName, " +
                "c.balance" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id = ?1 ")
    Optional<WithdrawDTO> findWithdrawDTOById(Long id);


    @Query("SELECT NEW com.cg.model.dto.RecipientDTO (" +
                "c.id, " +
                "c.fullName" +
            ") " +
            "FROM Customer c " +
            "WHERE c.id <> ?1 " +
            "AND c.deleted = false ")
    List<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id);


    @Modifying(clearAutomatically=true, flushAutomatically = true)
    @Query("UPDATE Customer c " +
            "SET c.balance = c.balance + :transferAmount " +
            "WHERE c.id = :id ")
    void incrementBalance(@Param("transferAmount") BigDecimal transferAmount, @Param("id") Long id);


    @Modifying(clearAutomatically=true, flushAutomatically = true)
    @Query("UPDATE Customer c " +
            "SET c.balance = c.balance - :transactionAmount " +
            "WHERE c.id = :id ")
    void reduceBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);

}
