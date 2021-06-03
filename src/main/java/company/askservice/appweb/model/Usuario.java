package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_administrador",referencedColumnName = "id")
    private Administrador administrador;

    @OneToOne
    @JoinColumn(name = "id_empleado",referencedColumnName = "id")
    private Empleado empleado;

    @OneToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_rol",referencedColumnName = "id")
    private Rol rol;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false, unique = true)
    private String contrasena;
}
