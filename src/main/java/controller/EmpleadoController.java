package controller;
import modelos.Empleado;
import service.EmpleadoService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Supermercado/empleados")
public class EmpleadoController {
    private EmpleadoService control;
    
    @Autowired
    public EmpleadoController (EmpleadoService control) {
    	control = control;
    }
    
    @PostMapping
    public void agregarEmpleado(Empleado empleado){
        control.agregarEmplado(empleado);
    }
    
    @GetMapping("/{codigo}")
    public  Empleado buscarEmpleado(String codigo){
        return control.buscarEmpleado(codigo);
    }
    
    @DeleteMapping("/{codigo}")
    public void eliminarEmpleado(String codigo){
        control.eliminarEmpleado(codigo);
    }
    
    @PutMapping("/{codigo}")
    public void modificarEmpleado(String codigo, Empleado empleado){
        control.modificarEmpleado(codigo, empleado);
    }
    
    @GetMapping
    public ArrayList <Empleado> listarEmpleados() {
        return control.listarEmpleados();
    }
}
