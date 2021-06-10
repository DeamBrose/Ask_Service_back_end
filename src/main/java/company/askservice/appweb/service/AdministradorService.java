package company.askservice.appweb.service;

import company.askservice.appweb.Utils.MHelpers;
import company.askservice.appweb.Utils.other.UsuarioClienteDTO;
import company.askservice.appweb.config.Error.exceptions.BadRequest;
import company.askservice.appweb.model.Usuario;
import company.askservice.appweb.repository.AdministradorRepository;
import company.askservice.appweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministradorService {
    @Autowired
    private AdministradorRepository repoAdmin;
}
