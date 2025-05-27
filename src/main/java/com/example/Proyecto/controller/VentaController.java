package com.example.Proyecto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Proyecto.modelos.Venta;
import com.example.Proyecto.repository.VentaRepository;
import com.example.Proyecto.service.VentaService;

@RestController
@RequestMapping("/Supermercado/ventas")
public class VentaController {
    VentaService control = new VentaService(new VentaRepository());

    @Autowired
    public VentaController(VentaService control) {
        this.control = control;
    }

    @PostMapping("/vender")
    public ResponseEntity<String> agregarVenta(@RequestBody Venta venta) {
        Venta nuevaVenta = control.agregarVenta(venta);
        if (nuevaVenta != null) {
            return new ResponseEntity<>( HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Venta>> mostrarVentas() {
        
        return new ResponseEntity<>(control.mostrarVentas(), HttpStatus.OK); 
    }
}
