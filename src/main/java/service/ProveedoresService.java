package service;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Proveedores;
import repository.ProveedoresRepository;
import repository.ProveedoresRepository;
public class ProveedoresService {

	private ProveedoresRepository servicio;
	
	 public ProveedoresService(ProveedoresRepository servicio) {
		this.servicio = servicio;
		datosMuertos();	
	}

	 public void datosMuertos () {
		 agregarProveedor(new Proveedores("Juan Castillo", "Distribuidora Central", "3214567890", 120, Categoria.HOGAR));
		 agregarProveedor(new Proveedores("Marta López", "Aseo Total S.A.", "3001234567", 200, Categoria.ASEO));
		 agregarProveedor(new Proveedores("Carlos Pérez", "Ropa Elegante", "3109876543", 90, Categoria.ROPA));
		 agregarProveedor(new Proveedores("Lucía Torres", "Mundo Juguetes", "3123456789", 150, Categoria.JUGUETERIA));
		 agregarProveedor(new Proveedores("Andrés Ramírez", "Alimentos y Más", "3136547890", 300, Categoria.COMESTIBLES));
		 
	 }
	 
	 
	public Proveedores agregarProveedor(Proveedores proveedor) {
		return servicio.agregarProveedor(proveedor);
	 }
	 
	 public void eliminarProveedor(String codigo) {
		 servicio.eliminarProveedor(codigo);
	 }
	 
	 public Proveedores buscarProveedres(String codigo) {
		return servicio.buscarProveedres(codigo);
	 }
	 
	 public void modificarProveedor(String codigo, Proveedores proveedor) {
		 servicio.modificarProveedor(codigo, proveedor);
	 }
	 
	 public ArrayList <Proveedores> listarProveedores() {
		 return servicio.listarProveedores();
	 }
}
