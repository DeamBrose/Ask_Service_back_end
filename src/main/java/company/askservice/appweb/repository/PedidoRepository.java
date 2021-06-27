package company.askservice.appweb.repository;

import company.askservice.appweb.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    public List<Pedido> findAllByEmpleado(String empleado);
    public Pedido findPedidoById(Long id);
}
