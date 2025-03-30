package modelos;
import java.time.LocalDate;
import java.util.UUID;
import modelos.TipoDeDocumento;
public class Empleado {
private String nombreEmpleado;
private String codigo;
private TipoDeDocumento tipoDocumento;
private String numeroDocuemento;
private LocalDate fechaIngreso;
public Empleado (String codigo) {
	this.codigo = UUID.randomUUID().toString();
}
public Empleado(String nombreEmpleado, TipoDeDocumento tipoDocumento, String numeroDocuemento, LocalDate fechaIngreso) {
	this.codigo = UUID.randomUUID().toString();
	this.nombreEmpleado = nombreEmpleado;
	this.tipoDocumento = tipoDocumento;
	this.numeroDocuemento = numeroDocuemento;
	this.fechaIngreso = fechaIngreso;
}
public String getNombreEmpleado() {
	return nombreEmpleado;
}
public void setNombreEmpleado(String nombreEmpleado) {
	this.nombreEmpleado = nombreEmpleado;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) {
	this.codigo = codigo;
}
public TipoDeDocumento getTipoDocumento() {
	return tipoDocumento;
}
public void setTipoDocumento(TipoDeDocumento tipoDocumento) {
	this.tipoDocumento = tipoDocumento;
}
public String getNumeroDocuemento() {
	return numeroDocuemento;
}
public void setNumeroDocuemento(String numeroDocuemento) {
	this.numeroDocuemento = numeroDocuemento;
}
public LocalDate getFechaIngreso() {
	return fechaIngreso;
}
public void setFechaIngreso(LocalDate fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
}

}
