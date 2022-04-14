package com.hanyeop.permissionex

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.hanyeop.permissionex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPermission.setOnClickListener {
            requestPermission {
                todo()
            }
        }
    }

    private fun todo(){
        // TODO : 기능 구현
        Toast.makeText(this, "완료", Toast.LENGTH_SHORT).show()
    }

    private fun requestPermission(logic : () -> Unit){
        TedPermission.create()
            .setPermissionListener(object : PermissionListener {
                override fun onPermissionGranted() {
                    logic()
                }
                override fun onPermissionDenied(deniedPermissions: List<String>) {
                    Toast.makeText(this@MainActivity,
                        "권한을 허가해주세요.",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            })
            .setDeniedMessage("권한을 허용해주세요. [설정] > [앱 및 알림] > [고급] > [앱 권한]")
            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_CALENDAR )
            .check()
    }
}