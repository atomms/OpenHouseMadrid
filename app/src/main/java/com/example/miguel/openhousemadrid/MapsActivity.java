package com.example.miguel.openhousemadrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by MAngelN on 22/04/2016.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Esta linea de Firebase hay que añadirla antes de usar cualquier dato de firebase que queramos leer.
        Firebase.setAndroidContext(this);

        // Esta otra linea se utiliza para leer desde el archivo de firbase
    /*    Firebase myFirebaseRef = new Firebase("https://<YOUR-FIREBASE-APP>.firebaseio.com/");


        myFirebaseRef.child("message").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
            }

            @Override public void onCancelled(FirebaseError error) { }

        });*/


        setContentView(R.layout.activity_maps);
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

      /*  // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/


        //Zoom del mapa al centro de Madrid
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.4222453,-3.7016385), 12));

        // Cargamos el archivo KML desde una ubicacion Local.(carpeta res/raw)
        //Para que funcione hay que añadir las dependencias "compile 'com.google.maps.android:android-maps-utils:0.4+'" en build.gradle
        try {
            KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.edificios, getApplicationContext());
            kmlLayer.addLayerToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }
}
