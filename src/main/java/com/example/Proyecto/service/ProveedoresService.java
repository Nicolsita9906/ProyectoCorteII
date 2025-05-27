package com.example.Proyecto.service;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.Proyecto.modelos.Categoria;
import com.example.Proyecto.modelos.Proveedores;
import com.example.Proyecto.repository.ProveedoresRepository;
import com.example.Proyecto.repository.EmpleadoRepository;

@Service
public class ProveedoresService {

	private ProveedoresRepository servicio;
	
	 public ProveedoresService(ProveedoresRepository servicio) {
		this.servicio = servicio;
	}
	 
	 
	public Proveedores agregarProveedor(Proveedores proveedor) {
		return servicio.agregarProveedor(proveedor);
	 }
	 
	 public void eliminarProveedor(int codigo) {
		 servicio.eliminarProveedor(codigo);
	 }
	 
	 public Proveedores buscarProveedres(int codigo) {
		return servicio.buscarProveedres(codigo);
	 }
	 
	 public void modificarProveedor(int codigo, Proveedores proveedor) {
		 servicio.modificarProveedor(codigo, proveedor);
	 }
	 
	 public List <Proveedores> listarProveedores() {
		 return servicio.listarProveedores();
	 }
}
