package service;
import repository.ProductoRepository;

import java.util.ArrayList;

import modelos.Productos;
public class ProductoService {

	private ProductoRepository servicio = new ProductoRepository ();
	
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
