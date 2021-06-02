package company.askservice.appweb.service;

import company.askservice.appweb.Utils.MHelpers;
import company.askservice.appweb.Utils.other.UsuarioAdminDTO;
import company.askservice.appweb.Utils.other.UsuarioLoginDTO;
import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.model.Usuario;
import company.askservice.appweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioServiceImpl {

    @Autowired
    private UsuarioRepository repoUsuario;


    public List<Usuario> ListarUsuario() {
        return repoUsuario.findAll();
    }

    public Usuario RegistrarUsuarioAdmin(UsuarioAdminDTO usuario) {
        if(usuario.getUsuario() == null) throw new BadRequest("Ingrese un nombre.");
        if(usuario.getUsuario().isEmpty()) throw new BadRequest("Ingrese un nombre.");
        Usuario username = repoUsuario.findByUsuario(usuario.getUsuario());
        if(username!=null) throw new BadRequest("El nombre del administrador ya existe.");
        usuario.setUsuario(usuario.getUsuario());

        if(usuario.getContrasena() == null) throw new BadRequest("Ingrese una contraseña.");
        if(usuario.getContrasena().isEmpty()) throw new BadRequest("Ingrese una contraseña.");
        Usuario password = repoUsuario.findByContrasena(usuario.getContrasena());
        if(password!=null) throw new BadRequest("Contraseña inválida.");
        usuario.setContrasena(usuario.getContrasena());

        if(usuario.getAdministrador().getId() == null) throw new BadRequest("Seleccione el valor.");
        Usuario admin = repoUsuario.findByAdministrador_Id(usuario.getAdministrador().getId());
        if(admin!=null) throw new BadRequest("El administrador seleccionado ya tiene una cuenta.");
        usuario.setAdministrador(usuario.getAdministrador());

        if(usuario.getRol().getId() != 2) throw new BadRequest("El rol no es válido.");
        usuario.setRol(usuario.getRol());

        Usuario user = MHelpers.modelMapper().map(usuario, Usuario.class);
        return repoUsuario.save(user);
    }

    public ResponseEntity<?> Login(UsuarioLoginDTO logindto){
        String username = logindto.getUsuario();
        String password = logindto.getContrasena();
        Map<String, Object> resp = new HashMap<>();

        if(username.isEmpty()) throw new BadRequest("Ingrese el nombre del usuario.");
        if(password.isEmpty()) throw new BadRequest("Ingrese la contraseña.");

        if(repoUsuario.existsUsuarioByUsuarioAndContrasena(username, password)){
            Usuario userlog = repoUsuario.findByUsuario(username);
            resp.put("Válido", true);
            resp.put("Message", "Credenciales válidas");
            resp.put("Usuario", userlog);

            return new ResponseEntity<>(resp, HttpStatus.OK);
        }else {
            resp.put("Válido", false);
            resp.put("Message", "Credenciales no válidas");

            return new ResponseEntity<>(resp, HttpStatus.UNAUTHORIZED);
        }
    }
}
