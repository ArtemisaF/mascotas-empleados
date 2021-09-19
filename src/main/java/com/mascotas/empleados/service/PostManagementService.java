package com.mascotas.empleados.service;

import com.mascotas.empleados.dto.EmpleadosDto;

import java.util.List;

public interface PostManagementService {
    Boolean add(EmpleadosDto post);
    List<EmpleadosDto> getAll();
    Boolean edit(String id, EmpleadosDto post);
    Boolean delete(String id);


}
