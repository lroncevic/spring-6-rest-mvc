package com.lukaroncevic.spring6restmvc.mappers;

import com.lukaroncevic.spring6restmvc.entities.Customer;
import com.lukaroncevic.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);

    CustomerDTO customerToCustomerDto(Customer customer);
}
