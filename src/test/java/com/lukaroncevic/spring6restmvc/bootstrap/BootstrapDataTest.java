package com.lukaroncevic.spring6restmvc.bootstrap;

import com.lukaroncevic.spring6restmvc.repositories.BeerRepository;
import com.lukaroncevic.spring6restmvc.repositories.CustomerRepository;
import com.lukaroncevic.spring6restmvc.services.BeerCsvService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class BootstrapDataTest {

    @Autowired
    BeerRepository beerRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerCsvService beerCsvService;

    BootstrapData bootstrapData;

    @BeforeEach
    void setUp() {
        bootstrapData = new BootstrapData(beerRepository, customerRepository, beerCsvService);
    }

    @Test
    void run() throws Exception {
        bootstrapData.run(null);

        assertThat(beerRepository.count()).isEqualTo(3);
        assertThat(customerRepository.count()).isEqualTo(2);
    }
}