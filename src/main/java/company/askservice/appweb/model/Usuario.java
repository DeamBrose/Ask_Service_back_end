package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Administrador administrador;

    @OneToOne
    private Empleado empleado;

    @OneToOne
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Rol rol;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false, unique = true)
    private String contrasena;
}
