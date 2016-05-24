package com.example.miguel.openhousemadrid;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

/**
 * Created by Miguel on 19/05/2016.
 */
public class UserInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
    LayoutInflater inflater= null;
    Context c;

    UserInfoWindowAdapter(Context ctx,LayoutInflater inflater){
        this.inflater = inflater;
        this.c = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {




        MapsActivity myMapsAct = new MapsActivity();
        View infoWindows = inflater.inflate(R.layout.user_info_windows, null);

        TextView title= (TextView)infoWindows.findViewById(R.id.title);
        // TextView description = (TextView)infoWindows.findViewById(R.id.snippet);
        title.setText(marker.getTitle());
        // description.setText(marker.getSnippet());
        String snippet = marker.getSnippet();



        ImageView img = (ImageView)infoWindows.findViewById(R.id.imagenEdificio);


        Picasso.with(this.c).load(snippet).into(img);

        return(infoWindows);
    }


}

