package uk.vladik.rentalCompany.api.factory;

import org.springframework.stereotype.Component;
import uk.vladik.rentalCompany.api.dto.WorkerDTOEntity;
import uk.vladik.rentalCompany.store.entities.WorkerEntity;

@Component
public class WorkerDTOFactory {

    public WorkerDTOEntity makeWorker(WorkerEntity worker){
        WorkerDTOEntity entity = new WorkerDTOEntity();

        entity.setId(worker.getId());
        entity.setName(worker.getName());
        entity.setPosition(worker.getPosition());
        entity.setEmail(worker.getEmail());
        entity.setPhone(worker.getPhone());
        entity.setBirth(worker.getBirth());

        return entity;
    }
}
