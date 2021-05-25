package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "rolvo")
public class RolVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    // QwQ
    @Column
    private String tipo_rol;

    public RolVo() {
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getTipo_rol() {
        return tipo_rol;
    }

    public void setTipo_rol(String tipo_rol) {
        this.tipo_rol = tipo_rol;
    }


}
