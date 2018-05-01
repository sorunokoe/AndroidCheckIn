package com.kitestart.checkinapp.Controller;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.kitestart.checkinapp.Model.Places;
import com.kitestart.checkinapp.R;

public class MapPlaceActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    Places place;

    LocationManager locationManager;
    LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_place);


        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                LatLng myCurrentPlace = new LatLng(location.getLongitude(), location.getLatitude());
                mMap.addMarker(new MarkerOptions().position(myCurrentPlace));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myCurrentPlace, 15));

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0,0, locationListener);
        }else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }





        if(getIntent() != null){
            if(getIntent().getExtras() != null){

                int position = getIntent().getExtras().getInt("index");
                System.out.println("My piositon "+position);
                place = Places.allPlaces.get(position);

            }

        }


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        System.out.println(place);

        if(place != null) {
            LatLng placeLatLng = new LatLng(place.getLontitude(), place.getLatitude());
            mMap.addMarker(new MarkerOptions().position(placeLatLng).title(place.getName()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(placeLatLng, 15));
        }
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }




}
