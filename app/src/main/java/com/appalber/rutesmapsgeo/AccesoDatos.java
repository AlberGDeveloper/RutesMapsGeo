package com.appalber.rutesmapsgeo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AccesoDatos {

    public static void subirPuntos(Rutas nombre) {
        FirebaseDatabase bbdd = FirebaseDatabase.getInstance("https://rutasfirebase-bab90-default-rtdb.firebaseio.com/");
        DatabaseReference referencia = bbdd.getReference("Rutas");
        referencia.child(nombre.getNombre()).setValue(nombre);
    }

    public static void recuperarPuntos(Comunicacion comunicacion){
        List<Rutas> rutas = new ArrayList<>();
        FirebaseDatabase bbdd = FirebaseDatabase.getInstance("https://rutasfirebase-bab90-default-rtdb.firebaseio.com/");
        DatabaseReference referencia = bbdd.getReference("Rutas");
        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> datos = snapshot.getChildren();
                for (DataSnapshot dat : datos ){
                    Rutas miRuta = dat.getValue(Rutas.class);
                    rutas.add(miRuta);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("ERROR" , error.getMessage());

            }
        });
    }

    public interface Comunicacion{
        //MapsActivity.recibeLista(List<Rutas> rutas);
        void envioRutaMain(List<Rutas> rutas);
    }
}
