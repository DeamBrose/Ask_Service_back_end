package company.askservice.appweb.controller;

import company.askservice.appweb.model.Servicio;
import company.askservice.appweb.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService serviceService;


    @PostMapping("/registrarServicio")
    public ResponseEntity<?> RegistrarService(@RequestBody Servicio servicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceService.saveServicio(servicio));
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> filtroServicio(String servicio){
        if(servicio==null) {
            return ResponseEntity.status(HttpStatus.OK).body(serviceService.findAll());
        }
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.filtroServicio("%"+servicio+"%"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findbyId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(serviceService.FindByIdServicio(id));
    }

}
