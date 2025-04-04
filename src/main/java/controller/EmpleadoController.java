package controller;
import modelos.Empleado;
import service.EmpleadoService;
public class EmpleadoController {
    private service.EmpleadoService control = new EmpleadoService();
    public void agregarEmpleado(Empleado empleado){
        control.agregarEmplado(empleado);
    }
    public  Empleado buscarEmpleado(String codigo){
        return control.buscarEmpleado(codigo);
    }
    public void eliminarEmpleado(String codigo){
        control.eliminarEmpleado(codigo);
    }
    public void modificarEmpleado(String codigo, Empleado empleado){
        control.modificarEmpleado(codigo, empleado);
    }
    public void listarEmpleados(){
        control.listarEmpleados();
    }
}
