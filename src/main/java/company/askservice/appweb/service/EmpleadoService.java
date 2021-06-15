package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repoEmpleado;

    public Empleado RegistrarEmpleado(Empleado empleado){
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
        return repoEmpleado.save(empleado);
    }

    public Empleado findByEmpleadoId(Long id){
        if(!repoEmpleado.existsById(id)) throw new NotFound("No se encontró el servicio con el id " + id);
        return repoEmpleado.findById(id).orElse(null);
    }

    //FILTROS
    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleado() {
        return repoEmpleado.findAll();
    }

    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleadoActivo() { return repoEmpleado.findAllByEstadoEquals("true"); }

    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleadoInactivo() {
        return repoEmpleado.findAllByEstadoEquals("false");
    }

    @Transactional(readOnly = true)
    public List<Empleado> findAllByNombreContainsOrApellidoContains(String nom,String ape) { return repoEmpleado.findAllByNombreContainsOrApellidoContains(nom, ape); }
}
