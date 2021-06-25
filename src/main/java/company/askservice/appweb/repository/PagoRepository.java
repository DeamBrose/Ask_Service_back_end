package company.askservice.appweb.repository;

import company.askservice.appweb.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAllByEmpleado(String empleado);
}
