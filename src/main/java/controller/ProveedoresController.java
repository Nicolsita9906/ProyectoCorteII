package controller;
import modelos.Proveedores;
import service.ProveedoresService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Supermercado/proveedores")
public class ProveedoresController {
	private ProveedoresService control;

	@Autowired
	public ProveedoresController(ProveedoresService control) {
		this.control = control;
	}

	@PostMapping
	public void agregarProveedores (Proveedores proveedores) {
		control.agregarProveedor(proveedores);
	}

	@GetMapping("/{codigo}")
	public void buscarProveedres (String codigo) {
		control.buscarProveedres(codigo);		
	}
	
	@DeleteMapping("/{codigo}")
    public void eliminarProveedor (String codigo) {
        control.eliminarProveedor(codigo);
    }
	
	@PutMapping("/{codigo}")
    public void modificarProveedor (String codigo, Proveedores proveedores) {
        control.modificarProveedor(codigo, proveedores);
    }
	
	@GetMapping
	public ArrayList <Proveedores> listarProveedores() {
        return control.listarProveedores();
    }
}
