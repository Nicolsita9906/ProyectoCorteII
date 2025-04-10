package controller;

import java.util.ArrayList;
import modelos.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.*;
import service.VentaService;

@RestController
@RequestMapping("/Supermercado/ventas")
public class VentaController {

    ProductoRepository prod = new ProductoRepository();
    EmpleadoRepository emp = new EmpleadoRepository();
    VentaRepository ventaRepo = new VentaRepository(prod, emp);
    VentaService control = new VentaService(ventaRepo, prod, emp);

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
    public ResponseEntity<ArrayList<Venta>> mostrarVentas() {
        ArrayList<Venta> ventas = control.mostrarVentas();
        if (ventas.isEmpty()) {
            return new ResponseEntity<>(ventas, HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(ventas, HttpStatus.OK); 
    }
}
