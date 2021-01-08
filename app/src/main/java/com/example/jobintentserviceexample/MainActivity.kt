package com.example.jobintentserviceexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jobintentserviceexample.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        binding.btnEnqueueWork.setOnClickListener {
            val input = binding.editTextInput.text.toString()

            val serviceIntent = Intent(this, ExampleJobIntentService::class.java)
            serviceIntent.putExtra("key", input)

            ExampleJobIntentService().enqueueWork(this, serviceIntent)
        }
    }
}