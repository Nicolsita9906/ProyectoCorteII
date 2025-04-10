package repository;
import excepciones.*;
import modelos.*;
import java.util.ArrayList;
import java.time.LocalDate;
import excepciones.NotificarExito;
import vistas.FuncionExitosa;
public class VentaRepository {
	ArrayList <Venta> ventas = new ArrayList<Venta>();
	FuncionExitosa exito = new FuncionExitosa();

	public VentaRepository() {
		
	}

	public String buscarEmpleado(String codEmp) {
		for(Venta v : ventas){
			if (v.getCodEmp().equals(codEmp)) {
				return v.getCodEmp();
			}
		}
		return null;
	}
	public String buscarProducto(String codProd) {
		for(Venta v : ventas){
			if (v.getCodProd().equals(codProd)) {
				return v.getCodProd();
			}
		}
		return null;
	}
	
	public Venta agregarVenta(Venta venta) {
		if(buscarEmpleado(venta.getCodEmp()) != null && buscarProducto(venta.getCodProd()) != null) {
			ventas.add(venta);
			try {
				throw new NotificarExito(exito);
			} catch (NotificarExito e) {
				exito.setVisible(true);
			}
			ProductoRepository producto = new ProductoRepository();
			producto.restarProductos(venta.getCantidad(), venta.getCodProd());
			producto.notificarStock();
			return venta;
		}else{
			if(buscarProducto(venta.getCodProd())== null) {
				//excepcion ventana
			}
			if(buscarEmpleado(venta.getCodEmp())== null) {
				//excepcion ventana
			}
			return null;
		}
	}
	public ArrayList<Venta> mostrarVentas(){
		return ventas;
	}
}