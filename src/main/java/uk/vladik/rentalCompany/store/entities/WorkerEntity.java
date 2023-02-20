package uk.vladik.rentalCompany.store.entities;

import javax.persistence.*;

@Entity
@Table(name = "worker")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String position;
    private String name;
    private String email;
    private String birth;
    private int phone;
}
