package com.example.Proyecto.repository;
import java.util.ArrayList;
import com.example.Proyecto.modelos.Proveedores;
import java.util.List;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProveedoresRepository {

    @PersistenceContext
    EntityManager entityManager;

	public Proveedores agregarProveedor(Proveedores proveedor) {
       entityManager.persist(proveedor);
       return proveedor;
    }
    
    @Transactional
    public void eliminarProveedor(int codigo){
        entityManager.remove(entityManager.find(Proveedores.class, codigo));
    }
    
   @Transactional
    public Proveedores buscarProveedres(int codigo){
        Proveedores proveedor = entityManager.find(Proveedores.class, codigo);
        return proveedor;
    }
    
    @Transactional
     public Proveedores modificarProveedor(int codigo, Proveedores proveedor){
        Query query = entityManager.createQuery("UPDATE Proveedores p SET p.Nombre: Nombre, p.Empresa: Empresa, p.Cantidad: Cantidad, p.Categoria: Categoria WHERE p.codigo = :codigo");
        query.setParameter("Nombre", proveedor.getNombreProveedor());
        query.setParameter("Telefono", proveedor.getTelefono());
        query.setParameter("Empresa", proveedor.getEmpresa());
        query.setParameter("Cantidad", proveedor.getCantidadProductosIngresados());
        query.setParameter("Categoria", proveedor.getCategoriaProductos());
        query.executeUpdate();
        return proveedor;
       
    }

     @Transactional
    public List <Proveedores> listarProveedores(){
        List<Proveedores> proveedores = new ArrayList<>();
        proveedores = entityManager.createQuery("SELECT p FROM Proveedores p", Proveedores.class).getResultList();
        return proveedores;
    }
}