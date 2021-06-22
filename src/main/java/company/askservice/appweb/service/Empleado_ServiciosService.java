package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Empleado_Servicios;
import company.askservice.appweb.repository.Empleado_ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Empleado_ServiciosService {

    @Autowired
    private Empleado_ServiciosRepository repoEmpleadoService;

    public List<?> findAll(){
        List<Empleado_Servicios> list = repoEmpleadoService.findAll();
        if(list.isEmpty()) throw new NotFound("No existen registros.");
        return list;
    }

    public List<?> FiltroServicios(String nombre){
        List<Empleado_Servicios> lista = repoEmpleadoService.findAllByServicioNombreContains(nombre);
        if(lista.isEmpty()) throw new NotFound("No se encontraron coincidencias.");
        return lista;
    }

    public Empleado_Servicios obtenerEmpleado_Servicios(Long id){return repoEmpleadoService.findById(id).orElse(null);}
}
