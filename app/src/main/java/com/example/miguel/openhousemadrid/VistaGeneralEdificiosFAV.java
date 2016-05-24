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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class VistaGeneralEdificiosFAV extends AppCompatActivity {

    GridView gv;
    SearchView sv;
    ArrayList<Edificio> edificios;
    String favSiNo;
    SharedPreferences preferencias;
    TextView tvAvisoNoFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_general_edificios_fav);

        gv= (GridView) findViewById(R.id.gridViewGeneralFAV);
        tvAvisoNoFav = (TextView) findViewById(R.id.textViewAvisoNoFav);

        //ADAPTADOR
        final Adapter adapter = new Adapter(this, this.descargarEdificios());
        gv.setAdapter(adapter);



        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Edificio item = (Edificio) parent.getItemAtPosition(position);
                Intent intent = new Intent(VistaGeneralEdificiosFAV.this, ActividadDetalle.class);
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

                    preferencias = getSharedPreferences("Favoritos", Context.MODE_PRIVATE);
                    String nome = post.getNombre();
                    favSiNo = preferencias.getString(nome,"N");
                    if (favSiNo.equals("S")) {
                        edificios.add(post);
                    }
                    if (edificios.isEmpty()){
                        tvAvisoNoFav.setText("No tienes favoritos... Pero puedes añadirlos desde la pestaña de cada edificio!");
                    }
                    else{
                        tvAvisoNoFav.setText("");
                    }
                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Toast toast1 = Toast.makeText(getApplicationContext(),"La Base de datos no está disponible. Revise su conexion a internet", Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
        return edificios;
    }
}
