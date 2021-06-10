package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String fechaPago;

    @Column
    private boolean estado;

    @OneToOne
    private Cliente clientes;

    @ManyToOne
    private Servicio servicio;

}
