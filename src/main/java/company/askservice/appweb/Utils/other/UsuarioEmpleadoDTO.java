package company.askservice.appweb.Utils.other;

import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEmpleadoDTO implements Serializable {
    private String usuario;
    private String contrasena;
    private Empleado empleado;
}
