package com.lukaroncevic.spring6restmvc.services;

import com.lukaroncevic.spring6restmvc.model.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<UUID, CustomerDTO> customerMap;

    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();

        CustomerDTO customerDTO1 = CustomerDTO.builder()
                .name("Luka Rončević")
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        CustomerDTO customerDTO2 = CustomerDTO.builder()
                .name("Laura Kovačić")
                .id(UUID.randomUUID())
                .version(1)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        customerMap.put(customerDTO1.getId(), customerDTO1);
        customerMap.put(customerDTO2.getId(), customerDTO2);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID id) {

        return Optional.of(customerMap.get(id));
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {

        CustomerDTO savedCustomerDTO = CustomerDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .name(customerDTO.getName())
                .version(1)
                .build();

        customerMap.put(savedCustomerDTO.getId(), savedCustomerDTO);

        return savedCustomerDTO;
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDTO customerDTO) {

        CustomerDTO existing = customerMap.get(customerId);
        existing.setName(customerDTO.getName());
    }

    @Override
    public void deleteById(UUID customerId) {
        customerMap.remove(customerId);
    }

    @Override
    public void patchCustomerById(UUID customerId, CustomerDTO customerDTO) {
        CustomerDTO existed = customerMap.get(customerId);

        if(StringUtils.hasText(customerDTO.getName())){
            existed.setName(customerDTO.getName());
        }
    }
}
