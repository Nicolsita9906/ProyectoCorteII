package service;
import java.time.LocalDate;
import java.util.ArrayList;

import modelos.Empleado;
import modelos.TipoDeDocumento;
import repository.EmpleadoRepository;
public class EmpleadoService {
	private EmpleadoRepository servicio = new EmpleadoRepository ();
	
	public EmpleadoService(EmpleadoRepository servicio) {
		this.servicio = servicio;
		datosMuertos();
	}
	
	public void datosMuertos () {
		agregarEmplado(new Empleado("Ana Pérez", TipoDeDocumento.CC, "1001234567", LocalDate.of(2020, 1, 10)));
		agregarEmplado(new Empleado("Luis Gómez", TipoDeDocumento.TI, "1002345678", LocalDate.of(2021, 3, 15)));
		agregarEmplado(new Empleado("Carla Rodríguez", TipoDeDocumento.CE, "1003456789", LocalDate.of(2019, 6, 20)));
		agregarEmplado(new Empleado("Miguel Torres", TipoDeDocumento.CC, "1004567890", LocalDate.of(2022, 9, 5)));
		agregarEmplado(new Empleado("Diana Ramírez", TipoDeDocumento.CE, "AB1234567", LocalDate.of(2018, 12, 25)));
	}

	public void agregarEmplado (Empleado empleado) {
		servicio.agregarEmpleado(empleado);
	}
	
	public Empleado buscarEmpleado (String codigo) {
		return servicio.buscarEmpleado(codigo);
	}
	
	public void eliminarEmpleado (String codigo) {
		servicio.eliminarEmpleado(codigo);
	}
	
	public void modificarEmpleado (String codigo, Empleado empleado) {
		servicio.modificarEmpleado(codigo, empleado);
	}
	
	  public ArrayList <Empleado> listarEmpleados() {
		return servicio.listarEmpleados();
	}
}
