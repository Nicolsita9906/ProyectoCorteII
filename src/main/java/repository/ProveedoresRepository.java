package repository;
import java.util.ArrayList;

import modelos.Categoria;
import modelos.Proveedores;
public class ProveedoresRepository {
    ArrayList<Proveedores> proveedores = new ArrayList<>();
    public void agregarProveedor(Proveedores proveedor){
        for(Proveedores x : proveedores){
            if(x.getCodigo().equals(proveedor.getCodigo())){
                System.out.println("El código ya existe en el sistema");
                return;  
            }
        }
        proveedores.add(proveedor);
        System.out.println("Proveedor agregado con éxito" + proveedor);
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