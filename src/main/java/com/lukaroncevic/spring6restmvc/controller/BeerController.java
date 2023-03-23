package com.lukaroncevic.spring6restmvc.controller;

import com.lukaroncevic.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BeerController {

    private final BeerService beerService;
}
