package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @PrePersist
    void Prepersist(){
        fechaC = new Date();
    }
    @Temporal(TemporalType.DATE)
    private Date fechaC;

    @Column
    private String estado;

    @OneToOne
    private Cliente clientes;

    @ManyToOne
    private Servicio servicio;

    @Column
    private String empleado;

    @Column
    private String descripcion;
}
