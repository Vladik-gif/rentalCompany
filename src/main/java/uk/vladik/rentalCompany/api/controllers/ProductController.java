package uk.vladik.rentalCompany.api.controllers;

import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.ProductDTOEntity;
import uk.vladik.rentalCompany.api.services.ProductService;
import uk.vladik.rentalCompany.store.entities.ProductEntity;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private static final String CREATE_CUSTOMER = "/create";
    private static final String UPDATE_CUSTOMER = "/update/{id}";
    private static final String GET_CUSTOMER = "/get";
    private static final String GET_ONE_CUSTOMER = "/{id}";
    private static final String DELETE_CUSTOMER_ID = "/delete/{id}";
    private static final String DELETE_ALL_CUSTOMER = "/delete";

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(CREATE_CUSTOMER)
    public ProductDTOEntity create(@RequestBody ProductEntity entity){
        return productService.create(entity);
    }

    @PutMapping(UPDATE_CUSTOMER)
    public ProductDTOEntity update(@RequestParam Long id, @RequestBody ProductEntity entity){
        return productService.update(id, entity);
    }

    @GetMapping(GET_CUSTOMER)
    public List<ProductDTOEntity> getAll(){
        return productService.getAll();
    }

    @GetMapping(GET_ONE_CUSTOMER)
    public ProductDTOEntity getOne(@RequestParam Long id){
        return productService.getOne(id);
    }

    @DeleteMapping(DELETE_CUSTOMER_ID)
    public void deleteId(@RequestParam Long id){
        productService.deleteId(id);
    }

    @DeleteMapping(DELETE_ALL_CUSTOMER)
    public void deleteAll(){
        productService.deleteAll();
    }
}
