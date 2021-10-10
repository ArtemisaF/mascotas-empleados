package com.mascotas.empleados.dto;
import lombok.Data;

@Data
public class PropietariosDto {
    private String id;
    private String cc;
    private String celular;
    private String direccion;
    private String email;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCc() {
        return cc;
    }

    public String getCelular() {
        return celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
