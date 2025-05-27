package com.example.Proyecto.service;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.Proyecto.modelos.Categoria;
import com.example.Proyecto.modelos.Productos;
import com.example.Proyecto.repository.ProductoRepository;
import com.example.Proyecto.repository.EmpleadoRepository;

@Service
public class ProductoService {

	private ProductoRepository servicio;
	
	public ProductoService(ProductoRepository servicio) {
		this.servicio = servicio;
	}
	
	public Productos agregarProducto(Productos producto) {
		return servicio.agregarProducto(producto);
	}
	
	public  Productos buscarProducto(int codigo) {
		return servicio.buscarProducto(codigo);
	}
	
	public void eliminarProducto(int codigo) {
		servicio.eliminarProducto(codigo);
	}
	
	public void modificarProducto(int codigo, Productos producto) {
		servicio.modificarProducto(codigo, producto);
	}
	
	  public void restarProductos(int cantidad, int codigo) {
		  servicio.restarProductos(cantidad, codigo);
	  }
	  
	  public double calcularTotalVenta(int codProd, int cantidad) {
		  return servicio.calcularTotalVenta(codProd, cantidad);
	  }
	  
	  public List<Productos> mostrarProductos() {
		  return servicio.mostrarProductos();
	  }
}
