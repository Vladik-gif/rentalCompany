package uk.vladik.rentalCompany.api.controllers;



import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.OrderDTOEntity;
import uk.vladik.rentalCompany.api.services.OrderService;
import uk.vladik.rentalCompany.store.entities.OrderEntity;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private static final String CREATE_ORDER = "/create";
    private static final String UPDATE_ORDER = "/update/{id}";
    private static final String GET_ORDER = "/get";
    private static final String GET_ONE_ORDER = "/{id}";
    private static final String DELETE_ORDER_ID = "/delete/{id}";
    private static final String DELETE_ALL_ORDER = "/delete";

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(CREATE_ORDER)
    public OrderDTOEntity create(@RequestBody OrderEntity entity){
        return orderService.create(entity);
    }

    @PutMapping(UPDATE_ORDER)
    public OrderDTOEntity update(@RequestParam Long id, @RequestBody OrderEntity entity){
        return orderService.update(id, entity);
    }

    @GetMapping(GET_ORDER)
    public List<OrderDTOEntity> getAll(){
        return orderService.getAll();
    }

    @GetMapping(GET_ONE_ORDER)
    public OrderDTOEntity getOne(@RequestParam Long id){
        return orderService.getOne(id);
    }

    @DeleteMapping(DELETE_ORDER_ID)
    public void deleteId(@RequestParam Long id){
        orderService.deleteId(id);
    }

    @DeleteMapping(DELETE_ALL_ORDER)
    public void deleteAll(){
        orderService.deleteAll();
    }
}
