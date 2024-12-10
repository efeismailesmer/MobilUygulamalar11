package com.emirhneks.e_devlet

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.e_devlet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    private var kayitliSifre: String? = null
    private var kayitliTc: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.emirhneks.e_devlet", MODE_PRIVATE)
    }

    fun kaydet(@Suppress("UNUSED_PARAMETER") view: View) {
        val tc = (binding.tcGiris.text.toString()).toLongOrNull()
        val sifre = binding.eDevletGiris.text.toString()
        if (tc == null || sifre == "") {
            val toast =
                Toast.makeText(
                    this@MainActivity,
                    "Bilgileri eksiksiz girmelisiniz!",
                    Toast.LENGTH_LONG
                )
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        } else {
            val uyar = AlertDialog.Builder(this@MainActivity)
            uyar.setTitle("Dikkat!")
            uyar.setMessage(
                "$tc T.C. kimlik nolu ve $sifre şifreli hesabınız kaydedilecektir. Onaylıyor musunuz?"
            )
            uyar.setCancelable(true)
            uyar.setPositiveButton("Evet") { _, _ ->
                sharedPreferences.edit().putLong("tc", tc).apply()
                sharedPreferences.edit().putString("sifre", sifre).apply()
                Toast.makeText(this@MainActivity, "Kayıt tamamlandı.", Toast.LENGTH_LONG).show()
            }
            uyar.setNegativeButton("Hayır") { _, _ ->
                Toast.makeText(this@MainActivity, "Kayıt iptal edildi!", Toast.LENGTH_LONG).show()
            }
            uyar.show()
        }
    }

    fun giris(@Suppress("UNUSED_PARAMETER") view: View) {
        val tc = (binding.tcGiris.text.toString()).toLongOrNull()
        val sifre = binding.eDevletGiris.text.toString()
        kayitliTc = sharedPreferences.getLong("tc", 0)
        kayitliSifre = sharedPreferences.getString("sifre", null)
        if (tc != kayitliTc || sifre != kayitliSifre) {
            val toast =
                Toast.makeText(
                    this@MainActivity,
                    "Bilgileri doğru ve eksiksiz girmelisiniz!",
                    Toast.LENGTH_LONG
                )
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        } else {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("tc", tc)
            intent.putExtra("sifre", sifre)
            startActivity(intent)
        }
    }
}
