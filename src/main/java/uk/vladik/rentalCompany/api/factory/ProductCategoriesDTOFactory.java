package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.ProductCategoriesDTOEntity;
import uk.vladik.rentalCompany.store.entities.ProductCategoriesEntity;

@Component
public class ProductCategoriesDTOFactory {

    public ProductCategoriesDTOEntity makeProductCategories(ProductCategoriesEntity productCategories){
        ProductCategoriesDTOEntity entity = new ProductCategoriesDTOEntity();

        entity.setId(productCategories.getId());
        entity.setName(productCategories.getName());

        return entity;
    }
}
