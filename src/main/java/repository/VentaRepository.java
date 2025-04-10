package repository;
import repository.*;
import excepciones.*;
import modelos.*;
import java.util.ArrayList;
import java.time.LocalDate;
import excepciones.NotificarExito;
import vistas.FuncionExitosa;
import vistas.NoEncontrado;
import vistas.ErrorStockBajo;
public class VentaRepository {
    private ProductoRepository prod;
    private EmpleadoRepository emp;
    private ArrayList<Venta> ventas = new ArrayList<>();

    public VentaRepository(ProductoRepository prod, EmpleadoRepository emp) {
        this.prod = prod;
        this.emp = emp;
    }
	public Empleado buscarEmpleado(String codigo) {
		return emp.buscarEmpleado(codigo);
	}
	public Productos buscarProducto(String codigo) {
		return prod.buscarProducto(codigo);
	}
	
	public Venta agregarVenta(Venta venta) {
		if(buscarEmpleado(venta.getCodEmp()) != null && buscarProducto(venta.getCodProd()) != null) {
		ventas.add(venta);
		venta.setTotalVenta(buscarProducto(venta.getCodProd()).getPrecio()*venta.getCantidad());
		return venta;	
		}else{
			return null;
		}
	}
	
	public ArrayList<Venta> mostrarVentas(){
		return ventas;
	}
}