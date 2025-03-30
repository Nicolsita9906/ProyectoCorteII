package repository;
import java.util.ArrayList;

import modelos.Categoria;
import modelos.Proveedores;
public class ProveedoresRepository {
    ArrayList<Proveedores> proveedores = new ArrayList<>();
    public void agregarProveedor(String nombreProveedor, String empresa, String telefono, int cantidadProductosIngresados,
    		Categoria categoriaProductos){
        for(Proveedores proveedor : proveedores){
            if(proveedor.getCodigo().equals(nombreProveedor)){
                System.out.println("El código ya existe en el sistema");
                return;  
            }
        }
        Proveedores prov = new Proveedores(nombreProveedor, empresa, telefono, cantidadProductosIngresados, categoriaProductos);
        proveedores.add(prov);
        System.out.println("Proveedor agregado con éxito");
    }
    
    public void eliminarProveedor(String codigo){
        for (Proveedores proveedor : proveedores){
            if(proveedor.getCodigo().equals(codigo)){
                proveedores.remove(proveedor);
                System.out.println("Proveedor eliminado con éxito");
                return;  
            }
        }
        System.out.println("El código no existe en el sistema");
    }
    
    public void buscarProveedres(String codigo){
        boolean encontrado = false;
        for(Proveedores proveedor : proveedores){
            if(proveedor.getCodigo().equals(codigo)){
                System.out.println(proveedor.toString());
                encontrado = true;
                break;  
            }
        }
        if (!encontrado) {
            System.out.println("El código no existe en el sistema");
        }
    }
    
    public void modificarProveedor(String codigo, String newName, String newCode, String newEmpresa, String newTelefono, int newCantidad, Categoria newCategoria){
        boolean encontrado = false;
        for (Proveedores proveedor : proveedores){
            if(proveedor.getCodigo().equals(codigo)){
                proveedor.setNombreProveedor(newName);
                proveedor.setCodigo(newCode);
                proveedor.setEmpresa(newEmpresa);
                proveedor.setTelefono(newTelefono);
                proveedor.setCantidadProductosIngresados(newCantidad);
                proveedor.setCategoriaProductos(newCategoria);
                System.out.println("Proveedor modificado con éxito");
                encontrado = true;
                break;  
            }
        }
        if (!encontrado) {
            System.out.println("El código no existe en el sistema");
        }
    }
    
    public void listarProveedores(){
        if(proveedores.isEmpty()){
            System.out.println("No hay proveedores en el sistema");
        }else{
            for(Proveedores proveedor : proveedores){
                System.out.println(proveedor.toString());
            }  
        }
    }
}