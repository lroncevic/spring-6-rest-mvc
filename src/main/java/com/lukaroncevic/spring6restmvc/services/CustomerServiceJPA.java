package com.lukaroncevic.spring6restmvc.services;

import com.lukaroncevic.spring6restmvc.mappers.CustomerMapper;
import com.lukaroncevic.spring6restmvc.model.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJPA implements CustomerService {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    @Override
    public List<CustomerDTO> listCustomers() {
        return null;
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteById(UUID customerId) {

    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {

    }
}
