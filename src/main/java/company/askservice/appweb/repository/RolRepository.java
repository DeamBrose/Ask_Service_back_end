package company.askservice.appweb.repository;

import company.askservice.appweb.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    public Rol findByTipoRol(String TipoRol);
}
