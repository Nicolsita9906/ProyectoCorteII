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
    ProductoService prod = new ProductoService (new ProductoRepository ());
    EmpleadoService emp = new EmpleadoService (new EmpleadoRepository());
    
    public VentaService(VentaRepository servicio) {
		this.servicio = servicio;
		
	}
    
    public void datosMuertos () {
    	ArrayList<Productos> productos = prod.mostrarProductos();
    	ArrayList<Empleado> empleados = emp.listarEmpleados();

    	// Crear listas por venta
    	ArrayList<Productos> venta1Prods = new ArrayList<>();
    	venta1Prods.add(productos.get(0)); // Mouse óptico

    	ArrayList<Productos> venta2Prods = new ArrayList<>();
    	venta2Prods.add(productos.get(1)); // Teclado

    	ArrayList<Productos> venta3Prods = new ArrayList<>();
    	venta3Prods.add(productos.get(2)); // Monitor

    	ArrayList<Productos> venta4Prods = new ArrayList<>();
    	venta4Prods.add(productos.get(3)); // Impresora

    	ArrayList<Productos> venta5Prods = new ArrayList<>();
    	venta5Prods.add(productos.get(4)); // USB

    	// Crear objetos Venta
    	crearVenta(new Venta(LocalDate.of(2025, 4, 1), empleados.get(0).getCodigo(), productos.get(0).getCodigo(), 2, 41.0, venta1Prods));
    	crearVenta(new Venta(LocalDate.of(2025, 4, 2), empleados.get(1).getCodigo(), productos.get(1).getCodigo(), 1, 45.0, venta2Prods));
    	crearVenta(new Venta(LocalDate.of(2025, 4, 3), empleados.get(2).getCodigo(), productos.get(2).getCodigo(), 1, 150.75, venta3Prods));
    	crearVenta(new Venta(LocalDate.of(2025, 4, 4), empleados.get(3).getCodigo(), productos.get(3).getCodigo(), 1, 300.0, venta4Prods));
    	crearVenta(new Venta(LocalDate.of(2025, 4, 5), empleados.get(4).getCodigo(), productos.get(4).getCodigo(), 3, 30.0, venta5Prods);
    	
    	
    }
    
	public Venta crearVenta (Venta venta) {
        return servicio.crearVenta(venta);
    }    public ArrayList<Venta> listarVentas () {
        return servicio.getVentas();
    }
    public ArrayList <Venta> getVentas () {
    	return servicio.getVentas();
    }
}
