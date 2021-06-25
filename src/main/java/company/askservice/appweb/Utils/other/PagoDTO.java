package company.askservice.appweb.Utils.other;

import lombok.Data;
import java.util.Date;

@Data
public class PagoDTO {
    private Long cliente;
    private Long Servicio;
    private String descripcion;
}
