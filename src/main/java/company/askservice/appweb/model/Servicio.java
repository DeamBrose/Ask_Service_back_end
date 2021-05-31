package company.askservice.appweb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "serviciosvo")
public class ServicioVo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_servicio;

    @Column(length = 200)
    private String nombre_servcio;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private CategoriaVo categoriavo;

    @ManyToMany(mappedBy = "servicios")
    private List<EmpleadoVo> empleados;


    public ServicioVo() {
    }

    public Long getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(Long id_servicio) {
        this.id_servicio = id_servicio;
    }

    public String getNombre_servcio() {
        return nombre_servcio;
    }

    public void setNombre_servcio(String nombre_servcio) {
        this.nombre_servcio = nombre_servcio;
    }

    public CategoriaVo getCategoriavo() {
        return categoriavo;
    }

    public void setCategoriavo(CategoriaVo categoriavo) {
        this.categoriavo = categoriavo;
    }



}
