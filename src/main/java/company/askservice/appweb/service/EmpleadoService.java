package company.askservice.appweb.service;

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


    @Transactional
    public Empleado saveEmpleado(Empleado empleado) {
        return repoEmpleado.save(empleado);
    }

    //FILTROS

    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleado() {
        return repoEmpleado.findAll();
    }

    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleadoActivo() {
        return repoEmpleado.findAllByEstadoEquals("true");
    }

    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleadoInactivo() {
        return repoEmpleado.findAllByEstadoEquals("false");
    }

    @Transactional(readOnly = true)
    public List<Empleado> findAllByNombreContainsOrApellidoContains(String nom,String ape) {
        return repoEmpleado.findAllByNombreContainsOrApellidoContains(nom, ape);
    }



}
