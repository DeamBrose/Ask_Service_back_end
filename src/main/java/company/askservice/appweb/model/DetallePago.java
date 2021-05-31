package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "detallepago")
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

    public DetallePago() {
    }

    public DetallePago(Long id, Pago pago, String direccion, double importe) {
        this.id = id;
        this.pago = pago;
        this.direccion = direccion;
        this.importe = importe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
