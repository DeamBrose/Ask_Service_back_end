package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "clientesvo")
public class ClienteVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String apellido;

    @Column(length = 45, nullable = false, unique = true)
    private String email;

    @Column(length = 9, nullable = false, unique = true)
    private int telefono_1;

    @Column(length = 9, unique = true)
    private int telefono_2;

    @Column(length = 200)
    private String dirección;

    public ClienteVo() {
    }

    public ClienteVo(Long id_cliente, String nombre, String apellido, String email, int telefono_1, int telefono_2, String dirección) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono_1 = telefono_1;
        this.telefono_2 = telefono_2;
        this.dirección = dirección;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono_1() {
        return telefono_1;
    }

    public void setTelefono_1(int telefono_1) {
        this.telefono_1 = telefono_1;
    }

    public int getTelefono_2() {
        return telefono_2;
    }

    public void setTelefono_2(int telefono_2) {
        this.telefono_2 = telefono_2;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }
}
