package com.example.Proyecto.modelos;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    
    @Column(name = "idEmpleado", nullable = false)
    private int idEmpleado;

    @Column(name = "idProducto", nullable = false)
    private int idProducto;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "total", nullable = false)
    private double total;

    public Venta() {}
    
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public LocalDateTime getFecha() {return fecha;}

    public void setFecha(LocalDateTime fecha) {this.fecha = fecha;}

    public int getIdEmpleado() {return idEmpleado;}

    public void setIdEmpleado(int idEmpleado) {this.idEmpleado = idEmpleado;}

    public int getIdProducto() {return idProducto;}

    public void setIdProducto(int idProducto) {this.idProducto = idProducto;}

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}

    public double getTotal() {return total;}

    public void setTotal(double total) {this.total = total;}
}
