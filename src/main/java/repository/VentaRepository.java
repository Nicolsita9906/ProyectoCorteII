package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Venta;
import vistas.FuncionExitosa;
import vistas.NoEncontrado;
import modelos.Factura;
import modelos.Productos;
import javax.swing.JOptionPane;

import excepciones.CodigoExistentee;
import excepciones.CodigoNoEncontrado;
import excepciones.NotificarExito;

public class VentaRepository {
	private ArrayList <Venta> ventas = new ArrayList <Venta>();
	private ProductoRepository producto = new ProductoRepository ();
	FuncionExitosa exito = new FuncionExitosa ();
    NoEncontrado noEncontrado = new NoEncontrado ();
	
	public VentaRepository() {
		
	}
	public Productos agregarProducto (String codProducto) {
		
		return producto.buscarProducto(codProducto);
	}
	
	public Venta crearVenta(Venta venta) {
	    // Lista para acumular los productos agregados a la venta
	    ArrayList<Productos> productosAgregados = new ArrayList<>();

	    // Preguntar si se desea agregar más productos
	    int response = JOptionPane.showConfirmDialog(null, "Desea agregar mas productos?", "Confirmar", JOptionPane.YES_NO_OPTION);
	    if (response == JOptionPane.YES_OPTION) {
	        // Iterar sobre cada código de producto contenido en la venta
	        for (String codigoProd : venta.getCodProd()) {
	            Productos prod = agregarProducto(codigoProd);
	            if (prod != null) {
	                productosAgregados.add(prod);
	                producto.notificarStock();
	            } else {
	                try {
	                    // Se lanza y captura la excepción para notificar que el código no se encontró
	                    throw new CodigoNoEncontrado(noEncontrado);
	                } catch (CodigoNoEncontrado e) {
	                    noEncontrado.setVisible(true);
	                }
	            }
	        }
	    }

	    // Actualizamos la venta con la lista de productos encontrados
	    venta.setProductos(productosAgregados);

	    try {
	        // Notificar que la venta se realizó con éxito
	        throw new NotificarExito(exito);
	    } catch (NotificarExito e) {
	        exito.setVisible(true);
	    }
	    
	    // Agregar la venta a la lista de ventas
	    ventas.add(venta);
	    return venta;
	}

	
	public VentaRepository(ArrayList<Venta> ventas) {
		super();
		this.ventas = ventas;
	}

	public ArrayList <Venta> getVentas () {
		return ventas;
		//mensaje para mostrar ventas
	}
}
