package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelos.*;
import excepciones.MenorEdad;
public class EmpleadoRepository {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) {
        for (Empleado emp : empleados) {
            if (emp.getCodigo().equals(empleado.getCodigo()) || emp.getNumeroDocuemento().equals(empleado.getNumeroDocuemento())) {
                        System.out.println("El codigo o la identificación ya existe en el sistema");
                return; 
            }
        }
        if(empleado.getTipoDocumento() == TipoDeDocumento.TI) {
        	
        }
        empleados.add(empleado);
        System.out.println("Empleado agregado con éxito" + empleado);
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

    public void modificarEmpleado(String codigo, Empleado empleado) {
        boolean encontrado = false;
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                x.setNombreEmpleado(empleado.getNombreEmpleado());
                x.setCodigo(empleado.getCodigo());
                x.setNumeroDocuemento(empleado.getNumeroDocuemento());
                x.setFechaIngreso(empleado.getFechaIngreso());
                x.setTipoDocumento(empleado.getTipoDocumento());
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
                System.out.println(x);
            }
        }
    }
}