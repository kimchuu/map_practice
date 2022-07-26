package com.kimchuu.map_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kimchuu.map_practice.databinding.ActivityMainBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding

    companion object {
        lateinit var naverMap: NaverMap
    }

    private lateinit var mapFragment: MapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 지도 객체 생성
        mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as MapFragment

        // 비동기로 onMapReady 호출
        mapFragment = mapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(map: NaverMap) {
        naverMap = map
        var marker = Marker(LatLng(37.4963462,126.9568865))
        marker.map = naverMap
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
    }
}