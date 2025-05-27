package com.example.Proyecto.apis;

import java.util.List;

import com.example.Proyecto.modelos.Productos;

import retrofit2.Call;
import retrofit2.http.*;

public interface ProductoApi {

    String BASE_URL = "http://localhost:8080/Supermercado";

    @GET("productos")
    Call<List<Productos>> mostrarProductos();

    @GET("productos/{codigo}")
    Call<Productos> buscarProducto(@Path("codigo") String codigo);

    @POST("productos")
    Call<Productos> agregarProducto(@Body Productos producto);

    @PUT("productos/{codigo}")
    Call<Void> modificarProducto(@Path("codigo") String codigo, @Body Productos producto);

    @DELETE("productos/{codigo}")
    Call<Void> eliminarProducto(@Path("codigo") String codigo);
}
