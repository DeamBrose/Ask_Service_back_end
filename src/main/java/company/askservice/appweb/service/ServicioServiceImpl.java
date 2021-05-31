package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Servicio;
import company.askservice.appweb.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl{

    @Autowired
    private ServicioRepository repoService;



    public Servicio FindByIdServicio(Long id) {
        if(!repoService.existsById(id)) throw new NotFound("No se encontró el servicio con el id " + id);
        return repoService.findById(id).orElse(null);
    }


    public Servicio saveServicio(Servicio servicio) {
        return repoService.save(servicio);
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
}
