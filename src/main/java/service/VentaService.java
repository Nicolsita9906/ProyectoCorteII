package service;
import java.time.LocalDate;
import java.util.ArrayList;
import service.*;
import modelos.Empleado;
import modelos.Productos;
import modelos.Venta;
import repository.*;
public class VentaService {

    VentaRepository servicio;
    ProductoService prod = new ProductoService(new ProductoRepository());
    EmpleadoService emp = new EmpleadoService(new EmpleadoRepository());

    public VentaService(VentaRepository servicio) {
        this.servicio = servicio;
        datosMuertos();
    }

    public void datosMuertos() {
        ArrayList<Productos> productos = prod.mostrarProductos();
        ArrayList<Empleado> empleados = emp.listarEmpleados();

        // Crear listas de productos y códigos por venta
        ArrayList<Productos> venta1Prods = new ArrayList<>();
        ArrayList<String> venta1Cods = new ArrayList<>();
        venta1Prods.add(productos.get(0)); // Mouse óptico
        venta1Cods.add(productos.get(0).getCodigo());

        ArrayList<Productos> venta2Prods = new ArrayList<>();
        ArrayList<String> venta2Cods = new ArrayList<>();
        venta2Prods.add(productos.get(1)); // Teclado
        venta2Cods.add(productos.get(1).getCodigo());

        ArrayList<Productos> venta3Prods = new ArrayList<>();
        ArrayList<String> venta3Cods = new ArrayList<>();
        venta3Prods.add(productos.get(2)); // Monitor
        venta3Cods.add(productos.get(2).getCodigo());

        ArrayList<Productos> venta4Prods = new ArrayList<>();
        ArrayList<String> venta4Cods = new ArrayList<>();
        venta4Prods.add(productos.get(3)); // Impresora
        venta4Cods.add(productos.get(3).getCodigo());

        ArrayList<Productos> venta5Prods = new ArrayList<>();
        ArrayList<String> venta5Cods = new ArrayList<>();
        venta5Prods.add(productos.get(4)); // USB
        venta5Cods.add(productos.get(4).getCodigo());

        // Crear objetos Venta con listas de códigos de producto
        crearVenta(new Venta(LocalDate.of(2025, 4, 1), empleados.get(0).getCodigo(), venta1Cods, 2, 41.0, venta1Prods));
        crearVenta(new Venta(LocalDate.of(2025, 4, 2), empleados.get(1).getCodigo(), venta2Cods, 1, 45.0, venta2Prods));
        crearVenta(new Venta(LocalDate.of(2025, 4, 3), empleados.get(2).getCodigo(), venta3Cods, 1, 150.75, venta3Prods));
        crearVenta(new Venta(LocalDate.of(2025, 4, 4), empleados.get(3).getCodigo(), venta4Cods, 1, 300.0, venta4Prods));
        crearVenta(new Venta(LocalDate.of(2025, 4, 5), empleados.get(4).getCodigo(), venta5Cods, 3, 30.0, venta5Prods));
    }

    public Venta crearVenta(Venta venta) {
    	return servicio.crearVenta(venta);
    }
 
    public ArrayList <Venta> getVentas () {
    	return servicio.getVentas();
    }
}
