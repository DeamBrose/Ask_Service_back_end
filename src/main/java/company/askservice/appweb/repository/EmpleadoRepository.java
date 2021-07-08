package company.askservice.appweb.repository;

import company.askservice.appweb.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    public List<Empleado> findAll();
    public List<Empleado> findAllByEstadoEquals(String estado);
    public List<Empleado> findAllByNombreContainsOrApellidoContains(String nom,String Ape);
    public Empleado findEmpleadoById(Long id);
}
