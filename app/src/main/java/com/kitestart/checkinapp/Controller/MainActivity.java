package com.kitestart.checkinapp.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kitestart.checkinapp.Model.Places;
import com.kitestart.checkinapp.R;
import com.kitestart.checkinapp.View.PlacesAdapter;

public class MainActivity extends AppCompatActivity {

    ListView placesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        placesList = findViewById(R.id.myPlacesList);

        PlacesAdapter adapter = new PlacesAdapter(this, Places.allPlaces);

        placesList.setAdapter(adapter);

        setData();

    }


    void setData(){

        Places p1 = new Places(51.1405023, 71.465764, "Astana Mall", "20:50");
        Places p2 = new Places(51.1455034, 71.4136487, "Keruen City", "20:50");
        Places p3 = new Places(51.1326023, 71.4036441, "Хан Шатыр", "20:50");

        Places.allPlaces.add(p1);
        Places.allPlaces.add(p2);
        Places.allPlaces.add(p3);

    }

}
