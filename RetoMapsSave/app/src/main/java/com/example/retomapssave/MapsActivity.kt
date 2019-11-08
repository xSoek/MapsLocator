package com.example.retomapssave


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import android.location.Geocoder
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.location.Address
import android.location.Location
import com.example.persistence.data.local.AppDatabase
import com.example.persistence.data.local.DatabaseFactor
import com.example.retomapssave.Dao.LocationDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.security.acl.LastOwnerException
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback,GoogleMap.OnMarkerClickListener, GoogleMap.OnMapLongClickListener {
    private lateinit var mMap: GoogleMap


    override fun onMapLongClick(point: LatLng) {


        Toast.makeText(
            applicationContext,
            "New marker added@$point", Toast.LENGTH_LONG
        )
            .show()

        Log.e("prueba", "$point")

        val geocoder: Geocoder
        val addresses: List<Address>
        geocoder = Geocoder(this, Locale.getDefault())

        val latitude = point.latitude
        val longitude = point.longitude

        addresses = geocoder.getFromLocation(latitude, longitude, 1)
        println("ESTO ES " + addresses)

        CoroutineScope(Dispatchers.IO).launch {
            var miLoc = addresses[0].featureName
            var miLocLocality = addresses[0].locality

        }

        mMap.addMarker(
            MarkerOptions()
                .position(point)
                .title(addresses.toString() )
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )

    }






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



        mMap.setOnMapClickListener () {
            print(mMap.cameraPosition)
        }
        mMap.setOnMarkerClickListener(this)
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.mapType=GoogleMap.MAP_TYPE_HYBRID
        mMap.setOnMapLongClickListener(this)
    }
}

