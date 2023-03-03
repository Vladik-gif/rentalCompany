package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.ProductDTOEntity;
import uk.vladik.rentalCompany.store.entities.ProductEntity;


@Component
public class ProductDTOFactory {

    public ProductDTOEntity makeProduct(ProductEntity entity){
        ProductDTOEntity product = new ProductDTOEntity();

        product.setId(product.getId());
        product.setProductCategoriesEntity(product.getProductCategoriesEntity());
        product.setSalary(product.getSalary());

        return product;
    }
}
