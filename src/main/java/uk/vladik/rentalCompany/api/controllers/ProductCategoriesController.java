package uk.vladik.rentalCompany.api.controllers;

import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.ProductCategoriesDTOEntity;
import uk.vladik.rentalCompany.api.services.ProductCategoriesService;
import uk.vladik.rentalCompany.store.entities.ProductCategoriesEntity;

@RestController
@RequestMapping("/productCategories")
public class ProductCategoriesController {

    private final ProductCategoriesService productCategoriesService;

    private static final String CREATE_PRODUCT_CATEGORIES = "/create";
    private static final String DELETE_PRODUCT_CATEGORIES_ID = "/delete/{id}";

    public ProductCategoriesController(ProductCategoriesService productCategoriesService) {
        this.productCategoriesService = productCategoriesService;
    }

    @PostMapping(CREATE_PRODUCT_CATEGORIES)
    public ProductCategoriesDTOEntity create(ProductCategoriesEntity productCategoriesEntity){
        return productCategoriesService.create(productCategoriesEntity);
    }

    @DeleteMapping(DELETE_PRODUCT_CATEGORIES_ID)
    public void deleteId(@RequestParam Long id){
        productCategoriesService.deleteId(id);
    }

}
