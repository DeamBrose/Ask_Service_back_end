package company.askservice.appweb.model;

import javax.persistence.*;

@Entity
@Table(name = "usuariosvo")
public class UsuarioVo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @OneToOne
    @JoinColumn(name = "id_administrador",referencedColumnName = "id_administrador")
    private AdministradorVo administradorvo;

    @OneToOne
    @JoinColumn(name = "id_empleado",referencedColumnName = "id_empleado")
    private EmpleadoVo empleadovo;

    @OneToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    private ClienteVo clientevo;

    @OneToOne
    @JoinColumn(name = "id_rol",referencedColumnName = "id_rol")
    private RolVo rolvo;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false, unique = true)
    private String contrasena;

    public UsuarioVo() {
    }

    public UsuarioVo(Long id_usuario, AdministradorVo administradorvo, EmpleadoVo empleadovo, ClienteVo clientevo, RolVo rolvo, String usuario, String contrasena) {
        this.id_usuario = id_usuario;
        this.administradorvo = administradorvo;
        this.empleadovo = empleadovo;
        this.clientevo = clientevo;
        this.rolvo = rolvo;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public AdministradorVo getAdministradorvo() {
        return administradorvo;
    }

    public void setAdministradorvo(AdministradorVo administradorvo) {
        this.administradorvo = administradorvo;
    }

    public EmpleadoVo getEmpleadovo() {
        return empleadovo;
    }

    public void setEmpleadovo(EmpleadoVo empleadovo) {
        this.empleadovo = empleadovo;
    }

    public ClienteVo getClientevo() {
        return clientevo;
    }

    public void setClientevo(ClienteVo clientevo) {
        this.clientevo = clientevo;
    }

    public RolVo getRolvo() {
        return rolvo;
    }

    public void setRolvo(RolVo rolvo) {
        this.rolvo = rolvo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
