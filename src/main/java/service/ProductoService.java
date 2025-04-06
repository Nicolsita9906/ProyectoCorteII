package service;
import repository.ProductoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Productos;
public class ProductoService {

	private ProductoRepository servicio;
	
	public ProductoService(ProductoRepository servicio) {
		this.servicio = servicio;
		datosMuertos();
	}
	
	public void datosMuertos() {
		agregarProducto(new Productos("Mouse óptico", 20.5, LocalDate.of(2025, 12, 31), Categoria.HOGAR, 10));
		agregarProducto(new Productos("Teclado mecánico", 45.0, LocalDate.of(2026, 3, 15), Categoria.HOGAR, 15));
		agregarProducto(new Productos("Monitor LED", 150.75, LocalDate.of(2027, 7, 1), Categoria.JUGUETERIA, 8));
		agregarProducto(new Productos("Impresora multifuncional", 300.0, LocalDate.of(2025, 11, 5), Categoria.ASEO, 5));
		agregarProducto(new Productos("Memoria USB 32GB", 10.0, LocalDate.of(2026, 8, 20), Categoria.COMESTIBLES, 50));
	}
	
	public Productos agregarProducto(Productos producto) {
		return servicio.agregarProducto(producto);
	}
	
	public  Productos buscarProducto(String codigo) {
		return servicio.buscarProducto(codigo);
	}
	
	public void eliminarProducto(String codigo) {
		servicio.eliminarProducto(codigo);
	}
	
	public void modificarProducto(String codigo, Productos producto) {
		servicio.modificarProducto(codigo, producto);
	}
	
	  public void restarProductos(int cantidad, String codigo) {
		  servicio.restarProductos(cantidad, codigo);
	  }
	  
	  public double calcularTotalVenta(String codProd, int cantidad) {
		  return servicio.calcularTotalVenta(codProd, cantidad);
	  }
	  
	  public ArrayList<Productos> mostrarProductos() {
		  return servicio.mostrarProductos();
	  }
	  
	  public void notificarStock() {
		  servicio.notificarStock();
	  }
}
