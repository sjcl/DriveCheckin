package me.sjcl.drivecheckin.repository

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocationRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val fusedLocationProviderClient: FusedLocationProviderClient
) {
    @SuppressLint("MissingPermission")
    fun getCurrentLocationOnce(): LiveData<Location?> {
        val currentLocation = MutableLiveData<Location?>()

        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                currentLocation.value = location
            }
            .addOnFailureListener {
                currentLocation.value = null
            }

        return currentLocation
    }

}
