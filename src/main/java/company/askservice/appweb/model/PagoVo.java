package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "pagosvo")
public class PagoVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;

    @Column(length = 10)
    private String fecha_pago;

    @Column
    private boolean estado;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private ClienteVo clientes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_servicio")
    private ServicioVo serviciovo;


    public PagoVo() {
    }

    public PagoVo(Long id_pago, String fecha_pago, boolean estado, ClienteVo clientes) {
        this.id_pago = id_pago;
        this.fecha_pago = fecha_pago;
        this.estado = estado;
        this.clientes = clientes;
    }

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public ClienteVo getClientes() {
        return clientes;
    }

    public void setClientes(ClienteVo clientes) {
        this.clientes = clientes;
    }


}
