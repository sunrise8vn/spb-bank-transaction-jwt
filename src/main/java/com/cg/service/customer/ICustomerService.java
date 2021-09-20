package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.dto.*;
import com.cg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {

    Customer create(Customer customer);

    Customer update(Customer customer);

    Iterable<CustomerDTO> findAllCustomerDTOByDeletedIsFalse();

    Boolean existsByEmail(String email);

    CustomerDTO findCustomerDTOByEmail(String email);

    CustomerDTO findCustomerDTOByEmailAndIdIsNot(String email, Long id);

    Iterable<Customer> findAllByDeletedIsFalse();

    CustomerDTO findCustomerDTOById(Long id);

    Optional<DepositDTO> findDepositDTOById(Long id);

    Optional<WithdrawDTO> findWithdrawDTOById(Long id);

    Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSender(Long id);

    Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id);

    CustomerDTO doDeposit(DepositDTO depositDTO);

    CustomerDTO doWithdraw(WithdrawDTO withdrawDTO);

    void doTransfer(TransferDTO transferDTO, CustomerDTO sender, CustomerDTO recipient);

    void incrementBalance(BigDecimal balance, Long id);

    void reduceBalance(BigDecimal balance, Long id);

}
