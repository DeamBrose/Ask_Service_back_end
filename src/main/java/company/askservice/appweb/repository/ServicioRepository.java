package company.askservice.appweb.repository;

import company.askservice.appweb.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    public List<Servicio> findByNombreLike(String servicio);
}
