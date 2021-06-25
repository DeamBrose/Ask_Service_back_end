package company.askservice.appweb.repository;

import company.askservice.appweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByContrasena(String contraseña);
    public Usuario findByUsuario(String username);

    public Usuario findByCliente_Id(Long IdCliente);
    public Usuario findByEmpleado_Id(Long IdEmpleado);
    public Usuario findUsuarioByEmpleadoId(Long id);

    Boolean existsUsuarioByUsuarioAndContrasena(String username, String password);
    Boolean existsUsuarioByUsuario(String username);
    Boolean existsUsuarioByContrasena(String password);
}
