package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.model.Cliente;
import company.askservice.appweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repoCliente;

    public Cliente RegistrarCliente(Cliente cliente){
        if(cliente.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
        if(cliente.getNombre() == null) throw new BadRequest("Ingrese el nombre");
        cliente.setNombre(cliente.getNombre());

        if(cliente.getApellido().isEmpty()) throw new BadRequest("Ingrese su apellido");
        if(cliente.getApellido() == null) throw new BadRequest("Ingrese su apellido");
        cliente.setApellido(cliente.getApellido());

        if(cliente.getDirección().isEmpty()) throw new BadRequest("Ingrese su dirección");
        if(cliente.getDirección() == null) throw new BadRequest("Ingrese su dirección");
        cliente.setDirección(cliente.getDirección());

        if(cliente.getEmail().isEmpty()) throw new BadRequest("Ingrese su email");
        if(cliente.getEmail() == null) throw new BadRequest("Ingrese su email");
        cliente.setEmail(cliente.getDirección());

        if(cliente.getTelefono().isEmpty()) throw new BadRequest("Ingrese su Nº telefónico");
        if(cliente.getTelefono() == null) throw new BadRequest("Ingrese su Nº telefónico");
        else {
            if(cliente.getTelefono().length() > 9) throw new BadRequest("Ingrese correctamente el Nº (9 digitos)");
            if(cliente.getTelefono().length() < 9) throw new BadRequest("Ingrese correctamente el Nº (9 digitos)");
            Cliente telefono  = repoCliente.findByTelefono(cliente.getTelefono());
            if(telefono != null) throw new BadRequest("El Nº ya está registrado con otro usuario, ingrese otro Nº.");
            cliente.setTelefono(cliente.getTelefono());
        }

        return repoCliente.save(cliente);
    }

    public List<?> ListarCliente(){
        List<Cliente> list = repoCliente.findAll();
        if(list.isEmpty()) throw new BadRequest("No se encontró registros en la lista");
        return list;
    }
}
