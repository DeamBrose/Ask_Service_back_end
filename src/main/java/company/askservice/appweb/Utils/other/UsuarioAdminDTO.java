package company.askservice.appweb.Utils.other;

import company.askservice.appweb.model.Administrador;
import company.askservice.appweb.model.Rol;

import java.io.Serializable;


public class UsuarioAdminDTO implements Serializable {

    private Long id;
    private String usuario;
    private String contrasena;
    private Administrador administrador;
    private Rol rol;

    public UsuarioAdminDTO() {
    }

    public UsuarioAdminDTO(Long id, String usuario, String contrasena, Administrador administrador, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.administrador = administrador;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
