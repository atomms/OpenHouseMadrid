package com.example.miguel.openhousemadrid;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

/**
 * Created by Santos on 22/04/2016.
 */

public class ActividadDetalle extends AppCompatActivity {
    Edificio edif;
    String nomEdific;
    Button botonFav;
    String favSiNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_detalle);

        //Declaracion de los elementos
        ImageView img = (ImageView)findViewById(R.id.imagen_extendida);
        TextView titulo = (TextView)findViewById(R.id.textViewNombre);
        TextView descripcion = (TextView)findViewById(R.id.textViewDescripcion);
        TextView direccion = (TextView) findViewById(R.id.textViewLugar);
        TextView comoLlegar = (TextView) findViewById(R.id.textViewMapa);
        TextView tipoEdif = (TextView) findViewById(R.id.textViewEdif);
        TextView construccion = (TextView) findViewById(R.id.textViewAnioConstr);
        TextView minus = (TextView) findViewById(R.id.textViewMinus);
        TextView web = (TextView) findViewById(R.id.textViewPaginaWeb);
        botonFav = (Button) findViewById(R.id.buttonFAV);

        //Importacion del objeto edificio que hemos pulsado
        edif = (Edificio)getIntent().getExtras().getSerializable("Objeto");

        titulo.setText(edif.getNombre());
        descripcion.setText(edif.getDescripcion());
        direccion.setText(edif.getDireccion());
        comoLlegar.setText(edif.getComollegar());
        tipoEdif.setText(edif.getTipoedif());
        construccion.setText(edif.getConstruccion());
        minus.setText(edif.getMinus());
        web.setText(edif.getWeb());
        String rutaImagen = edif.getFotografia();
        Glide.with(getApplicationContext()).load(rutaImagen).into(img);


        cambiarBotonFavorito();
    }

    public void anadirFavorito(View view){
        nomEdific = edif.getNombre();
        SharedPreferences preferencias=getSharedPreferences("Favoritos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        favSiNo = preferencias.getString(nomEdific,"N");

        if (favSiNo.equals("N")){
            editor.remove(nomEdific);
            editor.putString(nomEdific,"S");
            editor.commit();
            Toast toast1 = Toast.makeText(getApplicationContext(), nomEdific+" añadido a favoritos", Toast.LENGTH_SHORT);
            toast1.show();
            botonFav.setText("QUITAR DE FAVORITOS");
            cambiarBotonFavorito();
        }
        else if (favSiNo.equals("S")){
            editor.remove(nomEdific);
            editor.putString(nomEdific,"N");
            editor.commit();
            Toast toast1 = Toast.makeText(getApplicationContext(), nomEdific+" eliminado de favoritos", Toast.LENGTH_SHORT);
            toast1.show();
            botonFav.setText("AÑADIR A FAVORITOS");
            cambiarBotonFavorito();
        }
    }

    public void cambiarBotonFavorito(){
        // cambiamos el contenido del botón en funcion de si ya es favorito o no el edificio

        SharedPreferences preferencias = getSharedPreferences("Favoritos", Context.MODE_PRIVATE);

        nomEdific = edif.getNombre();
        //Preguntamos si es favorito o no
        favSiNo = preferencias.getString(nomEdific,"N");
        //Si no es favorito...
        if (favSiNo.equals("N")){
            botonFav.setText("AÑADIR A FAVORITOS");
        }
        //Si es favorito...
        else if (favSiNo.equals("S")){
            botonFav.setText("QUITAR DE FAVORITOS");
        }
    }
}
