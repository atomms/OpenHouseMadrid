package com.example.miguel.openhousemadrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Santos on 22/04/2016.
 */

public class ActividadDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_detalle);

        //Declaracion de los elementos
        ImageView img = (ImageView)findViewById(R.id.imagen_extendida);
        TextView titulo = (TextView)findViewById(R.id.textViewNombre);
        TextView descripcion = (TextView)findViewById(R.id.textViewDescripcion);
        TextView horario = (TextView) findViewById(R.id.textViewHorarios);
        TextView direccion = (TextView) findViewById(R.id.textViewLugar);
        TextView comoLlegar = (TextView) findViewById(R.id.textViewMapa);
        TextView tipoEdif = (TextView) findViewById(R.id.textViewEdif);
        TextView construccion = (TextView) findViewById(R.id.textViewAnioConstr);
        TextView minus = (TextView) findViewById(R.id.textViewMinus);
        TextView inscrip = (TextView) findViewById(R.id.textViewInscripcion);
        TextView web = (TextView) findViewById(R.id.textViewPaginaWeb);

        //Importacion del objeto edificio que hemos pulsado
        Edificio edif = (Edificio)getIntent().getExtras().getSerializable("Objeto");

        img.setImageResource(edif.getImg());
        titulo.setText(edif.getNombre());
        descripcion.setText(edif.getDescripción());
        horario.setText(edif.getHorario());
        direccion.setText(edif.getDireccion());
        comoLlegar.setText(edif.getComoLlegar());
        tipoEdif.setText(edif.getTipoEdif());
        construccion.setText(edif.getConstruccion());
        minus.setText(edif.getMinus());
        inscrip.setText(edif.getInscrip());
        web.setText(edif.getWeb());

        //usarToolbar(edif.getNombre().toString());

    }
    private void usarToolbar(String str) {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // toolbar.setTitle(str);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.face);
    }



}
