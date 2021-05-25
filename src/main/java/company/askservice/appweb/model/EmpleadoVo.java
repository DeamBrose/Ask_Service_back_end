package company.askservice.appweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "empleadosvo")
public class EmpleadoVo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_empleado;

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

    public EmpleadoVo(Long id_empleado, String nombre, String apellido, Integer telefono, Integer dni, String email, String descripción) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.email = email;
        this.descripción = descripción;
    }

    public Long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Long id_empleado) {
        this.id_empleado = id_empleado;
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

    @Override
    public String toString() {
        return "EmpleadoVo{" +
                "id_empleado=" + id_empleado +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", descripción='" + descripción + '\'' +
                ", servicios=" + servicios +
                '}';
    }
}
