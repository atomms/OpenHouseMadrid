package com.example.miguel.openhousemadrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MAngelN on 22/04/2016.
 */
public class VistaGeneralEdificios extends Activity {

    GridView gv;
    SearchView sv;
    ArrayList<Edificio>edificios;
    int[]images={R.drawable.edificio1,R.drawable.edificio2,R.drawable.edificio3,R.drawable.edificio4,R.drawable.edificio5,R.drawable.edificio1};


    String[]names;
    String [] descrip;
    String [] horarios;
    String [] direccion;
    String [] comoLlegar;
    String [] tipoEdif;
    String [] anoConst;
    String [] minus;
    String [] inscripcion;
    String [] web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_general_edificios);
        names=getResources().getStringArray(R.array.nombreEdificios);
        descrip = getResources().getStringArray(R.array.descripcionEdif);
        horarios = getResources().getStringArray(R.array.horarioEdificios);
        direccion = getResources().getStringArray(R.array.direccionEdificios);
        comoLlegar = getResources().getStringArray(R.array.comollegarEdificios);
        tipoEdif = getResources().getStringArray(R.array.tipoEdificios);
        anoConst = getResources().getStringArray(R.array.anoconstruccionEdificios);
        minus = getResources().getStringArray(R.array.minusEdificios);
        inscripcion = getResources().getStringArray(R.array.inscripcionEdificios);
        web = getResources().getStringArray(R.array.webEdificios);

        gv= (GridView) findViewById(R.id.gridViewGeneral);
        sv= (SearchView) findViewById(R.id.searchView1);

        //ADAPTADOR
        final Adapter adapter = new Adapter(this, this.getEdificios());
        gv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter();
                return false;
            }
        });


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Edificio item = (Edificio) parent.getItemAtPosition(position);
                String str = item.getNombre();

                Intent intent = new Intent(VistaGeneralEdificios.this, ActividadDetalle.class);
                intent.putExtra("Objeto", item);
                startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(), str + "  ", Toast.LENGTH_SHORT);
                toast.show();


            }
        });
    }
    private ArrayList <Edificio> getEdificios(){
        ArrayList<Edificio>edificios = new ArrayList<Edificio>();
        Edificio e;

        for (int i=0;i<names.length;i++){

            e=new Edificio(names[i], images[i],descrip[i],horarios[i], direccion[i],comoLlegar[i], tipoEdif[i],
                    anoConst[i], minus[i], inscripcion[i], web[i]);
            edificios.add(e);
        }
        return edificios;
    }





}
