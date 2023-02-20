package uk.vladik.rentalCompany.store.entities;


import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity worker;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    private Integer order_date;
    private Integer return_date;
    private String order_status;



    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public WorkerEntity getWorker() {
        return worker;
    }

    public void setWorker(WorkerEntity worker) {
        this.worker = worker;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }


}
