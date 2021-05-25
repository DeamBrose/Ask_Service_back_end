package company.askservice.appweb.service;

import company.askservice.appweb.model.UsuarioVo;
import company.askservice.appweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuario_repository;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioVo> ListarUsuario() {
        return usuario_repository.findAll();
    }

    @Override
    @Transactional
    public UsuarioVo RegistrarUsuario(UsuarioVo usuario) {
        return usuario_repository.save(usuario);
    }
}
