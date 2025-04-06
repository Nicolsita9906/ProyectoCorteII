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
				try {
		            throw new CodigoNoEncontrado(noEncontrado);
		        } catch (CodigoNoEncontrado e) {
		        	noEncontrado.setVisible(true);
		        }
		}
		}
        try {
            throw new NotificarExito(exito);
        } catch (NotificarExito e) {
            exito.setVisible(true);
        }
		ventas.add(venta);
		//mesaje venta realizada con exito
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
