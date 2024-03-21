package me.sjcl.drivecheckin

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val locationProvider = LocationProvider(this)
        if (!locationProvider.hasPermission()) {
            locationProvider.requestPermissionAndGetLocation()
        }

        locationProvider.location.observe(this) { location ->
            textView.text = location?.let {
                "緯度: ${it.latitude}, 経度: ${it.longitude}"
            } ?: "位置情報が取得できませんでした"
        }

        locationProvider.getLocation()

    }

}