package company.askservice.appweb.controller;

import company.askservice.appweb.Utils.other.UsuarioClienteDTO;
import company.askservice.appweb.Utils.other.UsuarioEmpleadoDTO;
import company.askservice.appweb.Utils.other.UsuarioLoginDTO;
import company.askservice.appweb.model.Usuario;
import company.askservice.appweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService serviceUsuario;

    @GetMapping("/listar")
    public List<Usuario> ListarUsuario(){
        return serviceUsuario.ListarUsuario();
    }

    @PostMapping("/registrar/userCliente")
    public  ResponseEntity<?> RegistrarUsuarioCliente(@RequestBody UsuarioClienteDTO clientedto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsuario.RegistrarUsuarioCliente(clientedto));
    }

    @PostMapping("/registrar/userEmpleado")
    public  ResponseEntity<?> RegistrarUsuarioEmpleado(@RequestBody UsuarioEmpleadoDTO empleadodto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsuario.RegistrarUsuarioEmpleado(empleadodto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> UsuarioLogin(@RequestBody UsuarioLoginDTO userlogin){
        return serviceUsuario.Login(userlogin);
    }
}
