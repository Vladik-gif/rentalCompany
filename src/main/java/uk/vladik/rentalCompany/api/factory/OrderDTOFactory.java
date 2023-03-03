package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.OrderDTOEntity;
import uk.vladik.rentalCompany.store.entities.OrderEntity;

import java.util.stream.Collectors;

@Component
public class OrderDTOFactory {

    private final CustomerDTOFactory customerDTOFactory;
    private final ProductDTOFactory productDTOFactory;
    private final WorkerDTOFactory workerDTOFactory;

    public OrderDTOFactory(CustomerDTOFactory customerDTOFactory,
                           ProductDTOFactory productDTOFactory,
                           WorkerDTOFactory workerDTOFactory) {
        this.customerDTOFactory = customerDTOFactory;
        this.productDTOFactory = productDTOFactory;
        this.workerDTOFactory = workerDTOFactory;
    }

    public OrderDTOEntity makeOrder(OrderEntity order){
        OrderDTOEntity entity = new OrderDTOEntity();

        entity.setId(order.getId());
        entity.setCustomer(order.getCustomer().stream().map(customerDTOFactory::makeCustomer)
                .collect(Collectors.toList()));
        entity.setProduct(order.getProduct().stream().map(productDTOFactory::makeProduct)
                .collect(Collectors.toList()));
        entity.setWorker(order.getWorker().stream().map(workerDTOFactory::makeWorker)
                .collect(Collectors.toList()));
        entity.setOrder_date(order.getOrder_date());
        entity.setReturn_date(order.getReturn_date());

        return entity;
    }
}
