package company.askservice.appweb.service;

import company.askservice.appweb.model.EmpleadoVo;

import java.util.List;

public interface EmpleadoService {

    //Resgitrar empleado
    public EmpleadoVo saveEmpleado(EmpleadoVo empleado);

    //Listar empleado
    public List<EmpleadoVo> ListarEmpleado();
}
