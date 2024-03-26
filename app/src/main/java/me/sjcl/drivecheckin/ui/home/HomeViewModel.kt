package me.sjcl.drivecheckin.ui.home

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.sjcl.drivecheckin.repository.LocationRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {
    val location: LiveData<Location> = locationRepository.location

    fun updateLocation() {
       locationRepository.startLocationUpdates()
    }
}
