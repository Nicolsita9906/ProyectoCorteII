package repository;
import java.time.LocalDate;
import vistas.CodigoExistente;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Categoria;
import modelos.Productos;
import excepciones.CodigoExistentee;
import excepciones.StockBajo;
import vistas.ErrorStockBajo;
import vistas.FuncionExitosa;
import excepciones.NotificarExito;
import excepciones.CodigoNoEncontrado;
import static java.awt.SystemColor.control;
import vistas.NoEncontrado;

public class ProductoRepository {
    ArrayList<Productos> productos = new ArrayList<>();
    ErrorStockBajo error = new ErrorStockBajo();
    CodigoExistente codigoExistente = new CodigoExistente ();
    FuncionExitosa exito = new FuncionExitosa ();
    NoEncontrado noEncontrado = new NoEncontrado ();

    public Productos agregarProducto(Productos producto) {
        for (Productos x : productos) {
        	if (x.getCodigo().equals(producto.getCodigo())) {
        		 try {
                     throw new CodigoExistentee(codigoExistente);
                 } catch (CodigoExistentee e) {
                	 codigoExistente.setVisible(true);
                 }
        	}
        }
        productos.add(producto);
        try {
            throw new NotificarExito(exito);
        } catch (NotificarExito e) {
            exito.setVisible(true);
        }
		return producto;
    }

    public Productos buscarProducto(String codigo) {
    for (Productos x : this.productos) {
        if (x.getCodigo().equals(codigo)) {
            return x; // si lo encuentra, lo retorna
        }
    }
    return null; // si no encuentra ninguno, retorna null
}


    public void eliminarProducto(String codigo) {
        Iterator<Productos> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Productos x = iterator.next();
            if (x.getCodigo().equals(codigo)) {
                iterator.remove();
                try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                return;
            }
        }
        try {
            throw new CodigoNoEncontrado(noEncontrado);
        } catch (CodigoNoEncontrado e) {
        	noEncontrado.setVisible(true);
        }
    }

    public void modificarProducto(String codigo, Productos producto) {
        boolean encontrado = false;
        for (Productos x : productos) {
            if (x.getCodigo().equals(codigo)) {
                x.setNombre(producto.getNombre());
                x.setPrecio(producto.getPrecio());
                x.setCaducidad(producto.getCaducidad());
                x.setCodigo(producto.getCodigo());
                x.setStock(producto.getStock());
                x.setCategoria(producto.getCategoria());
                try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
        	try {
                throw new CodigoNoEncontrado(noEncontrado);
            } catch (CodigoNoEncontrado e) {
            	noEncontrado.setVisible(true);
            }
        }
    }

    public void restarProductos(int cantidad, String codigo) {
        for (Productos x : productos) {
            if (x.getCodigo().equals(codigo)) {
                if (x.getStock() >= cantidad) {
                    x.setStock(x.getStock() - cantidad);
                } else {
                    System.out.println("No hay suficiente stock para realizar la venta");
                }
                return; 
            }
        }
        
    }

    public double calcularTotalVenta(String codProd, int cantidad) {
        for (Productos producto : productos) {
            if (producto.getCodigo().equals(codProd)) {
                return producto.getPrecio() * cantidad;
            }
        }
        return 0.0;
    }

    public ArrayList<Productos> mostrarProductos() {
        
            for (Productos x : productos) {
            	//mostrar productos en tabla
                System.out.println(x);
            }
        
        return this.productos;
    }

    public void notificarStock() {
        boolean hayStockBajo = false;
        for (Productos x : productos) {
            if (x.getStock() < 20) {
                hayStockBajo = true;
                try {
                    throw new StockBajo(error);
                } catch (StockBajo e) {
                    error.setVisible(true);
                }
            }
        }
        return;
    }
 

}