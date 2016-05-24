package com.example.miguel.openhousemadrid;

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
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by MAngelN on 22/04/2016.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Firebase.setAndroidContext(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Firebase ref = new Firebase("https://openhousemadrid2016.firebaseio.com/edificio");

        Firebase.setAndroidContext(this);


        VistaGeneralEdificios myVista = new VistaGeneralEdificios();
        final ArrayList<Edificio> edificios = myVista.descargarEdificios();


        ref.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Edificio edificio = postSnapshot.getValue(Edificio.class);
                    LatLng marcador = new LatLng(Double.parseDouble(edificio.getLatitud()), Double.parseDouble(edificio.getLongitud()));
                    String rutaImg = new String(edificio.getFotografia());

                    //Añadimos la informacion del marcador personalizado
                    mMap.addMarker(new MarkerOptions()
                            // Aqui es donde debemos recibir los datos de Firebase de cada edificio
                            .position(marcador)
                            .title(edificio.getNombre())
                            .snippet(edificio.getFotografia())
                    );
                    mMap.setInfoWindowAdapter(new UserInfoWindowAdapter(getApplicationContext(),getLayoutInflater()));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        //Zoom del mapa al centro de Madrid
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.4222453,-3.7016385), 12));

    }
}
