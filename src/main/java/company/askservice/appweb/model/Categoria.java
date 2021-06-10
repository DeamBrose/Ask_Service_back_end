package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;
}
