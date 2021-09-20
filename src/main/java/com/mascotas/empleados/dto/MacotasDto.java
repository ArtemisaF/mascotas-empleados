package com.mascotas.empleados.dto;

import lombok.Data;

@Data
public class MacotasDto {

    private String id;
    private String cuidados;
    private String edad;
    private String name;
    private String owner;
    private String raza;
    private String tamaño;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCuidados() {
        return cuidados;
    }

    public String getEdad() {
        return edad;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getRaza() {
        return raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
}
