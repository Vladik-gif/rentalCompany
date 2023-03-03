package uk.vladik.rentalCompany.api.controllers;



import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.PaymentDTOEntity;
import uk.vladik.rentalCompany.api.services.PaymentService;
import uk.vladik.rentalCompany.store.entities.PaymentEntity;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    private static final String CREATE_PAYMENT = "/create";
    private static final String UPDATE_PAYMENT = "/update/{id}";
    private static final String GET_PAYMENT = "/get";
    private static final String DELETE_ALL_PAYMENT = "/delete";

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(CREATE_PAYMENT)
    public PaymentDTOEntity create(@RequestBody PaymentEntity entity){
        return paymentService.create(entity);
    }

    @PutMapping(UPDATE_PAYMENT)
    public PaymentDTOEntity update(@RequestParam Long id, @RequestBody PaymentEntity entity){
        return paymentService.update(id, entity);
    }

    @GetMapping(GET_PAYMENT)
    public List<PaymentDTOEntity> getAll(){
        return paymentService.getAll();
    }

    @DeleteMapping(DELETE_ALL_PAYMENT)
    public void deleteAll(){
        paymentService.deleteAll();
    }
}
