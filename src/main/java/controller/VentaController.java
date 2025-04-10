package controller;
import java.util.ArrayList;
import modelos.Venta;
import repository.VentaRepository;
import service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Supermercado/ventas")
public class VentaController {
    private VentaService control = new VentaService(new VentaRepository());

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
