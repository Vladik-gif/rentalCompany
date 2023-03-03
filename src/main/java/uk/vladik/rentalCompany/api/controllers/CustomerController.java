package uk.vladik.rentalCompany.api.controllers;

import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.CustomerDTOEntity;
import uk.vladik.rentalCompany.api.services.CustomerService;
import uk.vladik.rentalCompany.store.entities.CustomerEntity;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    private static final String CREATE_CUSTOMER = "/create";
    private static final String UPDATE_CUSTOMER = "/update/{id}";
    private static final String GET_CUSTOMER = "/get";
    private static final String GET_ONE_CUSTOMER = "/{id}";
    private static final String DELETE_CUSTOMER_ID = "/delete/{id}";

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(CREATE_CUSTOMER)
    public CustomerDTOEntity create(@RequestBody CustomerEntity customer){
        return customerService.create(customer);
    }

    @GetMapping(GET_CUSTOMER)
    public List<CustomerDTOEntity> get(){
        return customerService.getAll();
    }

    @GetMapping(GET_ONE_CUSTOMER)
    public CustomerDTOEntity getOne(@RequestParam Long id){
        return customerService.getOne(id);
    }

    @PutMapping(UPDATE_CUSTOMER)
    public CustomerDTOEntity update(@RequestParam Long id, @RequestBody CustomerEntity customer){
        return customerService.update(id, customer);
    }

    @DeleteMapping(DELETE_CUSTOMER_ID)
    public void delete(@RequestParam Long id){
        customerService.delete(id);
    }
}
