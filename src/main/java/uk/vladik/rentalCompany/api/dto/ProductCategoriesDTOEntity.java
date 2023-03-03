package uk.vladik.rentalCompany.api.dto;

import org.springframework.stereotype.Component;

@Component
public class ProductCategoriesDTOEntity {

    private Long id;
    private String name;

    public ProductCategoriesDTOEntity() {

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
