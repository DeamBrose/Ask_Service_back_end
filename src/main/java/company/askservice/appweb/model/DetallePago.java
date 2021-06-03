package company.askservice.appweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "detallepago")
@Data
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_pago", referencedColumnName = "id")
    private Pago pago;

    @Column(length = 200)
    private String direccion;

    @Column
    private double importe;

}
