package com.example.englishwordapp

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.englishwordapp.databinding.ActivitySecondDemoBinding

class SecondDemoActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondDemoBinding
    private val LocationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if(isGranted){
                Log.d("SecondDemoActivity","Разрешение на локацию получено")
            } else {
                Log.d("SecondDemoActivity","Разрешиние на локацию отклонено")
            }

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("!!!","${this.componentName.shortClassName} Выполняется метод onCreate() ")
        val btnLocation = binding.btnRequestPermission
        btnLocation.setOnClickListener{
            LocationPermissionLauncher.launch(ACCESS_FINE_LOCATION)
        }
        with(binding){
            btnOpenFirst.setOnClickListener {
                val intent = Intent(this@SecondDemoActivity, FirstDemoActivity::class.java)
                startActivity(intent)
            }

            val bundle = intent.extras
            val text = bundle?.getString("EXTRA_KEY_TEXT")
            val number = bundle?.getInt("EXTRA_KEY_NUMBER")
            val word = bundle?.getParcelable("EXTRA_KEY_WORD", FirstDemoActivity.ExtraWord::class.java  )
            tvText.text = text
            tvNumber.text = number.toString()
            tvWord.text = word?.original
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("!!!","${this.componentName.shortClassName} Выполняется метод onStart() ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("!!!","${this.componentName.shortClassName} Выполняется метод onResume() ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("!!!","${this.componentName.shortClassName} Выполняется метод onPause()")

    }
}
