package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "categoriasvo")
public class CategoriaVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    @Column(length = 100)
    private String nombre_categoria;


    public CategoriaVo() {

    }

    public CategoriaVo(Long id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    @Override
    public String toString() {
        return "CategoriaVo{" +
                "id_categoria=" + id_categoria +
                ", nombre_categoria='" + nombre_categoria + '\'' +
                '}';
    }
}
