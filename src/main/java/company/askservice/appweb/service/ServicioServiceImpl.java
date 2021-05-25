package company.askservice.appweb.service;

import company.askservice.appweb.model.ServicioVo;
import company.askservice.appweb.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    @Autowired
    private ServicioRepository serviciorepo;

    @Override
    @Transactional(readOnly = true)
    public List<ServicioVo> ListarServicios() {
        return serviciorepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ServicioVo> FindByIdServicio(Long id) {
        return serviciorepo.findById(id);
    }

    @Override
    @Transactional
    public void DeleteByIdServicio(Long id) {
        serviciorepo.deleteById(id);
    }

    @Override
    @Transactional
    public ServicioVo saveServicio(ServicioVo servicio) {
        return serviciorepo.save(servicio);
    }
}
