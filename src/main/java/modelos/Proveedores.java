package modelos;
import modelos.Categoria;
import java.util.UUID;

public class Proveedores {
private String nombreProveedor;
private String codigo;
private String empresa;
private String telefono;
private int cantidadProductosIngresados;
private Categoria categoriaProductos;
public Proveedores (String codigo) {
	this.codigo = UUID.randomUUID().toString();
}
public Proveedores(String nombreProveedor, String empresa, String telefono, int cantidadProductosIngresados,
		Categoria categoriaProductos) {
	this.codigo = UUID.randomUUID().toString();
	this.nombreProveedor = nombreProveedor;
	this.empresa = empresa;
	this.telefono = telefono;
	this.cantidadProductosIngresados = cantidadProductosIngresados;
	this.categoriaProductos = categoriaProductos;
}
public String getNombreProveedor() {
	return nombreProveedor;
}
public void setNombreProveedor(String nombreProveedor) {
	this.nombreProveedor = nombreProveedor;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public String getEmpresa() {
	return empresa;
}
public void setEmpresa(String empresa) {
	this.empresa = empresa;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public int getCantidadProductosIngresados() {
	return cantidadProductosIngresados;
}
public void setCantidadProductosIngresados(int cantidadProductosIngresados) {
	this.cantidadProductosIngresados = cantidadProductosIngresados;
}
public Categoria getCategoriaProductos() {
	return categoriaProductos;
}
public void setCategoriaProductos(Categoria categoriaProductos) {
	this.categoriaProductos = categoriaProductos;
}


}