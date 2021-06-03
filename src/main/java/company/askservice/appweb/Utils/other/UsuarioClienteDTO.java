package company.askservice.appweb.Utils.other;

import company.askservice.appweb.model.Cliente;
import company.askservice.appweb.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioClienteDTO implements Serializable {

    private Long id;
    private String usuario;
    private String contrasena;
    private Cliente cliente;
    private Rol rol;

}
