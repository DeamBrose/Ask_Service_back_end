package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Categoria;
import company.askservice.appweb.model.Empleado_Servicios;
import company.askservice.appweb.model.Servicio;
import company.askservice.appweb.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository repoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private  Empleado_ServiciosService empleado_serviciosService;

    public Servicio FindByIdServicio(Long id) {
        if(!repoService.existsById(id)) throw new NotFound("No se encontró el servicio con el id " + id);
        return repoService.findById(id).orElse(null);
    }

    public Servicio saveServicio(Servicio servicio) {
        return repoService.save(servicio);
    }

    public ResponseEntity<?> updateServicio(Servicio servicio){
        Map<String, Object> respon = new HashMap<>();
        Servicio servicioExist = repoService.findById(servicio.getId()).orElse(null);
        Categoria categoriaExist = categoriaService.findbyId(servicio.getCategoria().getId());
        if(servicioExist != null){
            servicio.setNombre(servicio.getNombre());
            servicio.setDescripcion(servicio.getDescripcion());
            servicio.setPrecio(servicio.getPrecio());

            if(categoriaExist != null){
                servicio.setCategoria(servicio.getCategoria());
            }else {
                respon.put("Message", "La categoria con el Id "+ servicio.getId().toString() + " no existe");
                return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
            }
            repoService.save(servicio);
            respon.put("Message", "Guardado");
            return new ResponseEntity<>(respon, HttpStatus.OK);
        }else {
            respon.put("Message", "El servicio con el Id "+ servicio.getCategoria().getId().toString() + " no existe");
            return new ResponseEntity<>(respon, HttpStatus.OK);
        }
    }

    public List<?> filtroServicio(String servicio){
       List<Servicio> lista = repoService.findByNombreLike(servicio);
        if(lista.isEmpty()) throw new NotFound("No se encontró coincidencias con los servicios");
        return lista;
    }

    public List<?> findAll(){
        List<Servicio> all = repoService.findAll();
        if(all.isEmpty())throw new NotFound("No se encontró registros en la lista");
        return all;
    }

    public ResponseEntity<?> deleteServicio(Long id){
        Map<String, Object> respon = new HashMap<>();

        if(repoService.findById(id) != null){
            repoService.deleteById(id);

            respon.put("Message", "El servicio de se eliminó exitosamente OWO");
            return new ResponseEntity<>(respon, HttpStatus.OK);
        }else{
            respon.put("Message", "El servicio que quiere eliminar no existe  (︶︹︺)");
            return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<?> deleteServicio2(Long id, Long idempleado){
        Map<String, Object> respon = new HashMap<>();

        if(repoService.findById(id) != null){
             empleado_serviciosService.deleteEmpleadoServicioByEmpleadoAndServicio(idempleado,id);
             repoService.deleteById(id);
            respon.put("Message", "El servicio de se eliminó exitosamente OWO");
            return new ResponseEntity<>(respon, HttpStatus.OK);
        }else{
            respon.put("Message", "El servicio que quiere eliminar no existe  (︶︹︺)");
            return new ResponseEntity<>(respon, HttpStatus.BAD_REQUEST);
        }
    }

    public List<Servicio> findServicioByCategoriaId(Long idCategoria){
        List<Servicio> servicios = repoService.findAllByCategoriaId(idCategoria);
        return servicios;
    }
}
