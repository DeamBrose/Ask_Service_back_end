package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 9, nullable = false, unique = true)
    private int telefono;

    @Column(length = 200)
    private String dirección;
}
