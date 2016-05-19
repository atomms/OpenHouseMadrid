package com.example.miguel.openhousemadrid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import java.util.ArrayList;

public class VistaGeneralEdificiosFAV extends AppCompatActivity {

    GridView gv;
    SearchView sv;
    ArrayList<Edificio> edificios;
    String favSiNo;
    SharedPreferences preferencias;

    int[]id;
    String[]images;
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
        setContentView(R.layout.activity_vista_general_edificios_fav);
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

        gv= (GridView) findViewById(R.id.gridViewGeneralFAV);

        //ADAPTADOR
        /*final Adapter adapter = new Adapter(this, this.getEdificios());
        gv.setAdapter(adapter);*/



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Edificio item = (Edificio) parent.getItemAtPosition(position);
                String str = item.getNombre();

                Intent intent = new Intent(VistaGeneralEdificiosFAV.this, ActividadDetalle.class);
                intent.putExtra("Objeto", item);
                startActivity(intent);
            }
        });
    }
    /*private ArrayList <Edificio> getEdificios(){
        ArrayList<Edificio>edificios = new ArrayList<Edificio>();
        Edificio e;
        for (int i=0;i<names.length;i++){

            e=new Edificio(id[i], names[i], images[i],descrip[i],horarios[i], direccion[i],comoLlegar[i], tipoEdif[i],
                    anoConst[i], minus[i], inscripcion[i], web[i]);
            preferencias = getSharedPreferences("Favoritos", Context.MODE_PRIVATE);

            String nome = names[i];
            favSiNo = preferencias.getString(nome,"N");

            if (favSiNo.equals("S")) {
                edificios.add(e);
            }
        }
        return edificios;
    }*/



}
