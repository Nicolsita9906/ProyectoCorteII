package com.example.Proyecto.service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Proyecto.modelos.Empleado;
import com.example.Proyecto.repository.EmpleadoRepository;
import java.time.LocalDateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@Service
public class EmpleadoService {
	private EmpleadoRepository servicio = new EmpleadoRepository ();
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public EmpleadoService(EmpleadoRepository servicio, PasswordEncoder passwordEncoder) {
		this.servicio = servicio;
		this.passwordEncoder = passwordEncoder;
	}


	public Empleado agregarEmplado (Empleado empleado) {
		empleado.setContraseña(passwordEncoder.encode(empleado.getContraseña()));
		return servicio.agregarEmpleado(empleado);
	}
	
	public Empleado buscarEmpleado (int codigo) {
		return servicio.buscarEmpleado(codigo);
	}
	
	public void eliminarEmpleado (int codigo) {
		servicio.eliminarEmpleado(codigo);
	}
	
	public void modificarEmpleado (int codigo, Empleado empleado) {
		servicio.modificarEmpleado(codigo, empleado);
	}
	
	  public List <Empleado> listarEmpleados() {
		return servicio.listarEmpleados();
	}
}
