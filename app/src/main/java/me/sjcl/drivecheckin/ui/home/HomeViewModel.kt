package me.sjcl.drivecheckin.ui.home

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    val location = MutableLiveData<Location>()

}