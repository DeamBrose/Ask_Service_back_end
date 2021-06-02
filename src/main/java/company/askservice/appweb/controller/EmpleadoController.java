package company.askservice.appweb.controller;

import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.service.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoServiceImpl serviceEmpleado;


    @PostMapping("/registrarEmpleado")
    public ResponseEntity<?> create(@RequestBody Empleado empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceEmpleado.saveEmpleado(empleado));
    }

    //FILTROS
    @GetMapping("/listar")
    public List<Empleado> listaempleado(){
        return serviceEmpleado.ListarEmpleado();
    }

    @GetMapping("/listarempleactivo")
    public List<Empleado> listaempleadoActivo(){ return serviceEmpleado.ListarEmpleadoActivo(); }

    @GetMapping("/listarempleinactivo")
    public List<Empleado> listaempleadoInactivo(){ return serviceEmpleado.ListarEmpleadoInactivo(); }

    @GetMapping(path = "/listaremplepornomape/{nomape}")
    public List<Empleado> findAllByNombreOrApellidoContains(@PathVariable("nomape") String nomape){
        return serviceEmpleado.findAllByNombreContainsOrApellidoContains(nomape,nomape);
    }

}
