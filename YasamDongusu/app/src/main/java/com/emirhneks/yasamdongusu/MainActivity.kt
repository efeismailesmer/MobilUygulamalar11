package com.emirhneks.yasamdongusu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.yasamdongusu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        println("onCreate çalıştı")
    }

    override fun onStart() {
        super.onStart()
        println("onStart çalıştı")
    }

    override fun onResume() {
        super.onResume()
        println("onResume çalıştı")
    }

    override fun onPause() {
        super.onPause()
        println("onPause çalıştı")
    }

    override fun onStop() {
        super.onStop()
        println("onStop çalıştı")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çalıştı")
    }

    fun digerSayfa(view: View) {
        val girilenText = binding.editTextText.text.toString()
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("ad", girilenText)
        startActivity(intent)
    }
}
