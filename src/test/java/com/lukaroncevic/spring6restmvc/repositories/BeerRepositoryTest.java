package com.lukaroncevic.spring6restmvc.repositories;

import com.lukaroncevic.spring6restmvc.bootstrap.BootstrapData;
import com.lukaroncevic.spring6restmvc.entities.Beer;
import com.lukaroncevic.spring6restmvc.model.BeerStyle;
import com.lukaroncevic.spring6restmvc.services.BeerCsvServiceImpl;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({BootstrapData.class, BeerCsvServiceImpl.class})
class BeerRepositoryTest {

    @Autowired
    BeerRepository beerRepository;

    @Test
    void getBeerListByName() {
        Page<Beer> list = beerRepository.findAllByBeerNameIsLikeIgnoreCase("%IPA%", null);

        assertThat(list.getContent().size()).isEqualTo(336);
    }

    @Test
    void saveBeerNameToLong() {

        assertThrows(ConstraintViolationException.class, () -> {
            Beer savedBeer = beerRepository.save(Beer.builder()
                    .beerName("My Beer 123456789123456789123456789123456789123456789123456789")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("1245124")
                    .price(new BigDecimal("11.99"))
                    .build());

            beerRepository.flush();

            assertThat(savedBeer).isNotNull();
            assertThat(savedBeer.getId()).isNotNull();
        });
    }

    @Test
    void saveBeer() {

        Beer savedBeer = beerRepository.save(Beer.builder()
                .beerName("My Beer")
                        .beerStyle(BeerStyle.PALE_ALE)
                        .upc("1245124")
                        .price(new BigDecimal("11.99"))
                .build());

        beerRepository.flush();

        assertThat(savedBeer).isNotNull();
        assertThat(savedBeer.getId()).isNotNull();
    }
}