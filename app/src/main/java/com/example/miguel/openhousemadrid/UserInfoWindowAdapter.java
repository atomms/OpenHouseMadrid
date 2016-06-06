package com.example.miguel.openhousemadrid;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;


/**
 * Created by Miguel on 19/05/2016.
 */
public class UserInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
    LayoutInflater inflater= null;
    Context c;


    UserInfoWindowAdapter(Context ctx, LayoutInflater inflater) {
        this.inflater = inflater;
        this.c = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


    @Override
    public View getInfoContents(final Marker marker) {

        View infoWindows = inflater.inflate(R.layout.user_info_windows, null);
        String imagen = marker.getSnippet();
        ImageView img = (ImageView)infoWindows.findViewById(R.id.imagenEdificio);
        TextView title= (TextView)infoWindows.findViewById(R.id.title);
        title.setText(marker.getTitle());


        Glide.with(this.c).load(imagen).asBitmap().listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                e.printStackTrace();
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target,
                                           boolean isFromMemoryCache, boolean isFirstResource) {
                if(!isFromMemoryCache) marker.showInfoWindow();
                return false;
            }
        }).centerCrop().into(img);

        return (infoWindows);
    }
}

