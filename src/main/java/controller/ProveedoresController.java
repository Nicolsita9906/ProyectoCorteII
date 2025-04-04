package controller;
import modelos.Proveedores;
import service.ProveedoresService;
public class ProveedoresController {

	private ProveedoresService control = new ProveedoresService();

	public void agregarProveedores (Proveedores proveedores) {
		control.agregarProveedor(proveedores);
	}

	public void buscarProveedres (String codigo) {
		control.buscarProveedres(codigo);		
	}
    public void eliminarProveedor (String codigo) {
        control.eliminarProveedor(codigo);
    }
    public void modificarProveedor (String codigo, Proveedores proveedores) {
        control.modificarProveedor(codigo, proveedores);
    }
    public void listarProveedores () {
        control.listarProveedores();
    }
}
