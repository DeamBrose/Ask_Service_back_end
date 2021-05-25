package company.askservice.appweb.repository;

import company.askservice.appweb.model.ServicioVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<ServicioVo, Long> {

}
