package uk.vladik.rentalCompany.store.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany
    @JoinColumn(name = "product_categories_id")
    private List<ProductCategoriesEntity> productCategoriesEntity = new ArrayList<>();

    private double salary;

    public ProductEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductCategoriesEntity> getProductCategoriesEntity() {
        return productCategoriesEntity;
    }

    public void setProductCategoriesEntity(List<ProductCategoriesEntity> productCategoriesEntity) {
        this.productCategoriesEntity = productCategoriesEntity;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
