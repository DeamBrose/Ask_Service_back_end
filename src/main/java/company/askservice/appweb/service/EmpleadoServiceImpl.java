package company.askservice.appweb.service;

import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl {


    @Autowired
    private EmpleadoRepository repoEmpleado;


    @Transactional
    public Empleado saveEmpleado(Empleado empleado) {
        return repoEmpleado.save(empleado);
    }


    @Transactional(readOnly = true)
    public List<Empleado> ListarEmpleado() {
        return repoEmpleado.findAll();
    }
}
