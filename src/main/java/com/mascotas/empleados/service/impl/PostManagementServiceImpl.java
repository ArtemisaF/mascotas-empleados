package com.mascotas.empleados.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.mascotas.empleados.dto.EmpleadosDto;
import com.mascotas.empleados.firebase.FirebaseInitializer;
import com.mascotas.empleados.service.PostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
}
