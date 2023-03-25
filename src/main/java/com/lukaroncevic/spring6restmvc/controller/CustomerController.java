package com.lukaroncevic.spring6restmvc.controller;

import com.lukaroncevic.spring6restmvc.model.CustomerDTO;
import com.lukaroncevic.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class CustomerController {

    public static final String CUSTOMER_PATH = "/api/v1/customer";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";

    private final CustomerService customerService;

    @PatchMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateCustomerPatchById(@PathVariable("customerId") UUID customerId,
                                                  @RequestBody CustomerDTO customerDTO){

        customerService.patchCustomerById(customerId, customerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(CUSTOMER_PATH_ID)
    public ResponseEntity deleteBuild(@PathVariable("customerId") UUID customerId){

        customerService.deleteById(customerId);

        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CUSTOMER_PATH_ID)
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDTO customerDTO){

        customerService.updateCustomerById(customerId, customerDTO);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(CUSTOMER_PATH)
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDTO){

        CustomerDTO savedCustomerDTO = customerService.saveNewCustomer(customerDTO);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", CUSTOMER_PATH + "/"+ savedCustomerDTO.getId().toString());

        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(CUSTOMER_PATH)
    public List<CustomerDTO> listCustomers(){
        return customerService.listCustomers();
    }

    @GetMapping(value = CUSTOMER_PATH_ID)
    public CustomerDTO getCustomerById(@PathVariable("customerId") UUID customerId){

        return customerService.getCustomerById(customerId).orElseThrow(NotFoundException::new);
    }
}
