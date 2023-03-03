package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.CustomerDTOEntity;
import uk.vladik.rentalCompany.store.entities.CustomerEntity;

@Component
public class CustomerDTOFactory {

    public CustomerDTOEntity makeCustomer(CustomerEntity customer){
        CustomerDTOEntity entity = new CustomerDTOEntity();

        entity.setId(customer.getId());
        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setBirth(customer.getBirth());

        return entity;
    }

}
