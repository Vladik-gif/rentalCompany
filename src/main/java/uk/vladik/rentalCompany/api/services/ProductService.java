package uk.vladik.rentalCompany.api.services;


import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.ProductDTOEntity;
import uk.vladik.rentalCompany.api.factory.ProductDTOFactory;
import uk.vladik.rentalCompany.store.entities.ProductEntity;
import uk.vladik.rentalCompany.store.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDTOFactory productDTOFactory;

    public ProductService(ProductRepository productRepository, ProductDTOFactory productDTOFactory) {
        this.productRepository = productRepository;
        this.productDTOFactory = productDTOFactory;
    }

    public ProductDTOEntity create(ProductEntity product){
        return productDTOFactory.makeProduct(productRepository.save(product));
    }

    public List<ProductDTOEntity> getAll(){
        return productRepository.findAll().stream().map(productDTOFactory::makeProduct).collect(Collectors.toList());
    }

    public ProductDTOEntity getOne(Long id){
        ProductEntity productId = productRepository.getReferenceById(id);
        return productDTOFactory.makeProduct(productId);
    }

    public ProductDTOEntity update(Long id, ProductEntity entity){
        ProductEntity updateProductId = productRepository.getReferenceById(id);

        updateProductId.setSalary(entity.getSalary());
        updateProductId.setProductCategoriesEntity(entity.getProductCategoriesEntity());

        return productDTOFactory.makeProduct(updateProductId);
    }

    public void deleteAll(){
        productRepository.deleteAll();
    }

    public void deleteId(Long id){
        productRepository.deleteById(id);
    }

}
