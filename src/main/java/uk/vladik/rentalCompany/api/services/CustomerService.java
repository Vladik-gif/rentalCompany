package uk.vladik.rentalCompany.api.services;

import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.CustomerDTOEntity;
import uk.vladik.rentalCompany.api.factory.CustomerDTOFactory;
import uk.vladik.rentalCompany.store.entities.CustomerEntity;
import uk.vladik.rentalCompany.store.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerDTOFactory customerDTOFactory;
    private CustomerRepository customerRepository;

    public CustomerService(CustomerDTOFactory customerDTOFactory,
                           CustomerRepository customerRepository) {
        this.customerDTOFactory = customerDTOFactory;
        this.customerRepository = customerRepository;
    }

    public CustomerDTOEntity create(CustomerEntity customerEntity){
        return customerDTOFactory.makeCustomer(customerRepository.save(customerEntity));
    }

    public List<CustomerDTOEntity> getAll() {
        return customerRepository.findAll().stream()
                .map(customerDTOFactory::makeCustomer)
                .collect(Collectors.toList());
    }

    public CustomerDTOEntity getOne(Long id) {
        CustomerEntity customer = customerRepository.getReferenceById(id);

        return customerDTOFactory.makeCustomer(customer);
    }


    public CustomerDTOEntity update(Long id, CustomerEntity customer) {
        CustomerEntity entity = customerRepository.getReferenceById(id);

        entity.setName(customer.getName());
        entity.setPhone(customer.getPhone());
        entity.setEmail(customer.getEmail());
        entity.setBirth(customer.getBirth());

        return customerDTOFactory.makeCustomer(entity);
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
