package repository;
import java.util.ArrayList;
import excepciones.*;
import vistas.*;
import modelos.Proveedores;
public class ProveedoresRepository {
    ArrayList<Proveedores> proveedores = new ArrayList<>();
    CodigoExistente codigoExistente = new CodigoExistente ();
    FuncionExitosa exito = new FuncionExitosa ();
    NoEncontrado noEncontrado = new NoEncontrado ();
    
    public ProveedoresRepository(ArrayList<Proveedores> proveedores) {
		this.proveedores = proveedores;
	}

	public void agregarProveedor(Proveedores proveedor){
        for(Proveedores x : proveedores){
            if(x.getCodigo().equals(proveedor.getCodigo())){
            	try {
                    throw new CodigoExistentee(codigoExistente);
                } catch (CodigoExistentee e) {
               	 codigoExistente.setVisible(true);
                }
                return;  
            }
        }
        proveedores.add(proveedor);
        try {
            throw new NotificarExito(exito);
        } catch (NotificarExito e) {
            exito.setVisible(true);
        }  
    }
    
    public void eliminarProveedor(String codigo){
        for (Proveedores proveedor : proveedores){
            if(proveedor.getCodigo().equals(codigo)){
                proveedores.remove(proveedor);
                try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                return;  
            }
        }
        try {
            throw new NotificarExito(exito);
        } catch (NotificarExito e) {
            exito.setVisible(true);
        }
    }
    
    public Proveedores buscarProveedres(String codigo){
        
        for(Proveedores proveedor : proveedores){
        	if (proveedor.getCodigo().equals(codigo)) {
            	try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                
                return proveedor;
            }
        }
        try {
            throw new CodigoNoEncontrado(noEncontrado);
        } catch (CodigoNoEncontrado e) {
        	noEncontrado.setVisible(true);
        }
            return null;
    }
    
    public void modificarProveedor(String codigo, Proveedores proveedor){
        boolean encontrado = false;
        for (Proveedores x : proveedores){
            if(x.getCodigo().equals(codigo)){
                x.setNombreProveedor(proveedor.getNombreProveedor());
                x.setCodigo(proveedor.getCodigo());
                x.setEmpresa(proveedor.getEmpresa());
                x.setTelefono(proveedor.getTelefono());
                x.setCantidadProductosIngresados(proveedor.getCantidadProductosIngresados());
                x.setCategoriaProductos(proveedor.getCategoriaProductos());
                try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                encontrado = true;
                break;  
            }
        }
        if (!encontrado) {
        	try {
                throw new CodigoNoEncontrado(noEncontrado);
            } catch (CodigoNoEncontrado e) {
            	noEncontrado.setVisible(true);
            }
        }
    }
    
    public ArrayList <Proveedores> listarProveedores(){
      return proveedores;
    }
}