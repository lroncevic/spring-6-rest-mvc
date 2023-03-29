package com.lukaroncevic.spring6restmvc.repositories;

import com.lukaroncevic.spring6restmvc.entities.Beer;
import com.lukaroncevic.spring6restmvc.model.BeerStyle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {

    List<Beer> findAllByBeerNameIsLikeIgnoreCase(String beerName);
    List<Beer> findAllByBeerStyle(BeerStyle beerStyle);
    List<Beer> findAllByBeerNameIsLikeIgnoreCaseAndBeerStyle(String beerName, BeerStyle beerStyle);
}
