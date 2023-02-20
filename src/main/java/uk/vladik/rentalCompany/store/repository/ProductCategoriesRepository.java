package uk.vladik.rentalCompany.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.vladik.rentalCompany.store.entities.ProductCategoriesEntity;

@Repository
public interface ProductCategoriesRepository extends JpaRepository<ProductCategoriesEntity, Long> {

}
