package company.askservice.appweb.controller;

import company.askservice.appweb.service.Empleado_ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleadoServicios")
public class EmpleadoServiciosController {

    @Autowired
    private Empleado_ServiciosService serviceEmpleadoService;

    @GetMapping("/lista")
    public ResponseEntity<?> FindAll(){
        return ResponseEntity.status(HttpStatus.OK).body(serviceEmpleadoService.findAll());
    }
}