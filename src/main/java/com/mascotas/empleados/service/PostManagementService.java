package com.mascotas.empleados.service;

import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.dto.MacotasDto;

import java.util.List;

public interface PostManagementService {
    Boolean add(EmpleadosDto post);
    List<EmpleadosDto> getAll();
    Boolean edit(String id, EmpleadosDto post);
    Boolean delete(String id);

    Boolean addM(MacotasDto post);
    List<MacotasDto> getAllM();
    Boolean editM(String id, MacotasDto post);
    Boolean deleteM(String id);
    Boolean actualizarTrasporte(String id);

}
