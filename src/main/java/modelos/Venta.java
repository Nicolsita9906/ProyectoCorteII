package modelos;
import java.time.LocalDate;
import java.util.ArrayList;
import modelos.Productos;
import java.util.UUID;
import repository.ProductoRepository;
import modelos.Productos;

public class Venta {
    private String codProd;
    private LocalDate fechaVenta;
    private String codEmp;
    private int cantidad;
    private double totalVenta;
    private String codVenta;
    private ProductoRepository prod = new ProductoRepository();
    public Venta(String codVenta){
        this.codVenta = UUID.randomUUID().toString();
    }
    
    public Venta(String codProd, LocalDate fechaVenta, String codEmp, int cantidad) {
        this.codProd = codProd;
        this.fechaVenta = fechaVenta;
        this.codEmp = codEmp;
        this.cantidad = cantidad;
        this.codVenta = UUID.randomUUID().toString();
        this.totalVenta = calcularTotalVenta(codProd, cantidad);
    }
    public double calcularTotalVenta(String codProd, int cantidad) {
        ArrayList <Productos> productos = prod.mostrarProductos();
        for (Productos producto : productos) {
            if (producto.getCodigo().equals(codProd)) {
                return producto.getPrecio() * cantidad;
            }
        }
        return 0.0;
    }
    
    public String getCodProd() {
        return codProd; 
    }
    public void setCodProd(String codProd) {
        this.codProd = codProd; 
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
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getCodVenta() {
        return codVenta;
    }
    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }
    public double getTotalVenta() {
        return totalVenta;
    }
    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }


}
