package uk.vladik.rentalCompany.api.dto;



import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Component
public class OrderDTOEntity {

    private Long id;
    private List<ProductDTOEntity> product;
    private List<WorkerDTOEntity> worker;
    private List<CustomerDTOEntity> customer;
    private Instant order_date = Instant.now();
    private Date return_date;
    private String order_status;

    public OrderDTOEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductDTOEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductDTOEntity> product) {
        this.product = product;
    }

    public List<WorkerDTOEntity> getWorker() {
        return worker;
    }

    public void setWorker(List<WorkerDTOEntity> worker) {
        this.worker = worker;
    }

    public List<CustomerDTOEntity> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerDTOEntity> customer) {
        this.customer = customer;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}
