package service;
import modelos.Venta;
import repository.VentaRepository;
import java.util.ArrayList;
public class VentaService {

    VentaRepository servicio = new VentaRepository();
    public Venta crearVenta (Venta venta) {
        return servicio.crearVenta(venta);
    }
    public Venta buscarVenta (String codVenta) {
        return servicio.buscarVenta(codVenta);
    }
    public ArrayList<Venta> listarVentas () {
        return servicio.getVentas();
    }
}
