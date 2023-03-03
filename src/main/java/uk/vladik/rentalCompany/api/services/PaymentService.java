package uk.vladik.rentalCompany.api.services;


import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.PaymentDTOEntity;
import uk.vladik.rentalCompany.api.factory.PaymentDTOFactory;
import uk.vladik.rentalCompany.store.entities.PaymentEntity;
import uk.vladik.rentalCompany.store.repository.PaymentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final PaymentDTOFactory paymentDTOFactory;
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentDTOFactory paymentDTOFactory, PaymentRepository paymentRepository) {
        this.paymentDTOFactory = paymentDTOFactory;
        this.paymentRepository = paymentRepository;
    }

    public PaymentDTOEntity create(PaymentEntity entity){
        return paymentDTOFactory.makePayment(paymentRepository.save(entity));
    }

    public List<PaymentDTOEntity> getAll(){
        return paymentRepository.findAll().stream().map(paymentDTOFactory::makePayment).collect(Collectors.toList());
    }

    public PaymentDTOEntity update(Long id, PaymentEntity entity){
        PaymentEntity updatePaymentId = paymentRepository.getReferenceById(id);

        updatePaymentId.setTo_pay(entity.getTo_pay());
        updatePaymentId.setSum_pay(entity.getSum_pay());

        return paymentDTOFactory.makePayment(updatePaymentId);
    }

    public void deleteAll(){
        paymentRepository.deleteAll();
    }
}
