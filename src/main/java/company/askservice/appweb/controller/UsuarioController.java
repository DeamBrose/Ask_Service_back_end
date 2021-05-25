package company.askservice.appweb.controller;

import company.askservice.appweb.model.UsuarioVo;
import company.askservice.appweb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity<?> ListarUsuario(){
        List<UsuarioVo> list = usuarioService.ListarUsuario();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public  ResponseEntity<?> RegistrarUsuario(@RequestBody UsuarioVo usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.RegistrarUsuario(usuario));
    }
}
