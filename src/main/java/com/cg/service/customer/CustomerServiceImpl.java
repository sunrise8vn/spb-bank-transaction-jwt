package com.cg.service.customer;

import com.cg.model.Customer;
import com.cg.model.LocationRegion;
import com.cg.model.dto.*;
import com.cg.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LocationRegionRepository locationRegionRepository;

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WithdrawRepository withdrawRepository;

    @Autowired
    private TransferRepository transferRepository;


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllByDeletedIsFalse() {
        return customerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findByIdAndDeletedIsFalse(Long id) {
        return customerRepository.findByIdAndDeletedIsFalse(id);
    }

    @Override
    public Boolean existsByIdAndDeletedIsFalse(Long id) {
        return customerRepository.existsByIdAndDeletedIsFalse(id);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public CustomerDTO getCustomerDTOById(Long id) {
        return customerRepository.getCustomerDTOById(id);
    }

    @Override
    public Optional<CustomerDTO> findCustomerDTOById(Long id) {
        return customerRepository.findCustomerDTOById(id);
    }

    @Override
    public List<CustomerDTO> findAllCustomerDTOByDeletedIsFalse() {
        return customerRepository.findAllCustomerDTOByDeletedIsFalse();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByEmailAndIdIsNot(String email, Long id) {
        return customerRepository.existsByEmailAndIdIsNot(email, id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<DepositDTO> findDepositDTOById(Long id) {
        return customerRepository.findDepositDTOById(id);
    }

    @Override
    public Optional<WithdrawDTO> findWithdrawDTOById(Long id) {
        return customerRepository.findWithdrawDTOById(id);
    }

    @Override
    public List<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id) {
        return customerRepository.findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(id);
    }

    @Override
    public Customer create(Customer customer) {
        LocationRegion persistedLocationRegion = locationRegionRepository.save(customer.getLocationRegion());

        customer.setLocationRegion(persistedLocationRegion);

        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        LocationRegion persistedLocationRegion = locationRegionRepository.save(customer.getLocationRegion());

        customer.setLocationRegion(persistedLocationRegion);

        return customerRepository.save(customer);
    }

    @Override
    public CustomerDTO doDeposit(DepositDTO depositDTO) {

        customerRepository.incrementBalance(depositDTO.getTransactionAmount(), depositDTO.getCustomerId());

        CustomerDTO customerDTO = customerRepository.getCustomerDTOById(depositDTO.getCustomerId());

        depositRepository.save(depositDTO.toDeposit(customerDTO));

        return customerDTO;
    }

    @Override
    public CustomerDTO doWithdraw(WithdrawDTO withdrawDTO) {

        customerRepository.reduceBalance(withdrawDTO.getTransactionAmount(), withdrawDTO.getCustomerId());

        CustomerDTO customerDTO = customerRepository.getCustomerDTOById(withdrawDTO.getCustomerId());

        withdrawRepository.save(withdrawDTO.toWithdraw(customerDTO));

        return customerDTO;
    }

    @Override
    public void doTransfer(TransferDTO transferDTO, CustomerDTO sender, CustomerDTO recipient) {

        customerRepository.reduceBalance(transferDTO.getTransactionAmount(), transferDTO.getSenderId());

        customerRepository.incrementBalance(transferDTO.getTransferAmount(), transferDTO.getRecipientId());

        transferRepository.save(transferDTO.toTransfer(sender, recipient));
    }

    @Override
    public void incrementBalance(BigDecimal balance, Long id) {
        customerRepository.incrementBalance(balance, id);
    }

    @Override
    public void reduceBalance(BigDecimal balance, Long id) {
        customerRepository.reduceBalance(balance, id);

        StoredProcedureQuery query = this.em.createNamedStoredProcedureQuery("calculate");

    }

}
