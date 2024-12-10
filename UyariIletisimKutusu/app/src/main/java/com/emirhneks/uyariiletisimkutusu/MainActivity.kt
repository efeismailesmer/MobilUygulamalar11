package com.emirhneks.uyariiletisimkutusu

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.uyariiletisimkutusu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this, "Hoş geldiniz!", Toast.LENGTH_LONG).show()
    }

    fun uyar(view: View) {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("İşlem Kayıt Onayı")
        alert.setMessage("Kaydedilsin mi?")
        alert.setPositiveButton("Evet") { dialog, which ->
            Toast.makeText(this, "İşlem kaydedildi.", Toast.LENGTH_LONG).show()
        }
        alert.setNegativeButton("Hayır") { dialog, which ->
            Toast.makeText(this, "İşlem iptal edildi.", Toast.LENGTH_LONG).show()
        }
        alert.show()
    }
}
