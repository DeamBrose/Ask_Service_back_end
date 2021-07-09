package company.askservice.appweb.controller;

import company.askservice.appweb.model.Empleado_Servicios;
import company.askservice.appweb.service.Empleado_ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleadoServicios")
public class EmpleadoServiciosController {

    @Autowired
    private Empleado_ServiciosService serviceEmpleadoService;

    @GetMapping("/lista")
    public ResponseEntity<?> FindAll(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleadoService.findAll());
    }

    @GetMapping(path="/lista/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleadoService.obtenerEmpleado_Servicios(id));
    }

    @GetMapping("/filtroservicio")
    public ResponseEntity<?> FiltroServicio(String nombre){
        return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleadoService.FiltroServicios(nombre));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createEmpleadoServicio(@RequestBody Empleado_Servicios empleado_servicios){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceEmpleadoService.CreateEmpleadoServicio(empleado_servicios));
    }
}
