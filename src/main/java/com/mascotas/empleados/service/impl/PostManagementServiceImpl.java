package com.mascotas.empleados.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.dto.MacotasDto;
import com.mascotas.empleados.dto.PropietariosDto;
import com.mascotas.empleados.firebase.FirebaseInitializer;
import com.mascotas.empleados.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;


@Service
public class PostManagementServiceImpl implements PostManagementService {

    @Autowired
    private FirebaseInitializer firebase;
    @Override
    public Boolean add(EmpleadosDto post) {
        Map<String, Object> docData = getDocData(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollection().document().create(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    @Override
    public List<EmpleadosDto> getAll() {
        List<EmpleadosDto> response= new ArrayList<>();
        EmpleadosDto post;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture= getCollection().get();
        try {
            for (DocumentSnapshot doc: querySnapshotApiFuture.get().getDocuments()) {
                post = doc.toObject(EmpleadosDto.class);
                post.setId(doc.getId());
                response.add(post);
            }
            return  response;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public Boolean edit(String id, EmpleadosDto post) {
        Map<String, Object> docData = getDocData(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollection().document(id).set(docData);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture= getCollection().document(id).delete();
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean addM(MacotasDto post) {
        Map<String, Object> docData = getDocDataM(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document().create(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public List<MacotasDto> getAllM() {
        List<MacotasDto> response= new ArrayList<>();
        MacotasDto post;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture= getCollectionM().get();
        try {
            for (DocumentSnapshot doc: querySnapshotApiFuture.get().getDocuments()) {
                post = doc.toObject(MacotasDto.class);
                post.setId(doc.getId());
                response.add(post);
            }
            return  response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean editM(String id, MacotasDto post) {
        Map<String, Object> docData = getDocDataM(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document(id).set(docData);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean deleteM(String id) {
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document(id).delete();
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean actualizarTrasporte(String id){
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document(id).update("Trasporte","Agendado");
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    @Override
    public Boolean fechaEntrada(String id,String fecha){
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document(id).update("HoradeEntrega",fecha);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean fechaRecogida(String id,String fecha){
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionM().document(id).update("HoradeRecogida",fecha);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    @Override
    public MacotasDto getById(String id)  {
        DocumentReference doc= getCollectionM().document(id);
        ApiFuture<DocumentSnapshot> future = doc.get();
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                MacotasDto res = document.toObject(MacotasDto.class);
                res.setId(document.getId());
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public Boolean addP(PropietariosDto post) {
        Map<String, Object> docData = getDocDataP(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionP().document().create(docData);

        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    @Override
    public List<PropietariosDto> getAllP() {
        List<PropietariosDto> response= new ArrayList<>();
        PropietariosDto post;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture= getCollectionP().get();
        try {
            for (DocumentSnapshot doc: querySnapshotApiFuture.get().getDocuments()) {
                post = doc.toObject(PropietariosDto.class);
                post.setId(doc.getId());
                response.add(post);
            }
            return  response;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public Boolean editP(String id, PropietariosDto post) {
        Map<String, Object> docData = getDocDataP(post);
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionP().document(id).set(docData);
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }

    }

    @Override
    public Boolean deleteP(String id) {
        ApiFuture<WriteResult> writeResultApiFuture= getCollectionP().document(id).delete();
        try {
            if (null != writeResultApiFuture.get()) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public PropietariosDto getByIdP(String id)  {
        DocumentReference doc= getCollectionP().document(id);
        ApiFuture<DocumentSnapshot> future = doc.get();
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                PropietariosDto res = document.toObject(PropietariosDto.class);
                res.setId(document.getId());
                return res;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public MacotasDto getByOwner(String owner)  {
        CollectionReference cities =getCollectionM();
        Query query = cities.whereEqualTo("owner", owner);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        MacotasDto res = null;

        try {
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                res = document.toObject(MacotasDto.class);
                return res;

            }
            return res;
        } catch (Exception e) {
            return null;
        }


    }
    public String getByEmail(String email) throws ExecutionException, InterruptedException {
        CollectionReference cities =getCollectionP();
        Query query = cities.whereEqualTo("email", email);
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        PropietariosDto res = null;

        try {
            for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
                res = document.toObject(PropietariosDto.class);
                
            }
            return res.getEmail();
        } catch (Exception e) {
            return "nosirvo";
        }
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("Empleados");
    }
    private Map<String, Object> getDocData(EmpleadosDto post) {
        Map<String,Object> docData= new HashMap<>();
        docData.put("cc", post.getCc());
        docData.put("creador", post.getCreador());
        docData.put("direccion", post.getDireccion());
        docData.put("email", post.getEmail());
        docData.put("fechaDeActulizacion", post.getFechaDeActualizacion());
        docData.put("fechaDeCreacion", post.getFechaDeCreacion());
        docData.put("nombre", post.getNombre());
        docData.put("rol", post.getRol());
        return docData;
    }
    private CollectionReference getCollectionM() {
        return firebase.getFirestore().collection("Mascotas");
    }
    private Map<String, Object> getDocDataM(MacotasDto post) {
        Map<String,Object> docData= new HashMap<>();
        docData.put("tamaño",post.getTamaño());
        docData.put("raza",post.getRaza());
        docData.put("owner",post.getOwner());
        docData.put("name",post.getName());
        docData.put("edad",post.getEdad());
        docData.put("cuidados",post.getCuidados());
        return docData;
    }
    private CollectionReference getCollectionP() {
        return firebase.getFirestore().collection("Propietarios");
    }
    private Map<String, Object> getDocDataP(PropietariosDto post) {
        Map<String,Object> docData= new HashMap<>();
        docData.put("cc",post.getCc());
        docData.put("celular",post.getCelular());
        docData.put("direccion",post.getDireccion());
        docData.put("name",post.getName());
        docData.put("email",post.getEmail());
        return docData;
    }
}
