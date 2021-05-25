package company.askservice.appweb.service;

import company.askservice.appweb.model.UsuarioVo;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public List<UsuarioVo> ListarUsuario();

    public UsuarioVo RegistrarUsuario(UsuarioVo usuario);

}
