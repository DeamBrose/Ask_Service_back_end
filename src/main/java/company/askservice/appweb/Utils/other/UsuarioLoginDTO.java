package company.askservice.appweb.Utils.other;

import company.askservice.appweb.model.Rol;

public class UsuarioLoginDTO {
    private String usuario;
    private String contrasena;

    public UsuarioLoginDTO() {
    }

    public UsuarioLoginDTO(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
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
