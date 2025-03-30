package modelos;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Productos;
public class Venta {
	private ArrayList <Productos> productos;
    LocalDate fechaVenta;
    String codEmp;
    String codProd;
    int cantidad;
    double totalVenta;
    
    public Venta(LocalDate fechaVenta, String codEmp, String codProd, int cantidad, double totalVenta) {
       this.productos = new ArrayList <Productos> ();
    	this.fechaVenta = fechaVenta;
        this.codEmp = codEmp;
        this.codProd = codProd;
        this.cantidad = cantidad;
        this.totalVenta = totalVenta;
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
    
    public String getCodProd() {
        return codProd;
    }
    
    public void setCodProd(String codProd) {
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
