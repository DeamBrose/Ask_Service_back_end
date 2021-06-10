package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Servicio implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String nombre;

    @Column
    private double precio;

    @Column(length = 500)
    private String descripcion;

    @ManyToOne
    private Categoria categoria;
}
