package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private  String apellido;

}
