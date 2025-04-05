package controller;
import java.util.List;
import modelos.Venta;
import service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Supermercado/ventas")
public class VentaController {
    private VentaService ventaService = new VentaService();

    @Autowired
    public VentaController(VentaService ventaService) {
        ventaService = ventaService;
    }

    @PostMapping("/vender")
    public Venta crearVenta(Venta venta) {
        return ventaService.crearVenta(venta);
    }
        @GetMapping
        public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

}
