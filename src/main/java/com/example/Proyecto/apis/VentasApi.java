package com.example.Proyecto.apis;

import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

import com.example.Proyecto.modelos.Venta;

public interface VentasApi {
	String BASE_URL = "http://localhost:8080/Supermercado";

    @GET("ventas")
    Call<List<Venta>> mostrarVentas();

    @POST("ventas")
    Call<Void> crearVenta(@Body Venta venta);
}
