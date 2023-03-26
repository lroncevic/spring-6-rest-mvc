package com.lukaroncevic.spring6restmvc.mappers;

import com.lukaroncevic.spring6restmvc.entities.Beer;
import com.lukaroncevic.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDTO(Beer beer);
}
