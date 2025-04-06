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
    	this.control = control;
    }
    
    @PostMapping
    public void agregarEmpleado(@RequestBody Empleado empleado){
        control.agregarEmplado(empleado);
    }
    
    @GetMapping("/{codigo}")
    public  Empleado buscarEmpleado(@PathVariable String codigo){
        return control.buscarEmpleado(codigo);
    }
    
    @DeleteMapping("/{codigo}")
    public void eliminarEmpleado(@PathVariable String codigo){
        control.eliminarEmpleado(codigo);
    }
    
    @PutMapping("/{codigo}")
    public void modificarEmpleado(@PathVariable String codigo, @RequestBody Empleado empleado){
        control.modificarEmpleado(codigo, empleado);
    }
    
    @GetMapping
    public ArrayList <Empleado> listarEmpleados() {
        return control.listarEmpleados();
    }
}