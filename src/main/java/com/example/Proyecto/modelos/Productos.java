package com.example.Proyecto.modelos;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "productos")
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Nombre", nullable = false)
	private String nombre;

	@Column(name = "Precio", nullable = false)
	private float precio;

	@Column(name = "Caducidad", nullable = false)
	private LocalDateTime caducidad;

	@Column(name = "Categoria", nullable = false)
	private int categoria;

	@Column(name = "Stock", nullable = false)
	private int stock;
    
    
	public Productos(String nombre, float precio, LocalDateTime caducidad, int categoria, int stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.caducidad = caducidad;
		this.categoria = categoria;
		this.stock = stock;
	}

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public float getPrecio() {return precio;}

	public void setPrecio(float precio) {this.precio = precio;}

	public LocalDateTime getCaducidad() {return caducidad;}

	public void setCaducidad(LocalDateTime caducidad) {this.caducidad = caducidad;}

	public int getCategoria() {return categoria;}

	public void setCategoria(int categoria) {this.categoria = categoria;}

	public int getStock() {return stock;}

	public void setStock(int stock) {this.stock = stock;}
  
}