package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "empleado")
@Data
public class Empleado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String apellido;

    @Column(length = 500)
    private String descripción;

    @Column(length = 8, nullable = false, unique = true)
    private String dni;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 5)
    private String estado;

    @Column(length = 100)
    private String nombre;

    @Column(length = 9, nullable = false, unique = true)
    private String telefono;

    @ManyToMany
    private List<Servicio> servicios;

}
