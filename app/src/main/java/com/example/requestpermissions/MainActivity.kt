package com.example.requestpermissions

import androidx.appcompat.app.AppCompatActivity
import android.content.pm.PackageManager.PERMISSION_DENIED
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    companion object {
        private const val CAMERA_PERMISSION_CODE = 100
        private const val STORAGE_PERMISSION_CODE = 101
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storage : Button? = findViewById(R.id.storage)
        val camera : Button? = findViewById(R.id.camera)

        storage?.setOnClickListener{
            checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE)
        }
        camera?.setOnClickListener{
            checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
        }
    }
    private fun checkPermission(permission:String,requestCode:Int){
        if(ContextCompat.checkSelfPermission(this@MainActivity,permission)==PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(permission),requestCode)
        }
        else{
            Toast.makeText(this@MainActivity,"Permission already granted",Toast.LENGTH_SHORT).show()
        }
    }
}