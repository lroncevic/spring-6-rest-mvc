package com.lukaroncevic.spring6restmvc.services;

import com.lukaroncevic.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID id);
}
