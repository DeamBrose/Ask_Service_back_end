package company.askservice.appweb.repository;

import company.askservice.appweb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Cliente findByTelefono(String telefono);
    public Cliente findClienteById(Long id);
}
