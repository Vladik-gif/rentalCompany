package uk.vladik.rentalCompany.store.entities;


import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductEntity> product = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "worker_id")
    private List<WorkerEntity> worker = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<CustomerEntity> customer = new ArrayList<>();

    private Instant order_date = Instant.now();
    private Date return_date;
    private String order_status;


    public OrderEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductEntity> getProduct() {
        return product;
    }

    public void setProduct(List<ProductEntity> product) {
        this.product = product;
    }

    public List<WorkerEntity> getWorker() {
        return worker;
    }

    public void setWorker(List<WorkerEntity> worker) {
        this.worker = worker;
    }

    public List<CustomerEntity> getCustomer() {
        return customer;
    }

    public void setCustomer(List<CustomerEntity> customer) {
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
