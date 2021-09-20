package com.mascotas.empleados.controller;

import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class PostController {

    @Autowired
    private PostManagementService service;

    @RequestMapping(value = "getEmpleados",method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return new ResponseEntity(service.getAll(),HttpStatus.OK);
    }
    @RequestMapping(value = "empleado",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }
    @RequestMapping(value = "empleado/{id}",method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable(value = "id")String id,@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.edit(id,post),HttpStatus.OK);
    }
    @RequestMapping(value = "empleado/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.delete(id),HttpStatus.OK);
    }
}
