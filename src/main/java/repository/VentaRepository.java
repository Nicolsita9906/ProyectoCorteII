package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Productos;
import modelos.Venta;
import modelos.Productos;
import modelos.Factura;
import repository.ProductoRepository;
import javax.swing.JOptionPane;
import modelos.Productos; 
public class VentaRepository {
	private ArrayList <Venta> ventas = new ArrayList <Venta>();
	private ProductoRepository producto = new ProductoRepository ();

	public Productos agregarProducto (String codProducto) {
		
		return producto.buscarProducto(codProducto);
	}
	public Venta crearVenta (Venta venta) {
		ArrayList <Productos> productos = new ArrayList <Productos>();
		//validar si hay que agregar mas productos
		int response = JOptionPane.showConfirmDialog(null, "Desea agregar mas productos?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            //agregar productos
            if (agregarProducto(venta.getCodProd()) != null){
                productos.add(agregarProducto(venta.getCodProd()));
                producto.notificarStock();
			}else{
			JOptionPane.showMessageDialog(null, "El producto no existe");
		}
		}
		ventas.add(venta);
		//mesaje venta realizada con exito
		return venta;
	}
	public Venta buscarVenta (String fechaVenta) {
		for (Venta x : ventas) {
			if (x.getCodEmp().equals(fechaVenta)) {
				//mostrar mensaje de encontrado
				return x;
			}
		}
		//mostrar mensaje de no encontrado
		return null;
	}
	public ArrayList <Venta> getVentas () {
		return ventas;
		//mensaje para mostrar ventas
	}
}
