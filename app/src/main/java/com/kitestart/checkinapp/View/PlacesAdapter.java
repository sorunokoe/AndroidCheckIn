package com.kitestart.checkinapp.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kitestart.checkinapp.Model.Places;
import com.kitestart.checkinapp.R;

import java.util.ArrayList;

public class PlacesAdapter extends ArrayAdapter<Places> {


    Context context;
    ArrayList<Places> places;


    public PlacesAdapter(Context context, ArrayList places){

        super(context, 0, places);

        this.context = context;
        this.places = places;

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View listView = convertView;

        if(listView == null){
            listView = LayoutInflater.from(context).inflate(R.layout.places_item, parent, false);
        }


        TextView name = listView.findViewById(R.id.nameTxt);
        TextView time = listView.findViewById(R.id.timeTxt);

        Places place = Places.allPlaces.get(position);

        name.setText(place.getName());
        time.setText(place.getTime());

        return listView;

    }
}
