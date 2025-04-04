package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import modelos.Categoria;
import modelos.Productos;
import excepciones.StockBajo;
public class ProductoRepository {
    ArrayList<Productos> productos = new ArrayList<>();

    public Productos agregarProducto(Productos producto) {
        for (Productos x : productos) {
        	if (x.getCodigo().equals(producto.getCodigo())) {
        		System.out.println("El codigo ya existe en el sistema");
        	}
        }
        productos.add(producto);
		System.out.println("Producto agregado con exito" + producto);
		return producto;
		
        
    }

    public  Productos buscarProducto(String codigo) {
        boolean encontrado = false;
        for (Productos x : this.productos) {
            if (x.getCodigo().equals(codigo)) {
                System.out.println("Producto encontrado: " + x);
                encontrado = true;
                return x;
            }
        }
            System.out.println("El código no existe en el sistema");
            return null;
        
    }

    public void eliminarProducto(String codigo) {
        Iterator<Productos> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Productos x = iterator.next();
            if (x.getCodigo().equals(codigo)) {
                iterator.remove();
                System.out.println("Producto eliminado: " + x);
                return;
            }
        }
        System.out.println("El código no existe en el sistema");
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
                System.out.println("Producto modificado: " + x.toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("El código no existe en el sistema");
        }
    }

    public void restarProductos(int cantidad, String codigo) {
        for (Productos x : productos) {
            if (x.getCodigo().equals(codigo)) {
                if (x.getStock() >= cantidad) {
                    x.setStock(x.getStock() - cantidad);
                    System.out.println("Stock actualizado: " + x.toString());
                } else {
                    System.out.println("No hay suficiente stock para realizar la venta");
                }
                return; 
            }
        }
        System.out.println("El código no existe en el sistema");
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
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el sistema");
        } else {
            for (Productos x : productos) {
                System.out.println(x);
            }
        }
        return this.productos;
    }

    public void notificarStock() {
        boolean hayStockBajo = false;
        for (Productos x : productos) {
            if (x.getStock() < 20) {
                hayStockBajo = true;
                try {
                    throw new StockBajo("El producto " + x.getNombre() + " tiene un stock menor a 20, llame al proveedor");
                } catch (StockBajo e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Advertencia de Stock", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if (!hayStockBajo) {
            System.out.println("Aún no se necesita suministrar productos");
        }
    }
}