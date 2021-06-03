package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tipoRol;

}
