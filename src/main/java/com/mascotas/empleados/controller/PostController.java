package com.mascotas.empleados.controller;

import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostManagementService service;

    @GetMapping(value = "/getAll")
    public ResponseEntity getAll(){
        return new ResponseEntity(service.getAll(),HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity add(@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}/edit")
    public ResponseEntity edit(@PathVariable(value = "id")String id,@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.edit(id,post),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity delete(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.delete(id),HttpStatus.OK);
    }
}
