package company.askservice.appweb.repository;

import company.askservice.appweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByContrasena(String contraseña);
    public Usuario findByUsuario(String username);
    public Usuario findByAdministrador_Id(Long IdAdmin);
}
