package com.example.Proyecto.modelos;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedores")
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombreProveedor;

	@Column(name = "Empresa", nullable = false)
	private String empresa;

	@Column(name = "Telefono", nullable = false)
	private String telefono;

	@Column(name = "Cantidad", nullable = false)
	private int cantidadProductosIngresados;

	@Column(name = "Categoria", nullable = false)
	private int categoriaProductos;

public Proveedores(String nombreProveedor, String empresa, String telefono, int cantidadProductosIngresados, int categoriaProductos) {
		this.nombreProveedor = nombreProveedor;
		this.empresa = empresa;
		this.telefono = telefono;
		this.cantidadProductosIngresados = cantidadProductosIngresados;
		this.categoriaProductos = categoriaProductos;
	}

public int getId() {return id;}

public void setId(int id) {this.id = id;}

public String getNombreProveedor() {return nombreProveedor;}

public void setNombreProveedor(String nombreProveedor) {this.nombreProveedor = nombreProveedor;}

public String getEmpresa() {return empresa;}

public void setEmpresa(String empresa) {this.empresa = empresa;}

public String getTelefono() {return telefono;}

public void setTelefono(String telefono) {this.telefono = telefono;}

public int getCantidadProductosIngresados() {return cantidadProductosIngresados;}

public void setCantidadProductosIngresados(int cantidadProductosIngresados) {this.cantidadProductosIngresados = cantidadProductosIngresados;}

public int getCategoriaProductos() {return categoriaProductos;}

public void setCategoriaProductos(int categoriaProductos) {this.categoriaProductos = categoriaProductos;}
}