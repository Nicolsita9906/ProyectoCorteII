package modelos;
import java.time.LocalDate;
import modelos.Categoria;
import java.util.UUID;
public class Productos {

    private String nombre;
    private String codigo;
    private double precio;
    private LocalDate caducidad;
    private Categoria categoria;
    private int stock;
    public Productos (String codigo) {
    	this.codigo = UUID.randomUUID().toString();   	
    }
    
	public Productos(String nombre, double precio, LocalDate caducidad, Categoria categoria, int stock) {
    	this.codigo = UUID.randomUUID().toString();   	
		this.nombre = nombre;
		this.precio = precio;
		this.caducidad = caducidad;
		this.categoria = categoria;
		this.stock = stock;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
    

   
    
  
    
}