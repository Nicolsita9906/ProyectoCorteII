package modelos;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Productos;
public class Venta {
	private ArrayList <Productos> productos;
    private LocalDate fechaVenta;
    private String codEmp;
    private ArrayList <String> codProd;
    private int cantidad;
    private double totalVenta;
    
    public Venta(LocalDate fechaVenta, String codEmp, ArrayList <String> codProd, int cantidad, double totalVenta, ArrayList <Productos> productos) {
       this.productos = productos;
    	this.fechaVenta = fechaVenta;
        this.codEmp = codEmp;
        this.codProd = codProd;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
    }
    
    public ArrayList<Productos> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}

	public LocalDate getFechaVenta() {
        return fechaVenta;
    }
    
    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    
    public String getCodEmp() {
        return codEmp;
    }
    
    public void setCodEmp(String codEmp) {
        this.codEmp = codEmp;
    }
    
    public ArrayList <String> getCodProd() {
        return codProd;
    }
    
    public void setCodProd(ArrayList <String> codProd) {
        this.codProd = codProd;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getTotalVenta() {
        return totalVenta;
    }
    
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }
    
}
