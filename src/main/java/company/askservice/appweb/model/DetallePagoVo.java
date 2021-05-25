package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "detallepagovo")
public class DetallePagoVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle_pago;

    @OneToOne
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    private PagoVo pagovo;

    @Column(length = 200)
    private String direccion;

    @Column
    private double importe;

    public DetallePagoVo() {
    }

    public DetallePagoVo(Long id_detalle_pago, PagoVo pagovo, String direccion, double importe) {
        this.id_detalle_pago = id_detalle_pago;
        this.pagovo = pagovo;
        this.direccion = direccion;
        this.importe = importe;
    }

    public Long getId_detalle_pago() {
        return id_detalle_pago;
    }

    public void setId_detalle_pago(Long id_detalle_pago) {
        this.id_detalle_pago = id_detalle_pago;
    }

    public PagoVo getPagovo() {
        return pagovo;
    }

    public void setPagovo(PagoVo pagovo) {
        this.pagovo = pagovo;
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
