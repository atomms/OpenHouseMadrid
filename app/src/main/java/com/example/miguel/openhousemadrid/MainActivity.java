package com.example.miguel.openhousemadrid;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by MAngelN on 22/04/2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/amatic.bold.ttf");

        ImageView imgMap = (ImageView) findViewById(R.id.imageViewMap);
        ImageView imgEdif = (ImageView) findViewById(R.id.imageViewEdif);
        ImageView imgFavo = (ImageView) findViewById(R.id.imageViewFav);
        ImageView imgInfo = (ImageView) findViewById(R.id.imageViewInfo);
        TextView texto1=(TextView)findViewById(R.id.maintextViewEdif);
        TextView texto2=(TextView)findViewById(R.id.maintextViewFav);
        TextView texto3=(TextView)findViewById(R.id.maintextViewInfo);
        TextView texto4=(TextView)findViewById(R.id.maintextViewMap);
        texto1.setTypeface(tf);
        texto2.setTypeface(tf);
        texto3.setTypeface(tf);
        texto4.setTypeface(tf);
    }

    //Abre la actividad de Lista de edificios
    public void openEdif(View view){
        Intent intent = new Intent(this, VistaGeneralEdificios.class);
        startActivity(intent);
    }
    //Abrir actividad de Mapa
    public void openMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }
    //Abrir actividad de favoritos
    public void openFav(View view){
        Intent intent = new Intent(this, VistaGeneralEdificiosFAV.class);
        startActivity(intent);
    }
    //Abrir actividad de Info
    public void openInfo(View view){

    }



}
