package com.mascotas.empleados.service;

import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.dto.MacotasDto;
import com.mascotas.empleados.dto.PropietariosDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
    Boolean fechaEntrada(String id,String fecha);
    Boolean fechaRecogida(String id,String fecha);
    MacotasDto getById(String id) throws ExecutionException, InterruptedException;

    Boolean addP(PropietariosDto post);
    List<PropietariosDto> getAllP();
    Boolean editP(String id, PropietariosDto post);
    Boolean deleteP(String id);
    PropietariosDto getByIdP(String id);
}
