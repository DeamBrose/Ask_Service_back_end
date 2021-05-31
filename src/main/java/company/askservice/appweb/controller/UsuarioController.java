package company.askservice.appweb.controller;

import company.askservice.appweb.Utils.other.UsuarioAdminDTO;
import company.askservice.appweb.model.Usuario;
import company.askservice.appweb.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl serviceUsuario;

    @GetMapping("/listar")
    public List<Usuario> ListarUsuario(){
        return serviceUsuario.ListarUsuario();
    }

    @PostMapping("/registrar/admin")
    public  ResponseEntity<?> RegistrarUsuarioAdmin(@RequestBody UsuarioAdminDTO usuario) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceUsuario.RegistrarUsuarioAdmin(usuario));
    }
}
