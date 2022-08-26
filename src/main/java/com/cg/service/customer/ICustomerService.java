package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.dto.*;
import com.cg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {

    Customer create(Customer customer);

    Customer update(Customer customer);

    List<CustomerDTO> findAllCustomerDTOByDeletedIsFalse();

    Boolean existsByIdAndDeletedIsFalse(Long id);

    Boolean existsByEmail(String email);

    Boolean existsByEmailAndIdIsNot(String email, Long id);

    Optional<Customer> findByIdAndDeletedIsFalse(Long id);

    List<Customer> findAllByDeletedIsFalse();

    CustomerDTO getCustomerDTOById(Long id);

    Optional<CustomerDTO> findCustomerDTOById(Long id);

    Optional<DepositDTO> findDepositDTOById(Long id);

    Optional<WithdrawDTO> findWithdrawDTOById(Long id);

    List<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id);

    CustomerDTO doDeposit(DepositDTO depositDTO);

    CustomerDTO doWithdraw(WithdrawDTO withdrawDTO);

    void doTransfer(TransferDTO transferDTO, CustomerDTO sender, CustomerDTO recipient);

    void incrementBalance(BigDecimal balance, Long id);

    void reduceBalance(BigDecimal balance, Long id);

}
