package com.example.retomapssave

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
<<<<<<< HEAD
import com.google.android.gms.maps.model.LatLngBounds
=======
import com.google.android.gms.maps.model.Marker
>>>>>>> 5a2fdb26bc310e99f067d50e0f9cd94f2f7370b7
import com.google.android.gms.maps.model.MarkerOptions


class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener {
    private lateinit var mMap: GoogleMap
    override fun onMarkerClick(p0: Marker?): Boolean {



        return false
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)




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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(40.416775, -3.703790)
        mMap.addMarker(MarkerOptions().position(sydney).title("Calle de los palomares"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

<<<<<<< HEAD
        mMap.setOnMapClickListener () {
            print(mMap.cameraPosition)
        }
=======
        mMap.setOnMarkerClickListener(this)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.mapType=GoogleMap.MAP_TYPE_HYBRID



        




>>>>>>> 5a2fdb26bc310e99f067d50e0f9cd94f2f7370b7
    }
}

