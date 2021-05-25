package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "administradorvo")
public class AdministradorVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_administrador;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private  String apellido;


    public AdministradorVo() {
    }

    public AdministradorVo(Long id_administrador, String nombre, String apellido) {
        this.id_administrador = id_administrador;
        this.nombre = nombre;
        this.apellido = apellido;

    }

    public Long getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(Long id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "AdministradorVo{" +
                "id_administrador=" + id_administrador +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido +
                '}';
    }
}
