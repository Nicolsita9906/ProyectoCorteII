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

    public void agregarEmpleado(Empleado empleado) {
        for (Empleado emp : empleados) {
            if (emp.getCodigo().equals(empleado.getCodigo()) || emp.getNumeroDocuemento().equals(empleado.getNumeroDocuemento())) {
            	try {
                    throw new CodigoExistentee(codigoExistente);
                } catch (CodigoExistentee e) {
               	 codigoExistente.setVisible(true);
                }
                return; 
            }else {
            	try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
            	empleados.add(empleado);
            	
            }
        }
    }

    public Empleado buscarEmpleado(String codigo) {
        boolean encontrado = false;
        for (Empleado x : empleados) {
            if (x.getCodigo().equals(codigo)) {
            	try {
                    throw new NotificarExito(exito);
                } catch (NotificarExito e) {
                    exito.setVisible(true);
                }
                encontrado = true;
                return x;
            }
        }
       
        try {
            throw new CodigoNoEncontrado(noEncontrado);
        } catch (CodigoNoEncontrado e) {
        	noEncontrado.setVisible(true);
        }
            return null;
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
                x.setCodigo(empleado.getCodigo());
                x.setNumeroDocuemento(empleado.getNumeroDocuemento());
                x.setFechaIngreso(empleado.getFechaIngreso());
                x.setTipoDocumento(empleado.getTipoDocumento());
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