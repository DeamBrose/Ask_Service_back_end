package company.askservice.appweb.repository;

import company.askservice.appweb.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    public List<Servicio> findByNombreLike(String servicio);
    public Servicio findServicioById(Long id);
}
