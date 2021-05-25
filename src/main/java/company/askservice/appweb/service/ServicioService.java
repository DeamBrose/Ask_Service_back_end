package company.askservice.appweb.service;

import company.askservice.appweb.model.ServicioVo;

import java.util.List;
import java.util.Optional;

public interface ServicioService {

    //Listar todos los servicios existentes
    public List<ServicioVo> ListarServicios();

    //Buscar servicio por su id
    public Optional<ServicioVo> FindByIdServicio(Long id);

    //Borrar servicio por su id
    public void DeleteByIdServicio(Long id);

    //Guardar servicios
    public ServicioVo saveServicio(ServicioVo servicio);
}
