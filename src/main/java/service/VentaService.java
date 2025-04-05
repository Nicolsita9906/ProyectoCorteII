package service;
import java.util.ArrayList;

import modelos.Venta;
import repository.VentaRepository;
public class VentaService {

    VentaRepository servicio = new VentaRepository();
    public Venta crearVenta (Venta venta) {
        return servicio.crearVenta(venta);
    }    public ArrayList<Venta> listarVentas () {
        return servicio.getVentas();
    }
}
