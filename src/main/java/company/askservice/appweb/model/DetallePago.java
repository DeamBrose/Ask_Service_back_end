package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pago pago;

    @Column(length = 200)
    private String direccion;

    @Column
    private double importe;
}
