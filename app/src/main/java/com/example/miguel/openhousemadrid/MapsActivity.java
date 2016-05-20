package com.example.miguel.openhousemadrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by MAngelN on 22/04/2016.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        // Add a marker in Madrid and move the camera
        LatLng madrid = new LatLng(40.456438, -3.6591827);

        //Zoom del mapa al centro de Madrid
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(40.4222453,-3.7016385), 12));



        //Añadimos la informacion del marcador personalizado.
        mMap.addMarker(new MarkerOptions()
        .position(madrid)
         // Aqui es donde debemos recibir los datos de Firebase de cada edificio
        .title("Madrid")
        .snippet("De Madrid al cielo")
        );

        mMap.setInfoWindowAdapter(new UserInfoWindowAdapter(getLayoutInflater()));
        // Cargamos el archivo KML desde una ubicacion Local.(carpeta res/raw)
        //Para que funcione hay que añadir las dependencias "compile 'com.google.maps.android:android-maps-utils:0.4+'" en build.gradle
      /*  try {
            KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.edificios, getApplicationContext());
            kmlLayer.addLayerToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }*/

    }
}
