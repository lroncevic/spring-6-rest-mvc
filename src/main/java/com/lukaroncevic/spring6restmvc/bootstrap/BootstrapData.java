package com.lukaroncevic.spring6restmvc.bootstrap;

import com.lukaroncevic.spring6restmvc.entities.Beer;
import com.lukaroncevic.spring6restmvc.entities.Customer;
import com.lukaroncevic.spring6restmvc.model.BeerStyle;
import com.lukaroncevic.spring6restmvc.repositories.BeerRepository;
import com.lukaroncevic.spring6restmvc.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {

        if(beerRepository.count() == 0) {
            Beer beer1 = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("123456")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12345622")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyle.IPA)
                    .upc("123499")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }
    }

    private void loadCustomerData() {

        if (customerRepository.count() == 0) {
            Customer customer1 = Customer.builder()
                    .name("Luka Rončević")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .name("Laura Kovačić")
                    .createdDate(LocalDateTime.now())
                    .updatedDate(LocalDateTime.now())
                    .build();

            customerRepository.save(customer1);
            customerRepository.save(customer2);
        }
    }
}
