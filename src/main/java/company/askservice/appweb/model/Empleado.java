package company.askservice.appweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "empleadosvo")
public class EmpleadoVo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(length = 9, nullable = false, unique = true)
    private Integer telefono;

    @Column(length = 8, nullable = false, unique = true)
    private Integer dni;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 500)
    private String descripción;

    @ManyToMany
    private List<ServicioVo> servicios;


    public EmpleadoVo() {
    }

    public EmpleadoVo(Long id, String nombre, String apellido, Integer telefono, Integer dni, String email, String descripción, List<ServicioVo> servicios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.email = email;
        this.descripción = descripción;
        this.servicios = servicios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public List<ServicioVo> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioVo> servicios) {
        this.servicios = servicios;
    }
}
