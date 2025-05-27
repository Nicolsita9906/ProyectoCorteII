package com.example.Proyecto.apis;

import java.util.List;

import com.example.Proyecto.modelos.Empleado;

import retrofit2.Call;
import retrofit2.http.*;

public interface EmpleadoApi {

    String BASE_URL = "http://localhost:8080/Supermercado";

    @GET("empleados")
    Call<List<Empleado>> listarEmpleados();

    @GET("empleados/{codigo}")
    Call<Empleado> buscarEmpleado(@Path("codigo") String codigo);

    @POST("empleados")
    Call<Void> agregarEmpleado(@Body Empleado empleado);

    @PUT("empleados/{codigo}")
    Call<Void> modificarEmpleado(@Path("codigo") String codigo, @Body Empleado empleado);

    @DELETE("empleados/{codigo}")
    Call<Void> eliminarEmpleado(@Path("codigo") String codigo);
}
