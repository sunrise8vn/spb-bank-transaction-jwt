package com.cg.service.transfer;

import com.cg.model.Transfer;
import com.cg.model.dto.*;
import com.cg.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TransferServiceImpl implements ITransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public List<Transfer> findAll() {
        return null;
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Transfer getById(Long id) {
        return transferRepository.getById(id);
    }

    @Override
    public Optional<TransferDTO> findTransferDTOById(Long id) {
        return transferRepository.findTransferDTOById(id);
    }

    @Override
    public List<ITransferDTO> findAllITransferDTO() {
        return transferRepository.findAllITransferDTO();
    }

    @Override
    public List<TransferFullDTO> findAllTransferFullDTO() {
        return transferRepository.findAllTransferFullDTO();
    }

    @Override
    public List<ITransferFullDTO> findAllITransferFullDTO() {
        return transferRepository.findAllITransferFullDTO();
    }

    @Override
    public Optional<SumFeesAmountDTO> sumFeesAmount() {
        return transferRepository.sumFeesAmount();
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public void remove(Long id) {

    }
}
