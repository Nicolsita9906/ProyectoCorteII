package controller;
import java.util.ArrayList;
import modelos.Venta;
import repository.*;
import service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Venta agregarVenta(@RequestBody Venta venta) {
        return control.agregarVenta(venta);
    }
        @GetMapping
        public ArrayList<Venta> mostrarVentas() {
        return control.mostrarVentas();
    }

}
