package company.askservice.appweb.service;

import company.askservice.appweb.Utils.other.ClienteDTO;
import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.model.Cliente;
import company.askservice.appweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        if(cliente.getDireccion().isEmpty()) throw new BadRequest("Ingrese su dirección");
        if(cliente.getDireccion() == null) throw new BadRequest("Ingrese su dirección");
        cliente.setDireccion(cliente.getDireccion());

        if(cliente.getEmail().isEmpty()) throw new BadRequest("Ingrese su email");
        if(cliente.getEmail() == null) throw new BadRequest("Ingrese su email");
        cliente.setEmail(cliente.getDireccion());

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

    public ResponseEntity<?> UpdateCliente(ClienteDTO clienteDTO){
        Map<String, Object> respon = new HashMap<>();
        Cliente cliente = repoCliente.findClienteById(clienteDTO.getId());

        cliente.setEmail(clienteDTO.getEmail());

        if(clienteDTO.getTelefono().length() < 9)throw new BadRequest("9 dígitos.");
        if(clienteDTO.getTelefono().length() > 9)throw new BadRequest("9 dígitos.");
        cliente.setTelefono(clienteDTO.getTelefono());

        cliente.setDireccion(clienteDTO.getDireccion());

        if(clienteDTO.getImg().isEmpty()){
            repoCliente.save(cliente);
            respon.put("Message", "Guardado");
        }else {
            if(!clienteDTO.getImg().isEmpty()){
                cliente.setImg(clienteDTO.getImg());
                repoCliente.save(cliente);
                respon.put("Message", "Guardado");
            }
        }
        return new ResponseEntity<>(respon, HttpStatus.OK);
    }

    public Cliente findClienteById(Long id){
        Cliente cliente = repoCliente.findClienteById(id);
        return cliente;
    }
}
