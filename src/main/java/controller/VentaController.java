package controller;
import java.util.List;

import modelos.Venta;
import service.VentaService;
public class VentaController {
    private VentaService ventaService = new VentaService();
    public Venta crearVenta(Venta venta) {
        return ventaService.crearVenta(venta);
    }
    public Venta buscarVenta(String codVenta) {
        return ventaService.buscarVenta(codVenta);
    }
    public List<Venta> listarVentas() {
        return ventaService.listarVentas();
    }

}
