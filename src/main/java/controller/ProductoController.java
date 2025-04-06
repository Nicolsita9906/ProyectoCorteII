package controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import modelos.Productos;
import service.ProductoService;

@RestController
@RequestMapping("/Supermercado/productos")
public class ProductoController {
    private ProductoService control;
    
    @Autowired
    public ProductoController(ProductoService control) {
		this.control = control;
	}

    @PostMapping
	public Productos agregarProducto(@RequestBody Productos producto){
        return control.agregarProducto(producto);
    }
    
    @GetMapping("/{codigo}")
    public  Productos buscarProducto(@PathVariable String codigo){
        return control.buscarProducto(codigo);
    }
    
    @DeleteMapping("/{codigo}")
    public void eliminarProducto(@PathVariable String codigo){
        control.eliminarProducto(codigo);
    }
    
    @PutMapping("/{codigo}")
    public void modificarProducto(@PathVariable String codigo, @RequestBody Productos producto){
        control.modificarProducto(codigo, producto);
    }
  
    
    @GetMapping
    public ArrayList<Productos> mostrarProductos(){
        return control.mostrarProductos();
    }
    public void notificarStock(){
        control.notificarStock();
    }

}
