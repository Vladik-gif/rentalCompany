package uk.vladik.rentalCompany.api.services;

import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.OrderDTOEntity;
import uk.vladik.rentalCompany.api.factory.OrderDTOFactory;
import uk.vladik.rentalCompany.store.entities.OrderEntity;
import uk.vladik.rentalCompany.store.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderDTOFactory orderDTOFactory;
    private final OrderRepository orderRepository;


    public OrderService(OrderDTOFactory orderDTOFactory, OrderRepository orderRepository) {
        this.orderDTOFactory = orderDTOFactory;
        this.orderRepository = orderRepository;
    }

    public OrderDTOEntity create(OrderEntity entity){
        return orderDTOFactory.makeOrder(entity);
    }

    public OrderDTOEntity update(Long id, OrderEntity entity){
        OrderEntity updateOrderId = orderRepository.getReferenceById(id);

        updateOrderId.setOrder_status(entity.getOrder_status());

        return orderDTOFactory.makeOrder(updateOrderId);
    }

    public List<OrderDTOEntity> getAll(){
        return orderRepository.findAll().stream().map(orderDTOFactory::makeOrder).collect(Collectors.toList());
    }

    public OrderDTOEntity getOne(Long id){
        OrderEntity orderId = orderRepository.getReferenceById(id);
        return orderDTOFactory.makeOrder(orderId);
    }


    public void deleteAll(){
        orderRepository.deleteAll();
    }

    public void deleteId(Long id){
        orderRepository.deleteById(id);
    }
}
