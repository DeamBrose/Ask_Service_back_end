package company.askservice.appweb.controller;

import company.askservice.appweb.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company/servicio")
public class ServicioController {

    @Autowired
    private ServicioService reposervicio;
/*
    //Registrar Servicios
    @PostMapping("/RegistrarServi")
    public ResponseEntity<?> create(@RequestBody ServicioVo servicio){
        return ResponseEntity.status(HttpStatus.CREATED).body(reposervicio.saveServicio(servicio));
    }

    //Listar Servicios
    @GetMapping("/Listar")
    public ResponseEntity<?> ListarServicio(){
            List<ServicioVo> list = reposervicio.ListarServicios();

            return new ResponseEntity<>(list, HttpStatus.OK);
    }

 */
}
