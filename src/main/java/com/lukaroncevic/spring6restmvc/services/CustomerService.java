package com.lukaroncevic.spring6restmvc.services;

import com.lukaroncevic.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {

    List<CustomerDTO> listCustomers();

    Optional<CustomerDTO> getCustomerById(UUID id);

    CustomerDTO saveNewCustomer(CustomerDTO customerDTO);

    void updateCustomerById(UUID customerId, CustomerDTO customerDTO);

    void deleteById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customerDTO);
}
