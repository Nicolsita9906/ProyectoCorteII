package repository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelos.*;
import excepciones.*;
import vistas.*;
public class EmpleadoRepository {
    private ArrayList<Empleado> empleados = new ArrayList<>();
    CodigoExistente codigoExistente = new CodigoExistente ();
    FuncionExitosa exito = new FuncionExitosa ();
    NoEncontrado noEncontrado = new NoEncontrado ();

    public Empleado agregarEmpleado(Empleado empleado) {
        for (Empleado x : empleados) {
        	if (x.getCodigo().equals(empleado.getCodigo())) {
        		 try {
                     throw new CodigoExistentee(codigoExistente);
                 } catch (CodigoExistentee e) {
                	 codigoExistente.setVisible(true);
                 }
        	}
        }
        empleados.add(empleado);
        try {
            throw new NotificarExito(exito);
        } catch (NotificarExito e) {
            exito.setVisible(true);
        }
		return empleado;
		
        
    }

    public Empleado buscarEmpleado(String codigo) {
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
              return x; // si lo encuentra, lo retorna
            }
        }
        return null; // si no encuentra ninguno, retorna null
    }

    public void eliminarEmpleado(String codigo) {
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                empleados.remove(x);
                try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                };
                return; 
            }
        }
        try {
            throw new CodigoNoEncontrado(noEncontrado);
        } catch (CodigoNoEncontrado e) {
        	noEncontrado.setVisible(true);
        }
    }

    public void modificarEmpleado(String codigo, Empleado empleado) {
    	boolean encontrado = false;
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
                x.setNombreEmpleado(empleado.getNombreEmpleado());
                x.setTipoDocumento(empleado.getTipoDocumento());
                x.setNumeroDocuemento(empleado.getNumeroDocuemento());
                x.setFechaIngreso(empleado.getFechaIngreso());
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
     
    public ArrayList <Empleado> listarEmpleados() {
       return empleados;
    }
}