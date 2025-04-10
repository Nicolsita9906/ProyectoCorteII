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

    public void datosMuertos (){
        ArrayList <Productos> productos = prod.mostrarProductos();
        ArrayList <Empleado> empleados = emp.listarEmpleados();
        agregarVenta(new Venta(productos.get(0).getCodigo(), LocalDate.of(2020, 1, 10), empleados.get(0).getCodigo(), 2));
        agregarVenta(new Venta(productos.get(1).getCodigo(), LocalDate.of(2021, 3, 15), empleados.get(1).getCodigo(), 4));
        agregarVenta(new Venta(productos.get(2).getCodigo(), LocalDate.of(2019, 6, 20), empleados.get(2).getCodigo(), 6));
        agregarVenta(new Venta(productos.get(3).getCodigo(), LocalDate.of(2022, 9, 5), empleados.get(3).getCodigo(), 4));
        agregarVenta(new Venta(productos.get(4).getCodigo(), LocalDate.of(2023, 1, 10), empleados.get(4).getCodigo(), 5));
      

    }
    public Venta agregarVenta (Venta venta) {
    	return servicio.agregarVenta(venta);
    }
 
    public ArrayList <Venta> mostrarVentas () {
    	return servicio.mostrarVentas();
    }
}
