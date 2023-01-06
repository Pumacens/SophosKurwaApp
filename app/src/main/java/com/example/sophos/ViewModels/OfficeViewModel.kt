package com.example.sophos.ViewModels

import android.annotation.SuppressLint
import android.location.Location
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sophos.Data.Model.LoginResponse
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.android.gms.tasks.OnTokenCanceledListener
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class OfficeViewModel: ViewModel() {

    var currentLocation: MutableLiveData<LatLng?> = MutableLiveData()

    @SuppressLint("MissingPermission")
    fun getLocation(fusedLocation: FusedLocationProviderClient?){
        println(fusedLocation)

        fusedLocation?.let{
            it.getCurrentLocation(
                LocationRequest.PRIORITY_HIGH_ACCURACY,
                object : CancellationToken() {
                    override fun onCanceledRequested(p0: OnTokenCanceledListener) = CancellationTokenSource().token
                    override fun isCancellationRequested() = false
                })
                .addOnSuccessListener { location: Location? ->
                    if (location == null) {
//                        Toast.makeText(
//                            this,
//                            "No se pudo obtener ubicación. Intenta de nuevo",
//                            Toast.LENGTH_SHORT
//                        ).show()
                        println("No se pudo obtener la localizacion")
                    }

                    else {
                        var locationInLatLng = LatLng(location.latitude, location.longitude)
                        currentLocation.postValue(locationInLatLng)
                        println(locationInLatLng)
                    }
                }
        }
    }
}