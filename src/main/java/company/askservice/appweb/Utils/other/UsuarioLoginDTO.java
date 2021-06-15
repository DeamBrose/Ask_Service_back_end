package company.askservice.appweb.Utils.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLoginDTO implements Serializable {
    private String usuario;
    private String contrasena;
}
