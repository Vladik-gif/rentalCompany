package uk.vladik.rentalCompany.store.entities;


import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    private String birth;
    private int phone;
}
