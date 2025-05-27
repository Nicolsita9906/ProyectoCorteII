package com.example.Proyecto.repository;
import java.util.ArrayList;
import com.example.Proyecto.modelos.Empleado;
import com.example.Proyecto.modelos.Productos;
import com.example.Proyecto.modelos.Venta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import com.example.Proyecto.repository.ProductoRepository;
import com.example.Proyecto.repository.EmpleadoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class VentaRepository {

	@PersistenceContext
    EntityManager entityManager;
	private final ProductoRepository prod = new ProductoRepository();
	private final EmpleadoRepository emp = new EmpleadoRepository();
	
	@Transactional
	public String buscarEmpleado(int codigo) {
		Empleado empleado = entityManager.find(Empleado.class, codigo);
		if (empleado == null) {
			return null;
		}
		entityManager.close();
	return emp.buscarEmpleado(codigo).getNombreEmpleado();
	}
	public String buscarProducto(int codigo) {
		return prod.buscarProducto(codigo).getNombre();   
	}
	
@Transactional
	public Venta agregarVenta(Venta venta) {
		entityManager.persist(venta);
		return venta;
	}
	
@Transactional
	public List<Venta> mostrarVentas(){
		List<Venta> ventas = new ArrayList<>();
		ventas = entityManager.createQuery("SELECT v FROM Venta v", Venta.class).getResultList();
		return ventas;
	}
}