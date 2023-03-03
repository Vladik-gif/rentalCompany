package uk.vladik.rentalCompany.api.controllers;

import org.springframework.web.bind.annotation.*;
import uk.vladik.rentalCompany.api.dto.WorkerDTOEntity;
import uk.vladik.rentalCompany.api.services.WorkerService;
import uk.vladik.rentalCompany.store.entities.WorkerEntity;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerService workerService;

    private static final String CREATE_WORKER = "/create";
    private static final String UPDATE_WORKER = "/update/{id}";
    private static final String GET_WORKER = "/get";
    private static final String GET_ONE_WORKER = "/{id}";
    private static final String DELETE_WORKER_ID = "/delete/{id}";

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(CREATE_WORKER)
    public WorkerDTOEntity create(@RequestBody WorkerEntity worker){
        return workerService.create(worker);
    }

    @PutMapping(UPDATE_WORKER)
    public WorkerDTOEntity update(@RequestParam Long id, @RequestBody WorkerEntity worker){
        return workerService.update(id, worker);
    }

    @GetMapping(GET_WORKER)
    public List<WorkerDTOEntity> get(){
        return workerService.getAll();
    }

    @GetMapping(GET_ONE_WORKER)
    public WorkerDTOEntity getOne(@RequestParam Long id){
        return workerService.getOne(id);
    }

    @DeleteMapping(DELETE_WORKER_ID)
    public void delete(@RequestParam Long id){
        workerService.delete(id);
    }
}
