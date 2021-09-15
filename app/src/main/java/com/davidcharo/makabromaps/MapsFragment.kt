package com.davidcharo.makabromaps

import android.Manifest
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val valdes = LatLng(6.270528, -75.557400)
        googleMap.addMarker(MarkerOptions()
            .position(valdes)
            .title("Makabro Campo Valdés")
            .snippet("Mi restaurante favorito"))

        val copacabana = LatLng(6.369154,-75.490002)
        googleMap.addMarker(MarkerOptions()
            .position(copacabana)
            .title("Makabro Campo Copacabana")
            .snippet("Mi restaurante favorito"))

        val ochenta = LatLng(6.2604397,-75.597160)
        googleMap.addMarker(MarkerOptions()
            .position(ochenta)
            .title("Makabro Campo La 80")
            .snippet("Mi restaurante favorito"))

        val bello = LatLng(6.339172, -75.548308)
        googleMap.addMarker(MarkerOptions()
            .position(bello)
            .title("Makabro Campo Bello")
            .snippet("Mi restaurante favorito"))

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(bello))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bello,11.5F))

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return@OnMapReadyCallback
        }
        googleMap.isMyLocationEnabled = true

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}