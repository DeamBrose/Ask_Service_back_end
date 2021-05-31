package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // QwQ
    @Column
    private String tipoRol;

    public Rol() {
    }

    public Rol(Long id, String tipoRol) {
        this.id = id;
        this.tipoRol = tipoRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }
}
