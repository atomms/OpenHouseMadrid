package com.example.miguel.openhousemadrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Santos on 22/04/2016.
 */
public class VistaGeneralEdificios extends Activity {

    GridView gv;
    SearchView sv;
    ArrayList <Edificio> edificios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_general_edificios);


        gv= (GridView) findViewById(R.id.gridViewGeneral);
        sv= (SearchView) findViewById(R.id.searchView1);


        //ADAPTADOR
        final Adapter adapter = new Adapter(this, this.descargarEdificios());
        gv.setAdapter(adapter);


        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Edificio item = (Edificio) parent.getItemAtPosition(position);
                Intent intent = new Intent(VistaGeneralEdificios.this, ActividadDetalle.class);
                intent.putExtra("Objeto", item);
                startActivity(intent);
            }
        });
    }

    private ArrayList <Edificio> descargarEdificios() {

        Firebase ref = new Firebase("https://glaring-torch-2531.firebaseio.com/edificio");
        edificios = new ArrayList<Edificio>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Edificio post = postSnapshot.getValue(Edificio.class);
                    edificios.add(post);
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("La base de datos no está disponible: " + firebaseError.getMessage());
            }
        });
        return edificios;
    }











    /*private ArrayList <Edificio> getEdificios(){
        ArrayList<Edificio>edificios = new ArrayList<Edificio>();
        Edificio e;
        for (int i=0;i<names.length;i++){
            e=new Edificio(id[i],names[i], images[i],descrip[i],horarios[i], direccion[i],comoLlegar[i], tipoEdif[i],
                    anoConst[i], minus[i], inscripcion[i], web[i]);
            edificios.add(e);
        }
        return edificios;
    }*/





}
