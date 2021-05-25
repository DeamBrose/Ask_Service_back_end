package company.askservice.appweb.repository;

import company.askservice.appweb.model.EmpleadoVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<EmpleadoVo, Long> {

}
