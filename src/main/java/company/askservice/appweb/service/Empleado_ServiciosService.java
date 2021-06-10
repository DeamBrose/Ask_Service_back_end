package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Empleado_Servicios;
import company.askservice.appweb.repository.Empleado_ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Empleado_ServiciosService {

    @Autowired
    private Empleado_ServiciosRepository repoEmpleadoService;

    public List<?> findAll(){
        List<Empleado_Servicios> list = repoEmpleadoService.findAll();
        if(list.isEmpty()) throw new NotFound("No existen registros.");
        return list;
    }
}