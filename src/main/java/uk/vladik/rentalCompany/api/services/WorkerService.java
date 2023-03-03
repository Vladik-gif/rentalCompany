package uk.vladik.rentalCompany.api.services;

import org.springframework.stereotype.Service;
import uk.vladik.rentalCompany.api.dto.CustomerDTOEntity;
import uk.vladik.rentalCompany.api.dto.WorkerDTOEntity;
import uk.vladik.rentalCompany.api.factory.WorkerDTOFactory;
import uk.vladik.rentalCompany.store.entities.CustomerEntity;
import uk.vladik.rentalCompany.store.entities.WorkerEntity;
import uk.vladik.rentalCompany.store.repository.WorkerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    private final WorkerDTOFactory workerDTOFactory;
    private final WorkerRepository workerRepository;

    public WorkerService(WorkerDTOFactory workerDTOFactory, WorkerRepository workerRepository) {
        this.workerDTOFactory = workerDTOFactory;
        this.workerRepository = workerRepository;
    }

    public WorkerDTOEntity create(WorkerEntity workerEntity){
        return workerDTOFactory.makeWorker(workerRepository.save(workerEntity));
    }

    public List<WorkerDTOEntity> getAll() {
        return workerRepository.findAll().stream().map(workerDTOFactory::makeWorker).collect(Collectors.toList());
    }

    public WorkerDTOEntity getOne(Long id) {
        WorkerEntity entity = workerRepository.getReferenceById(id);
        return  workerDTOFactory.makeWorker(entity);
    }


    public WorkerDTOEntity update(Long id, WorkerEntity entity) {
        WorkerEntity worker = workerRepository.getReferenceById(id);

        worker.setName(entity.getName());
        worker.setPosition(entity.getPosition());
        worker.setEmail(entity.getEmail());
        worker.setBirth(entity.getBirth());
        worker.setPhone(entity.getPhone());

        return workerDTOFactory.makeWorker(worker);
    }

    public void delete(Long id){
        workerRepository.deleteById(id);
    }
}
