package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(length = 9, nullable = false, unique = true)
    private Integer telefono;

    @Column(length = 8, nullable = false, unique = true)
    private Integer dni;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 500)
    private String descripcion;

    @Column(length = 5)
    private String estado;

}
