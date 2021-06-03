package company.askservice.appweb.controller;

import company.askservice.appweb.model.Servicio;
import company.askservice.appweb.repository.ServicioRepository;
import company.askservice.appweb.service.ServicioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioServiceImpl serviceService;


    @PostMapping("/registrarServicio")
    public ResponseEntity<?> RegistrarService(@RequestBody Servicio servicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceService.saveServicio(servicio));
    }

    @GetMapping(path = "/filtro/{nombre}")
    public ResponseEntity<?> filtroServicio(@PathVariable("nombre") String servicio){
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
