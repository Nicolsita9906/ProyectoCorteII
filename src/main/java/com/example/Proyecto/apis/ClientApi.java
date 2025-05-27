package com.example.Proyecto.apis;

import com.example.Proyecto.modelos.Empleado;
import com.example.Proyecto.modelos.Productos;
import com.example.Proyecto.modelos.Proveedores;
import com.example.Proyecto.modelos.Venta;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientApi {
    private static final String BASE_URL = "http://localhost:8080/Supermercado/swagger-iu.html";
    private final ObjectMapper mapper = new ObjectMapper();

    // =============== PRODUCTOS ===============

    public List<Productos> getProductos() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        InputStream response = conn.getInputStream();
        return Arrays.asList(mapper.readValue(response, Productos[].class));
    }

    public Productos getProducto(String codigo) throws IOException {
        URL url = new URL(BASE_URL + "/" + codigo);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return mapper.readValue(conn.getInputStream(), Productos.class);
    }

    public void agregarProducto(Productos producto) throws IOException {
        postJson(BASE_URL, producto);
    }

    public void modificarProducto(String codigo, Productos producto) throws IOException {
        putJson(BASE_URL + "/" + codigo, producto);
    }

    public void eliminarProducto(String codigo) throws IOException {
        delete(BASE_URL + "/" + codigo);
    }

    // =============== EMPLEADOS ===============

    public List<Empleado> getEmpleados() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return Arrays.asList(mapper.readValue(conn.getInputStream(), Empleado[].class));
    }

    public Empleado getEmpleado(String codigo) throws IOException {
        URL url = new URL(BASE_URL + "/" + codigo);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return mapper.readValue(conn.getInputStream(), Empleado.class);
    }

    public void agregarEmpleado(Empleado emp) throws IOException {
        postJson(BASE_URL, emp);
    }

    public void modificarEmpleado(String codigo, Empleado emp) throws IOException {
        putJson(BASE_URL + "/" + codigo, emp);
    }

    public void eliminarEmpleado(String codigo) throws IOException {
        delete(BASE_URL + "/" + codigo);
    }

    // =============== PROVEEDORES ===============

    public List<Proveedores> getProveedores() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return Arrays.asList(mapper.readValue(conn.getInputStream(), Proveedores[].class));
    }

    public Proveedores getProveedor(String codigo) throws IOException {
        URL url = new URL(BASE_URL + "/" + codigo);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return mapper.readValue(conn.getInputStream(), Proveedores.class);
    }

    public void agregarProveedor(Proveedores p) throws IOException {
        postJson(BASE_URL, p);
    }

    public void modificarProveedor(String codigo, Proveedores p) throws IOException {
        putJson(BASE_URL + "/" + codigo, p);
    }

    public void eliminarProveedor(String codigo) throws IOException {
        delete(BASE_URL + "/" + codigo);
    }

    // =============== VENTAS ===============

    public List<Venta> getVentas() throws IOException {
        URL url = new URL(BASE_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        return Arrays.asList(mapper.readValue(conn.getInputStream(), Venta[].class));
    }

    public void agregarVenta(Venta venta) throws IOException {
        postJson(BASE_URL + "/vender", venta);
    }

    // =============== UTILIDADES ===============

    private void postJson(String urlString, Object body) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            mapper.writeValue(os, body);
        }

        if (conn.getResponseCode() >= 400) {
            throw new IOException("POST failed with status " + conn.getResponseCode());
        }
    }

    private void putJson(String urlString, Object body) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        try (OutputStream os = conn.getOutputStream()) {
            mapper.writeValue(os, body);
        }

        if (conn.getResponseCode() >= 400) {
            throw new IOException("PUT failed with status " + conn.getResponseCode());
        }
    }

    private void delete(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");

        if (conn.getResponseCode() >= 400) {
            throw new IOException("DELETE failed with status " + conn.getResponseCode());
        }
    }
}
