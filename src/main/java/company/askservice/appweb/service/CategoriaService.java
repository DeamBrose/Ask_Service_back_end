package company.askservice.appweb.service;

import company.askservice.appweb.config.Error.exceptions.NotFound;
import company.askservice.appweb.model.Categoria;
import company.askservice.appweb.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public Categoria findbyId(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<?> findAll(){
        List<Categoria> list = repository.findAll();
        if(list.isEmpty())throw new NotFound("No se encontró registros en la lista");
        return list;
    }
}
