package uk.vladik.rentalCompany.api.dto;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;

@Component
public class PaymentDTOEntity {

    private Long id;
    private List<OrderDTOEntity> order;
    private double order_number;
    private double to_pay;
    private double sum_pay;

    private Instant payment_date = Instant.now();

    public PaymentDTOEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getOrder_number() {
        return order_number;
    }

    public void setOrder_number(double order_number) {
        this.order_number = order_number;
    }

    public double getTo_pay() {
        return to_pay;
    }

    public void setTo_pay(double to_pay) {
        this.to_pay = to_pay;
    }

    public double getSum_pay() {
        return sum_pay;
    }

    public void setSum_pay(double sum_pay) {
        this.sum_pay = sum_pay;
    }

    public void setSum_pay(int sum_pay) {
        this.sum_pay = sum_pay;
    }

    public Instant getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Instant payment_date) {
        this.payment_date = payment_date;
    }

    public List<OrderDTOEntity> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDTOEntity> order) {
        this.order = order;
    }
}
