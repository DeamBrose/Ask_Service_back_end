package company.askservice.appweb.repository;

import company.askservice.appweb.model.Empleado_Servicios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Empleado_ServiciosRepository extends JpaRepository<Empleado_Servicios, Long> {
    public List<Empleado_Servicios> findAllByServicioNombreContains(String nombre);
}
