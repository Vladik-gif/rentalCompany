package uk.vladik.rentalCompany.api.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDTOEntity {

    private Long id;
    private List<ProductCategoriesDTOEntity> productCategoriesEntity;
    private double salary;

    public ProductDTOEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductCategoriesDTOEntity> getProductCategoriesEntity() {
        return productCategoriesEntity;
    }

    public void setProductCategoriesEntity(List<ProductCategoriesDTOEntity> productCategoriesEntity) {
        this.productCategoriesEntity = productCategoriesEntity;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
