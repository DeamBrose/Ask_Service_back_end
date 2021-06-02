package company.askservice.appweb.repository;

import company.askservice.appweb.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    public List<Empleado> findAllByEstadoEquals(String estado);

    public List<Empleado> findAllByNombreContainsOrApellidoContains(String nom,String Ape);
}
