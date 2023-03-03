package uk.vladik.rentalCompany.api.services;

import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.ProductCategoriesDTOEntity;
import uk.vladik.rentalCompany.api.factory.ProductCategoriesDTOFactory;
import uk.vladik.rentalCompany.store.entities.ProductCategoriesEntity;
import uk.vladik.rentalCompany.store.repository.ProductCategoriesRepository;

@Service
public class ProductCategoriesService {

    private final ProductCategoriesDTOFactory productCategoriesDTOFactory;
    private final ProductCategoriesRepository productCategoriesRepository;

    public ProductCategoriesService(ProductCategoriesDTOFactory productCategoriesDTOFactory,
                                    ProductCategoriesRepository productCategoriesRepository) {
        this.productCategoriesDTOFactory = productCategoriesDTOFactory;
        this.productCategoriesRepository = productCategoriesRepository;
    }

    public ProductCategoriesDTOEntity create(ProductCategoriesEntity productCategoriesEntity){
        return productCategoriesDTOFactory.makeProductCategories(productCategoriesEntity);
    }

    public void deleteId(Long id){
        productCategoriesRepository.deleteById(id);
    }
}
