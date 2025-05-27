package com.example.Proyecto.service;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.Proyecto.modelos.Empleado;
import com.example.Proyecto.modelos.Productos;
import com.example.Proyecto.modelos.Venta;
import com.example.Proyecto.repository.EmpleadoRepository;
import com.example.Proyecto.repository.ProductoRepository;
import com.example.Proyecto.repository.VentaRepository;
import com.example.Proyecto.repository.EmpleadoRepository;

@Service
public class VentaService {
    private VentaRepository servicio;


    public VentaService(VentaRepository servicio) {
        this.servicio = servicio;
    }



    public Venta agregarVenta (Venta venta) {
    	return servicio.agregarVenta(venta);
    }
 
    public List <Venta> mostrarVentas () {
    	return servicio.mostrarVentas();
    }
}
