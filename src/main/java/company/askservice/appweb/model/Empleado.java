package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
public class Empleado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String apellido;

    @Column(length = 8, nullable = false, unique = true)
    private String dni;

    @Column(length = 45, unique = true)
    private String email;

    @Column(length = 500)
    private String descripcion;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 9, unique = true)
    private String telefono;

    @Column(length = 5)
    private String estado;

    private String img;
}
