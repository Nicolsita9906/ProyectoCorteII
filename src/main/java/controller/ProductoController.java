package controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import modelos.Productos;
import service.ProductoService;

@RestController
@RequestMapping("/Supermercado/productos")
public class ProductoController {
    private ProductoService control = new ProductoService();
    
    @Autowired
    public ProductoController(ProductoService control) {
		this.control = control;
	}

    @PostMapping
	public Productos agregarProducto(Productos producto){
        return control.agregarProducto(producto);
    }
    
    @GetMapping("/{codigo}")
    public  Productos buscarProducto(String codigo){
        return control.buscarProducto(codigo);
    }
    
    @DeleteMapping("/{codigo}")
    public void eliminarProducto(String codigo){
        control.eliminarProducto(codigo);
    }
    
    @PutMapping("/{codigo}")
    public void modificarProducto(String codigo, Productos producto){
        control.modificarProducto(codigo, producto);
    }
    
    
    public void restarProductos(int cantidad, String codigo){
        control.restarProductos(cantidad, codigo);
    }
    public double calcularTotalVenta(String codProd, int cantidad){
        return control.calcularTotalVenta(codProd, cantidad);
    }
    
    @GetMapping
    public ArrayList<Productos> mostrarProductos(){
        return control.mostrarProductos();
    }
    public void notificarStock(){
        control.notificarStock();
    }

}
