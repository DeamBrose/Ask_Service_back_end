package company.askservice.appweb.Utils.other;

import company.askservice.appweb.model.Administrador;
import company.askservice.appweb.model.Cliente;
import company.askservice.appweb.model.Empleado;
import company.askservice.appweb.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDTO implements Serializable {
    private Long id;
    private Administrador administrador;
    private Empleado empleado;
    private Cliente cliente;
    private Rol rol;
    private String usuario;
}
