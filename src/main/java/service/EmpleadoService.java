package service;
import repository.EmpleadoRepository;
import modelos.Empleado;
public class EmpleadoService {

	private EmpleadoRepository servicio = new EmpleadoRepository ();
	
	public void agregarEmplado (Empleado empleado) {
		servicio.agregarEmpleado(empleado);
	}
	
	public Empleado buscarEmplado (String codigo) {
		return servicio.buscarEmpleado(codigo);
	}
	
	public void eliminarEmpleado (String codigo) {
		servicio.eliminarEmpleado(codigo);
	}
	
	public void modificarEmpleado (String codigo, Empleado empleado) {
		servicio.modificarEmpleado(codigo, empleado);
	}
	
	public void listarEmpleados () {
		servicio.listarEmpleados();
	}
}
