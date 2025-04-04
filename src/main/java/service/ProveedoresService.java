package service;
import modelos.Proveedores;
import repository.ProveedoresRepository;
public class ProveedoresService {

	private ProveedoresRepository servicio = new ProveedoresRepository ();
	
	 public void agregarProveedor(Proveedores proveedor) {
		 servicio.agregarProveedor(proveedor);
	 }
	 
	 public void eliminarProveedor(String codigo) {
		 servicio.eliminarProveedor(codigo);
	 }
	 
	 public void buscarProveedres(String codigo) {
		 servicio.buscarProveedres(codigo);
	 }
	 
	 public void modificarProveedor(String codigo, Proveedores proveedor) {
		 servicio.modificarProveedor(codigo, proveedor);
	 }
	 
	 public void listarProveedores() {
		 servicio.listarProveedores();
	 }
}
