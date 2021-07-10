package company.askservice.appweb.service;

import company.askservice.appweb.Utils.other.PagoDTO;
import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.*;
import company.askservice.appweb.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repoPedido;

    @Autowired
    private ClienteRepository repoCliente;

    @Autowired
    private ServicioRepository repoServicio;

    @Autowired
    private Empleado_ServiciosRepository repoEmpleadoService;

    @Autowired
    private UsuarioRepository repoUsuario;

    public ResponseEntity<?> RealizarServicePedido(PagoDTO pagoDTO){
        Cliente cliente = repoCliente.findClienteById(pagoDTO.getCliente());
        Servicio servicio = repoServicio.findServicioById(pagoDTO.getServicio());
        Empleado_Servicios empleado_servicios = repoEmpleadoService.findEmpleado_ServiciosByServicioId(pagoDTO.getServicio());
        Usuario usuario = repoUsuario.findUsuarioByEmpleadoId(empleado_servicios.getEmpleado().getId());
        Map<String, Object> respon = new HashMap<>();

        Pedido pago = new Pedido();
        pago.setServicio(servicio);
        pago.setClientes(cliente);
        pago.setEstado("Pendiente");
        pago.setEmpleado(usuario.getUsuario());
        pago.setDescripcion(pagoDTO.getDescripcion());
        repoPedido.save(pago);

        respon.put("Message", "Realizado correctamente");
        return new ResponseEntity<>(respon ,HttpStatus.OK);
    }

    public List<Pedido> findAllPedido(){
        return repoPedido.findAll();
    }

    public List<?> FiltroPedido(String empleado){
        List<Pedido> list = repoPedido.findAllByEmpleado(empleado);
        if(list.isEmpty()) throw new NotFound("Aún no tiene servicios pendientes.");
        return list;
    }

    public Pedido BuscarPedidoForId(Long id){
        Pedido pedido = repoPedido.findPedidoById(id);
        if(pedido == null) throw new NotFound("No existe el pedido");
        return pedido;
    }

    public ResponseEntity<?> ChangeStatusPedido(Long idPedido){
        Map<String, Object> respon = new HashMap<>();
        Pedido pedido = repoPedido.findPedidoById(idPedido);
        pedido.setEstado("Realizado");
        repoPedido.save(pedido);
        respon.put("Message", "Exitoso");
        return new ResponseEntity<>(respon, HttpStatus.OK);
    }

    public List<Pedido> findPedidoForIdCliente(Long idCliente){
        List<Pedido> pedidos = repoPedido.findAllByClientesId(idCliente);
        return pedidos;
    }
}
