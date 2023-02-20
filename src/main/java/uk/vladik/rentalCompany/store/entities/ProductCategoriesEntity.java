package uk.vladik.rentalCompany.store.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_categories")
public class ProductCategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    public ProductCategoriesEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductCategoriesEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
