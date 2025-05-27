package com.example.Proyecto.repository;

import java.util.ArrayList;
import java.util.List;
import com.example.Proyecto.modelos.Empleado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmpleadoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Empleado agregarEmpleado(Empleado empleado) {
        entityManager.persist(empleado);
        return empleado;
    }

    @Transactional
    public Empleado buscarEmpleado(int codigo) {
        Empleado empleado = entityManager.find(Empleado.class, codigo);
        return empleado;
    }

    @Transactional
    public void eliminarEmpleado(int codigo) {
        entityManager.remove(entityManager.find(Empleado.class, codigo));

    }

    @Transactional
    public void modificarEmpleado(int codigo, Empleado empleado) {
    	Query query = entityManager.createQuery("UPDATE Empleado e SET e.nombre = :nombre, e.Tipo_Documento: Tipo_Documento, e.NoDocumento: NoDocumento, e.Fecha_Ingreso: Fecha_Ingreso  WHERE e.codigo = :codigo");
        query.setParameter("Nombre", empleado.getNombreEmpleado());
        query.setParameter("Tipo_Documento", empleado.getTipoDocumento());
        query.setParameter("NoDocumento", empleado.getNumeroDocuemento());
        query.setParameter("Fecha_Ingreso", empleado.getFechaIngreso());
        query.executeUpdate();
       
    }
     
    @Transactional
    public List <Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        empleados = entityManager.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
        return empleados;
    }
}