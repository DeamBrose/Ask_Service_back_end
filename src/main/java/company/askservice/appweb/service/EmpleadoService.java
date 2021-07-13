package company.askservice.appweb.service;

import company.askservice.appweb.Utils.other.EmpleadoDTO;
import company.askservice.appweb.Utils.other.UsuarioEmpleadoDTO;
import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repoEmpleado;

    private final UsuarioService usuarioService;

    public EmpleadoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void RegistrarEmpleado(Empleado empleado){
        if(empleado.getNombre().isEmpty()) throw new BadRequest("Ingrese el nombre");
        if(empleado.getNombre() == null) throw new BadRequest("Ingrese el nombre");
        empleado.setNombre(empleado.getNombre());

        if(empleado.getApellido().isEmpty()) throw new BadRequest("Ingrese su apellido");
        if(empleado.getApellido() == null) throw new BadRequest("Ingrese su apellido");
        empleado.setApellido(empleado.getApellido());

        if(empleado.getDni().isEmpty()) throw new BadRequest("Ingrese su dni");
        if(empleado.getDni() == null) throw new BadRequest("Ingrese su dni");
        empleado.setDni(empleado.getDni());

        empleado.setEstado("True");

        repoEmpleado.save(empleado);

        String apellido = empleado.getApellido();
        String nombre = empleado.getNombre();
        String dni = empleado.getDni();

        String username = ObtenerprimeraPalabra(apellido)+ObtenerprimeraPalabra(nombre)+ObtenerDosPrimerosNumerosDNI(dni);
        String password = ObtenerprimeraLetraPalabra(apellido)+ dni;

        UsuarioEmpleadoDTO usuarioEmpleadoDTO = new UsuarioEmpleadoDTO(username,password,empleado);

        usuarioService.RegistrarUsuarioEmpleado(usuarioEmpleadoDTO);
    }

    public Empleado findByEmpleadoId(Long id){
        if(!repoEmpleado.existsById(id)) throw new NotFound("No se encontró el servicio con el id " + id);
        return repoEmpleado.findById(id).orElse(null);
    }

    //FILTROS

    public List<Empleado> ListarEmpleado() {
        return repoEmpleado.findAll();
    }

    public List<Empleado> ListarEmpleadoActivo() {
        return repoEmpleado.findAllByEstadoEquals("true");
    }

    public List<Empleado> ListarEmpleadoInactivo() {
        return repoEmpleado.findAllByEstadoEquals("false");
    }

    public List<Empleado> findAllByNombreContainsOrApellidoContains(String nom,String ape) {
        return repoEmpleado.findAllByNombreContainsOrApellidoContains(nom, ape);
    }

    public ResponseEntity<?> UpdateDatosEmpleado(EmpleadoDTO empleadoDTO){
        Map<String, Object> respon = new HashMap<>();
        Empleado empleado = repoEmpleado.findEmpleadoById(empleadoDTO.getId());

        empleado.setEmail(empleadoDTO.getEmail());

        empleado.setDescripcion(empleadoDTO.getDescripcion());

        if(empleadoDTO.getTelefono().length() < 9) throw new BadRequest("Solo 9 dígitos");
        if(empleadoDTO.getTelefono().length() > 9) throw new BadRequest("Solo 9 dígitos");
        empleado.setTelefono(empleadoDTO.getTelefono());

        if(empleadoDTO.getImg().isEmpty()){
            repoEmpleado.save(empleado);
            respon.put("Message", "Guardado");
        }else {
            if(!empleadoDTO.getImg().isEmpty()){
                empleado.setImg(empleadoDTO.getImg());
                repoEmpleado.save(empleado);
                respon.put("Message", "Guardado");
            }
        }
        return new ResponseEntity<>(respon, HttpStatus.OK);
    }

    private String ObtenerprimeraPalabra(String palabra) {
        String arr[] = palabra.split(" ", 2);
        String firstWord = arr[0];
        return firstWord;
    }

    public String ObtenerprimeraLetraPalabra(String palabra){
        String word = String.valueOf(palabra.charAt(0));
        return word;
    }

    public String ObtenerDosPrimerosNumerosDNI(String dni){
        String numero1 = String.valueOf(dni.charAt(0));
        String numero2 = String.valueOf(dni.charAt(1));
        String valor = numero1+numero2;
        return valor;
    }
}
