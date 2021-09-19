package com.mascotas.empleados.dto;

import lombok.Data;

@Data
public class EmpleadosDto {

    private String id;
    private String cc;
    private String creador;
    private String direccion;
    private String email;
    private String fechaDeActualizacion;
    private String fechaDeCreacion;
    private String nombre;
    private String rol;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCc() {
        return cc;
    }

    public String getCreador() {
        return creador;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaDeActualizacion() {
        return fechaDeActualizacion;
    }

    public String getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaDeActualizacion(String fechaDeActualizacion) {
        this.fechaDeActualizacion = fechaDeActualizacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
