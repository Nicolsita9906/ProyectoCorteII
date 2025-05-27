package com.example.Proyecto.modelos;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "Nombre", nullable = false)
private String nombreEmpleado;

@Column(name = "Tipo_Documento", nullable = false)
private int tipoDocumento;

@Column(name = "NoDocumento", nullable = false)
private String numeroDocuemento;

 @Column(name = "Contraseñia", nullable = false)
private String contraseña;

@Column(name = "Fecha_Ingreso", nullable = false)
private LocalDateTime fechaIngreso;

public Empleado() {
	
}
public Empleado(String nombreEmpleado, int tipoDocumento, String numeroDocuemento, String contraseña, LocalDateTime fechaIngreso) {
    this.nombreEmpleado = nombreEmpleado;
    this.tipoDocumento = tipoDocumento;
    this.numeroDocuemento = numeroDocuemento;
    this.contraseña = contraseña;
    this.fechaIngreso = fechaIngreso;
}

public String getNombreEmpleado() {return nombreEmpleado;}

public void setNombreEmpleado(String nombreEmpleado) {this.nombreEmpleado = nombreEmpleado;}

public int getId() {return id;}

public void setId(int id) {this.id = id;}

public int getTipoDocumento() {return tipoDocumento;}

public void setTipoDocumento(int tipoDocumento) {this.tipoDocumento = tipoDocumento;}

public String getNumeroDocuemento() {return numeroDocuemento;}

public void setNumeroDocuemento(String numeroDocuemento) {this.numeroDocuemento = numeroDocuemento;}

public String getContraseña() {return contraseña;}

public void setContraseña(String contraseña) {this.contraseña = contraseña;}

public LocalDateTime getFechaIngreso() {return fechaIngreso;}

public void setFechaIngreso(LocalDateTime fechaIngreso) {this.fechaIngreso = fechaIngreso;}

}
