package company.askservice.appweb.controller;

import company.askservice.appweb.Utils.other.ClienteDTO;
import company.askservice.appweb.model.Cliente;
import company.askservice.appweb.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService serviceCliente;

    @GetMapping("/listar")
    public ResponseEntity<?> ListarCliente(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceCliente.ListarCliente());
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> RegistrarCliente(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceCliente.RegistrarCliente(cliente));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateDatoCliente(@RequestBody ClienteDTO clienteDTO){
        return serviceCliente.UpdateCliente(clienteDTO);
    }

}
