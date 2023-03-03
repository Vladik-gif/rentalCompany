package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.PaymentDTOEntity;
import uk.vladik.rentalCompany.store.entities.PaymentEntity;

import java.util.stream.Collectors;

@Component
public class PaymentDTOFactory {

    private final OrderDTOFactory orderFactory;

    public PaymentDTOFactory(OrderDTOFactory orderFactory) {
        this.orderFactory = orderFactory;
    }

    public PaymentDTOEntity makePayment(PaymentEntity payment){
        PaymentDTOEntity entity = new PaymentDTOEntity();

        entity.setId(payment.getId());
        entity.setOrder(payment.getOrder().stream().map(orderFactory::makeOrder)
                .collect(Collectors.toList()));
        entity.setPayment_date(payment.getPayment_date());
        entity.setSum_pay(payment.getSum_pay());
        entity.setTo_pay(payment.getTo_pay());

        return entity;
    }

}
