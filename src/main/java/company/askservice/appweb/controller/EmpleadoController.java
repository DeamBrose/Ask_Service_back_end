package company.askservice.appweb.controller;

import company.askservice.appweb.model.EmpleadoVo;
import company.askservice.appweb.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class EmpleadoController {

    @Autowired
    private EmpleadoService serviceempleado;


    @PostMapping("/RegistrarEmple")
    public ResponseEntity<?> create(@RequestBody EmpleadoVo empleado){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceempleado.saveEmpleado(empleado));
    }

    @GetMapping("/listaremple")
    public List<EmpleadoVo> listaempleado(){
        return serviceempleado.ListarEmpleado();
    }
}
