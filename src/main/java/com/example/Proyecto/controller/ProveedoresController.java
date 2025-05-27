package com.example.Proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyecto.modelos.Proveedores;
import com.example.Proyecto.service.ProveedoresService;

@RestController
@RequestMapping("/Supermercado/proveedores")

public class ProveedoresController {

    private final ProveedoresService control;

    @Autowired
    public ProveedoresController(ProveedoresService control) {
        this.control = control;
    }

    @PostMapping
    public ResponseEntity<String> agregarProveedores(@RequestBody Proveedores proveedores) {
        Proveedores nuevo = control.agregarProveedor(proveedores);
        if (nuevo != null) {
            return new ResponseEntity<>("✅ Proveedor agregado correctamente.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("❌ No se pudo agregar el proveedor.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Proveedores> buscarProveedres(@PathVariable int codigo) {
        Proveedores encontrado = control.buscarProveedres(codigo);
        if (encontrado != null) {
            return new ResponseEntity<>(encontrado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> eliminarProveedor(@PathVariable int codigo) {
		try {
			control.eliminarProveedor(codigo); // solo llamás al método
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

    @PutMapping("/{codigo}")
	public ResponseEntity<String> modificarProveedor(@PathVariable int codigo, @RequestBody Proveedores proveedores) {
		try {
			control.modificarProveedor(codigo, proveedores); // solo llamás al método (no devuelve nada)
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

    @GetMapping
    public ResponseEntity<List<Proveedores>> listarProveedores() {
        return new ResponseEntity<>(control.listarProveedores(), HttpStatus.OK);
    }
}