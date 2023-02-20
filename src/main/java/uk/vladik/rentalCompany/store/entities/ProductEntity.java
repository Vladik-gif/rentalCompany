package uk.vladik.rentalCompany.store.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_categories_id")
    private ProductCategoriesEntity productCategoriesEntity;
    private String salary;

    public ProductEntity(Long id,
                         ProductCategoriesEntity productCategoriesEntity,
                         String salary) {
        this.id = id;
        this.productCategoriesEntity = productCategoriesEntity;
        this.salary = salary;
    }

    public ProductEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductCategoriesEntity getProductCategoriesEntity() {
        return productCategoriesEntity;
    }

    public void setProductCategoriesEntity(ProductCategoriesEntity productCategoriesEntity) {
        this.productCategoriesEntity = productCategoriesEntity;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
