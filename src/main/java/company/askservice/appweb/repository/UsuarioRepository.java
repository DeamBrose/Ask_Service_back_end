package company.askservice.appweb.repository;

import company.askservice.appweb.model.UsuarioVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioVo, Long> {
}
