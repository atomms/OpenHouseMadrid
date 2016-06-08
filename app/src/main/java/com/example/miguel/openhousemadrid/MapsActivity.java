package com.example.miguel.openhousemadrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by Santos García & Miguel Ángel Núñez on 22/04/2016.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList <Edificio> edificios;
    ArrayList <Edificio> marcadoresEdificios;
    private LatLngBounds MADRID = new LatLngBounds(new LatLng(40.4222453,-3.7016385), new LatLng(40.4222453,-3.7016385));
    VistaGeneralEdificios mivista = new VistaGeneralEdificios();
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Firebase.setAndroidContext(this);
        descargarEdificios();
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        ponerMarcadores(mMap);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MADRID.getCenter(), 12));
        ponerMarcadores(googleMap);
    }


    public void ponerMarcadores(GoogleMap googleMap){

        mMap = googleMap;

        for (i=0; i<edificios.size();i++){
            Double lat = Double.parseDouble(edificios.get(i).getLatitud());
            Double lon = Double.parseDouble(edificios.get(i).getLongitud());
            LatLng marcador = new LatLng(lat,lon);
            String rutaImg = edificios.get(i).getFotografia();
            String nombre = edificios.get(i).getNombre();


            mMap.setInfoWindowAdapter(new UserInfoWindowAdapter(getApplicationContext(),getLayoutInflater()));
            mMap.addMarker(new MarkerOptions().position(marcador).title(nombre).snippet(rutaImg));


            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    for (int x=0; x<edificios.size();x++){
                        if (marker.getTitle().equals(edificios.get(x).getNombre())){
                            Edificio item = edificios.get(x);
                            Intent intent = new Intent(MapsActivity.this, ActividadDetalle.class);
                            intent.putExtra("Objeto",item);
                            startActivity(intent);
                        }
                    }


                }
            });

        }
        }

    public ArrayList <Edificio> descargarEdificios() {

        Firebase ref = new Firebase("https://openhousemadrid16.firebaseio.com/edificios");
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


}
