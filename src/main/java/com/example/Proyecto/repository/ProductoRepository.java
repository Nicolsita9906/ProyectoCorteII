package com.example.Proyecto.repository;
import java.util.ArrayList;
import com.example.Proyecto.modelos.Productos;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Productos agregarProducto(Productos producto) {
        entityManager.persist(producto);
        return producto;
    }

    @Transactional
    public Productos buscarProducto(int codigo) {
        Productos producto = entityManager.find(Productos.class, codigo);
        return producto;
}


    @Transactional
    public void eliminarProducto(int codigo) {
        entityManager.remove(entityManager.find(Productos.class, codigo));
    }

    @Transactional
    public Productos modificarProducto(int codigo, Productos producto) {
        Query query = entityManager.createQuery("UPDATE Productos p SET p.nombre = :nombre, p.precio = :precio, p.stock = :stock, p.categoria = :categoria WHERE p.codigo = :codigo");
        query.setParameter("nombre", producto.getNombre());
        query.setParameter("precio", producto.getPrecio());
        query.setParameter("stock", producto.getStock());
        query.setParameter("categoria", producto.getCategoria());
        query.setParameter("codigo", codigo);
        query.executeUpdate();
        return producto;
    }

    @Transactional
    public void restarProductos(int cantidad, int codigo) {
        Query query = entityManager.createQuery("UPDATE Productos p SET p.stock = p.stock - :cantidad WHERE p.codigo = :codigo");
        query.setParameter("cantidad", cantidad);
        query.setParameter("codigo", codigo);
        query.executeUpdate();
    }

    @Transactional
    public double calcularTotalVenta(int codProd, int cantidad) {
        Query query = entityManager.createQuery("SELECT p.precio FROM Productos p WHERE p.codigo = :codigo");
        query.setParameter("codigo", codProd);
        double precio = (double) query.getSingleResult();
        double total = precio * cantidad;
        return total;
    }

    @Transactional
    public List<Productos> mostrarProductos() {
        List<Productos> productos = new ArrayList<>();
        productos = entityManager.createQuery("SELECT p FROM Productos p", Productos.class).getResultList();
        return productos;
    }

}