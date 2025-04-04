package modelos;
import modelos.Productos;

import java.time.LocalDate;
import java.util.ArrayList;
import modelos.MediosDePago;
public class Factura {

	private String numFactura;
	String nombreEmpleado;
	ArrayList <Productos> productos;
	double total;
	MediosDePago pago;
	int cantArticulos;
	LocalDate fechaDeVenta;
	ArrayList <Factura> facturas;
	public Factura(String numFactura, String nombreEmpleado, ArrayList<Productos> productos, double total,
			MediosDePago pago, int cantArticulos, LocalDate fechaDeVenta) {
		super();
		this.numFactura = numFactura;
		this.nombreEmpleado = nombreEmpleado;
		this.productos = productos;
		this.total = total;
		this.pago = pago;
		this.cantArticulos = cantArticulos;
		this.fechaDeVenta = fechaDeVenta;
	}
	public String getNumFactura() {
		return numFactura;
	}
	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public ArrayList<Productos> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Productos> productos) {
		this.productos = productos;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public MediosDePago getPago() {
		return pago;
	}
	public void setPago(MediosDePago pago) {
		this.pago = pago;
	}
	public int getCantArticulos() {
		return cantArticulos;
	}
	public void setCantArticulos(int cantArticulos) {
		this.cantArticulos = cantArticulos;
	}
	public LocalDate getFechaDeVenta() {
		return fechaDeVenta;
	}
	public void setFechaDeVenta(LocalDate fechaDeVenta) {
		this.fechaDeVenta = fechaDeVenta;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	@Override
	public String toString() {
		return "Factura [numFactura=" + numFactura + ", nombreEmpleado=" + nombreEmpleado + ", productos=" + productos
				+ ", total=" + total + ", pago=" + pago + ", cantArticulos=" + cantArticulos + ", fechaDeVenta="
				+ fechaDeVenta + "]";
	}
	
}
