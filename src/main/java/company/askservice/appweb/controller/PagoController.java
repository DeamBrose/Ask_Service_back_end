package company.askservice.appweb.controller;

import company.askservice.appweb.Utils.other.PagoDTO;
import company.askservice.appweb.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService servicePago;

    @PostMapping("/pedido")
    public ResponseEntity<?> RealizarPedido(@RequestBody PagoDTO pagoDTO){
        return servicePago.RealizarServicePedido(pagoDTO);
    }

    @GetMapping("/listarPago")
    public ResponseEntity<?> FindAll(){
        return ResponseEntity.status(HttpStatus.OK).body(servicePago.findAllPago());
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> FiltroPago(String UsernameEmple){
        return ResponseEntity.status(HttpStatus.OK).body(servicePago.FiltroPago(UsernameEmple));
    }
}
