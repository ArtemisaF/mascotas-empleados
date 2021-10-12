package com.mascotas.empleados.controller;

import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.dto.MacotasDto;
import com.mascotas.empleados.dto.PropietariosDto;
import com.mascotas.empleados.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = "https://mascotas-3c0f1.web.app/", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
@RestController
public class PostController {

    @Autowired
    private PostManagementService service;

    @RequestMapping(value = "getEmpleados",method = RequestMethod.GET)
    public ResponseEntity getAll(){
        return new ResponseEntity(service.getAll(),HttpStatus.OK);
    }

    @RequestMapping(value = "getPropietarios",method = RequestMethod.GET)
    public ResponseEntity getAllP(){
        return new ResponseEntity(service.getAllP(),HttpStatus.OK);
    }

    @RequestMapping(value = "getMascotas",method = RequestMethod.GET)
    public ResponseEntity getAllM(){
        return new ResponseEntity(service.getAllM(),HttpStatus.OK);
    }

    @RequestMapping(value = "mascota/Byid/{id}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable(value = "id")String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity(service.getById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "propietario/ByidP/{id}",method = RequestMethod.GET)
    public ResponseEntity getByIdP(@PathVariable(value = "id")String id) throws ExecutionException, InterruptedException {
        return new ResponseEntity(service.getByIdP(id),HttpStatus.OK);
    }

    @RequestMapping(value = "propietario/ByOwner/{owner}",method = RequestMethod.GET)
    public ResponseEntity getByOwner(@PathVariable(value = "owner")String owner) throws ExecutionException, InterruptedException {
        return new ResponseEntity(service.getByOwner(owner),HttpStatus.OK);
    }

    @RequestMapping(value = "propietario/ByEmail/{email}",method = RequestMethod.GET)
    public ResponseEntity getByEmail(@PathVariable(value = "email")String email) throws ExecutionException, InterruptedException {
        return new ResponseEntity(service.getByEmail(email),HttpStatus.OK);
    }

    @RequestMapping(value = "empleado",method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.add(post), HttpStatus.OK);
    }

    @RequestMapping(value = "propietario",method = RequestMethod.POST)
    public ResponseEntity addP(@RequestBody PropietariosDto post){
        return new ResponseEntity(service.addP(post), HttpStatus.OK);
    }

    @RequestMapping(value = "mascota",method = RequestMethod.POST)
    public ResponseEntity addM(@RequestBody MacotasDto post){
        return new ResponseEntity(service.addM(post), HttpStatus.OK);
    }

    @RequestMapping(value = "empleado/{id}",method = RequestMethod.PUT)
    public ResponseEntity edit(@PathVariable(value = "id")String id,@RequestBody EmpleadosDto post){
        return new ResponseEntity(service.edit(id,post),HttpStatus.OK);
    }

    @RequestMapping(value = "propietario/{id}",method = RequestMethod.PUT)
    public ResponseEntity editP(@PathVariable(value = "id")String id,@RequestBody PropietariosDto post){
        return new ResponseEntity(service.editP(id,post),HttpStatus.OK);
    }

    @RequestMapping(value = "mascota/{id}",method = RequestMethod.PUT)
    public ResponseEntity editM(@PathVariable(value = "id")String id,@RequestBody MacotasDto post){
        return new ResponseEntity(service.editM(id,post),HttpStatus.OK);
    }

    @RequestMapping(value = "empleado/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.delete(id),HttpStatus.OK);
    }

    @RequestMapping(value = "propietario/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteP(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.deleteP(id),HttpStatus.OK);
    }

    @RequestMapping(value = "mascota/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteM(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.deleteM(id),HttpStatus.OK);
    }

    @RequestMapping(value = "mascota/trasporte/{id}",method = RequestMethod.PUT)
    public ResponseEntity actualizarTrasporte(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.actualizarTrasporte(id),HttpStatus.OK);
    }
    @RequestMapping(value = "mascota/fechaEntrada/{id}/{fecha}",method = RequestMethod.PUT)
    public ResponseEntity fechaEntrada(@PathVariable(value = "id")String id,@PathVariable(value = "fecha")String fecha){
        return new ResponseEntity(service.fechaEntrada(id,fecha),HttpStatus.OK);
    }
    @RequestMapping(value = "mascota/fechaRecogida/{id}/{fecha}",method = RequestMethod.PUT)
    public ResponseEntity fechaRecogida(@PathVariable(value = "id")String id,@PathVariable(value = "fecha")String fecha){
        return new ResponseEntity(service.fechaRecogida(id,fecha),HttpStatus.OK);
    }
}
