package company.askservice.appweb.controller;

import company.askservice.appweb.Utils.other.PagoDTO;
import company.askservice.appweb.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService servicePedido;

    @PostMapping("/realizar")
    public ResponseEntity<?> RealizarPedido(@RequestBody PagoDTO pagoDTO){
        return servicePedido.RealizarServicePedido(pagoDTO);
    }

    @GetMapping("/listarPago")
    public ResponseEntity<?> FindAll(){
        return ResponseEntity.status(HttpStatus.OK).body(servicePedido.findAllPedido());
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> FiltroPedido(String UsernameEmple){
        return ResponseEntity.status(HttpStatus.OK).body(servicePedido.FiltroPedido(UsernameEmple));
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> BuscarForId(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(servicePedido.BuscarPedidoForId(id));
    }

    @PostMapping("/statusPedido")
    public ResponseEntity<?> ChangeStatusPedido(Long idPedido){
        return servicePedido.ChangeStatusPedido(idPedido);
    }
    @GetMapping("/buscarPedidoBy/{idCliente}")
    public ResponseEntity<?> SearchPedidoByClienteId(@PathVariable Long idCliente){
        return ResponseEntity.status(HttpStatus.OK).body(servicePedido.findPedidoForIdCliente(idCliente));
    }
}
