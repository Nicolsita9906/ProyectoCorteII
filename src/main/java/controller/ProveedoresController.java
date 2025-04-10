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
	public Proveedores agregarProveedores (@RequestBody Proveedores proveedores) {
		return control.agregarProveedor(proveedores);
	}

	@GetMapping("/{codigo}")
	public void buscarProveedres (@PathVariable String codigo) {
		control.buscarProveedres(codigo);		
	}
	
	@DeleteMapping("/{codigo}")
    public void eliminarProveedor (@PathVariable String codigo) {
        control.eliminarProveedor(codigo);
    }
	
	@PutMapping("/{codigo}")
    public void modificarProveedor (@PathVariable String codigo, @RequestBody Proveedores proveedores) {
        control.modificarProveedor(codigo, proveedores);
    }
	
	@GetMapping
	public ArrayList <Proveedores> listarProveedores() {
        return control.listarProveedores();
    }
}
