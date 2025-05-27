package com.example.Proyecto.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Proyecto.modelos.Productos;
import com.example.Proyecto.service.ProductoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/Supermercado/productos")
public class ProductoController {
    private ProductoService control;
    
    @Autowired
    public ProductoController(ProductoService control) {
        // Constructor de la clase ProductoController
        this.control = control;
        
    }

    @PostMapping
    public ResponseEntity<String> agregarProducto(@RequestBody Productos producto){
        try {
            control.agregarProducto(producto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Productos> buscarProducto(@PathVariable int codigo){
        try {
            Productos producto = control.buscarProducto(codigo);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int codigo){
        try {
            control.eliminarProducto(codigo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<String> modificarProducto(@PathVariable int codigo, @RequestBody Productos producto){
        try {
            control.modificarProducto(codigo, producto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Productos>> mostrarProductos(){
        return new ResponseEntity<>(control.mostrarProductos(), HttpStatus.OK);
    }

}
