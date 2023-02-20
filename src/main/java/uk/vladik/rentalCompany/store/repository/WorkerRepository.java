package uk.vladik.rentalCompany.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.vladik.rentalCompany.store.entities.ProductEntity;
import uk.vladik.rentalCompany.store.entities.WorkerEntity;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

}
