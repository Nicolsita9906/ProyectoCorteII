package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelos.*;

public class EmpleadoRepository {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(String nombreEmpleado, TipoDeDocumento tipoDocumento, String numeroDocuemento, LocalDate fechaIngreso) {
        for (Empleado empleado : empleados) {
            if (empleado.getNumeroDocuemento().equals(numeroDocuemento)) {
                        System.out.println("La identificación ya existe en el sistema");
                return; 
            }
        }
        
        Empleado emp = new Empleado(nombreEmpleado, tipoDocumento, numeroDocuemento, fechaIngreso);
        empleados.add(emp);
        System.out.println("Empleado agregado con éxito");
    }

    public Empleado buscarEmpleado(String codigo) {
        boolean encontrado = false;
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                System.out.println("Empleado encontrado: " + x.toString());
                encontrado = true;
                return x;
            }
        }
       
            System.out.println("El código no existe en el sistema");
            return null;
    }

    public void eliminarEmpleado(String codigo) {
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                empleados.remove(x);
                System.out.println("Empleado eliminado");
                return; 
            }
        }
        System.out.println("El código no existe en el sistema");
    }

    public void modificarEmpleado(String codigo, String newName, String newCode, String newNumber, LocalDate newDate) {
        boolean encontrado = false;
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                x.setNombreEmpleado(newName);
                x.setCodigo(newCode);
                x.setNumeroDocuemento(newNumber);
                x.setFechaIngreso(newDate);
                System.out.println("Empleado modificado: " + x.toString());
                encontrado = true;
                break; 
            }
        }
        if (!encontrado) {
            System.out.println("El código no existe en el sistema");
        }
    }

    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en el sistema");
        } else {
            for (Empleado x : empleados) {
                System.out.println(x.toString());
            }
        }
    }
}