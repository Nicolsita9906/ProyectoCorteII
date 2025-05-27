package com.example.Proyecto.apis;

import java.util.List;

import com.example.Proyecto.modelos.Proveedores;

import retrofit2.Call;
import retrofit2.http.*;

public interface ProveedorApi {

    String BASE_URL = "http://localhost:8080/Supermercado";

    @GET("proveedores")
    Call<List<Proveedores>> listarProveedores();

    @GET("proveedores/{codigo}")
    Call<Proveedores> buscarProveedor(@Path("codigo") String codigo);

    @POST("proveedores")
    Call<Proveedores> agregarProveedor(@Body Proveedores proveedor);

    @PUT("proveedores/{codigo}")
    Call<Void> modificarProveedor(@Path("codigo") String codigo, @Body Proveedores proveedor);

    @DELETE("proveedores/{codigo}")
    Call<Void> eliminarProveedor(@Path("codigo") String codigo);
}
