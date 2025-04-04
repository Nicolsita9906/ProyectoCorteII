package controller;
import java.util.ArrayList;

import modelos.Productos;
import repository.ProductoRepository;
public class ProductoController {
    private ProductoRepository control = new ProductoRepository();
    public Productos agregarProducto(Productos producto){
        return control.agregarProducto(producto);
    }
    public  Productos buscarProducto(String codigo){
        return control.buscarProducto(codigo);
    }
    public void eliminarProducto(String codigo){
        control.eliminarProducto(codigo);
    }
    public void modificarProducto(String codigo, Productos producto){
        control.modificarProducto(codigo, producto);
    }
    public void restarProductos(int cantidad, String codigo){
        control.restarProductos(cantidad, codigo);
    }
    public double calcularTotalVenta(String codProd, int cantidad){
        return control.calcularTotalVenta(codProd, cantidad);
    }
    public ArrayList<Productos> mostrarProductos(){
        return control.mostrarProductos();
    }
    public void notificarStock(){
        control.notificarStock();
    }

}
