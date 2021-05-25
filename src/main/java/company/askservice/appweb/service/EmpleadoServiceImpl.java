package company.askservice.appweb.service;

import company.askservice.appweb.model.EmpleadoVo;
import company.askservice.appweb.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository reempleservice;

    @Override
    @Transactional//Guardar empleado
    public EmpleadoVo saveEmpleado(EmpleadoVo empleado) {
        return reempleservice.save(empleado);
    }

    @Override//Listar empleado
    @Transactional(readOnly = true)
    public List<EmpleadoVo> ListarEmpleado() {
        return reempleservice.findAll();
    }
}
