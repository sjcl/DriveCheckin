package me.sjcl.drivecheckin.ui.home

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import me.sjcl.drivecheckin.repository.LocationRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val locationRepository: LocationRepository
) : ViewModel() {

    private val _location = MutableLiveData<Location?>()
    val location: LiveData<Location?> = _location

    fun updateLocation() {
        val currentLocation = locationRepository.getCurrentLocationOnce()
        currentLocation.observeForever { location ->
            _location.value = location
        }
    }
}
