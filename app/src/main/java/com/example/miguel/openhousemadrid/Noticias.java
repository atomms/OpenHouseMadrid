package com.example.miguel.openhousemadrid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Santos on 30/05/2016.
 */

public class Noticias extends AppCompatActivity {

    ArrayList<Noticia> noticias;

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView d1;
    TextView d2;
    TextView d3;
    TextView d4;
    TextView f1;
    TextView f2;
    TextView f3;
    TextView f4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticias);

        t1 = (TextView) findViewById(R.id.textViewNoticia1);
        t2 = (TextView) findViewById(R.id.textViewNoticia2);
        t3 = (TextView) findViewById(R.id.textViewNoticia3);
        t4 = (TextView) findViewById(R.id.textViewNoticia4);

        d1 = (TextView) findViewById(R.id.textViewTextonoticia1);
        d2 = (TextView) findViewById(R.id.textViewTextonoticia2);
        d3 = (TextView) findViewById(R.id.textViewTextonoticia3);
        d4 = (TextView) findViewById(R.id.textViewTextonoticia4);

        f1 = (TextView) findViewById(R.id.textViewfecha1);
        f2 = (TextView) findViewById(R.id.textViewfecha2);
        f3 = (TextView) findViewById(R.id.textViewfecha3);
        f4 = (TextView) findViewById(R.id.textViewfecha4);

        descargarNoticias();
    }

    public ArrayList<Noticia> descargarNoticias() {

        Firebase ref = new Firebase("https://noticias-ohm-2016.firebaseio.com/noticia");
        noticias = new ArrayList <Noticia>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Noticia post = postSnapshot.getValue(Noticia.class);
                    noticias.add(post);
                }
                Log.d("TAGDWLD", "Tamaño del Array: "+ noticias.size());
                Log.d("TAGDWLD", "Noticias descargadas correctamente");
                ponerNoticias();
            }

            private void ponerNoticias() {

                t1.setClickable(true);
                t1.setMovementMethod(LinkMovementMethod.getInstance());
                String text1 = "<a href='"+noticias.get(0).getLink()+"'> "+noticias.get(0).getTitulo()+" </a>";
                t1.setText(Html.fromHtml(text1));

                t2.setClickable(true);
                t2.setMovementMethod(LinkMovementMethod.getInstance());
                String text2 = "<a href='"+noticias.get(1).getLink()+"'> "+noticias.get(1).getTitulo()+" </a>";
                t2.setText(Html.fromHtml(text2));

                t3.setClickable(true);
                t3.setMovementMethod(LinkMovementMethod.getInstance());
                String text3 = "<a href='"+noticias.get(2).getLink()+"'> "+noticias.get(2).getTitulo()+" </a>";
                t3.setText(Html.fromHtml(text3));

                t4.setClickable(true);
                t4.setMovementMethod(LinkMovementMethod.getInstance());
                String text4 = "<a href='"+noticias.get(3).getLink()+"'> "+noticias.get(3).getTitulo()+" </a>";
                t4.setText(Html.fromHtml(text4));


                d1.setText(noticias.get(0).getDescripcion());
                d2.setText(noticias.get(1).getDescripcion());
                d3.setText(noticias.get(2).getDescripcion());
                d4.setText(noticias.get(3).getDescripcion());

                f1.setText(noticias.get(0).getFecha());
                f2.setText(noticias.get(1).getFecha());
                f3.setText(noticias.get(2).getFecha());
                f4.setText(noticias.get(3).getFecha());

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.d("TAGERR", "La base de datos no está disponible"+ firebaseError.getMessage());
            }
        });
        return noticias;
    }
}
