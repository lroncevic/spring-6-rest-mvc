package com.lukaroncevic.spring6restmvc.repositories;

import com.lukaroncevic.spring6restmvc.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void saveCustomer() {

        Customer customer = customerRepository.save(Customer.builder()
                .name("New Name")
                .build());

        assertThat(customer.getId()).isNotNull();
    }
}