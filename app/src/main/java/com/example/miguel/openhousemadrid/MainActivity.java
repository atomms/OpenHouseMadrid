package com.example.miguel.openhousemadrid;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by MAngelN/Santos on 22/04/2016.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);

        //Descargo los edificios al abrir la app
        VistaGeneralEdificios mivista = new VistaGeneralEdificios();
        mivista.descargarEdificios();

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/amatic.bold.ttf");


        ImageView imgMap = (ImageView) findViewById(R.id.imageViewMap);
        ImageView imgEdif = (ImageView) findViewById(R.id.imageViewEdif);
        ImageView imgFavo = (ImageView) findViewById(R.id.imageViewFav);
        ImageView imgNotic = (ImageView) findViewById(R.id.imageNoticias);
        ImageView imgInfo = (ImageView) findViewById(R.id.imageViewInfor);

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
    //Abrir actividad de Noticias
    public void openNoticias(View view){
        Intent intent = new Intent(this, Noticias.class);
        startActivity(intent);
    }
    //Abrir actividad de
    public void openInfo(View view){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }
    //Abrir Twitter
    public void openTwitter(View view){
        String link = "https://twitter.com/OpenHouseMadrid";
        Intent intent = null;
        intent = new Intent(intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
    //Abrir Instagram
    public void openInstagram(View view){
        String link = "https://www.instagram.com/openhousemadrid/";
        Intent intent = null;
        intent = new Intent(intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
    //Abrir Facebook
    public void openFacebook(View view){
        String link = "https://www.facebook.com/openhousemadrid";
        Intent intent = null;
        intent = new Intent(intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }

}
