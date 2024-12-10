package com.emirhneks.bilgisaklama

import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.bilgisaklama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var kayitliAd: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = this.getSharedPreferences("com.emirhneks.bilgisaklama", MODE_PRIVATE)

        kayitliAd = sharedPreferences.getString("ad", null)
        if (kayitliAd != null) {
            binding.textView.text = "Adınız: ${kayitliAd}"
        } else {
            binding.textView.text = "Henüz kayıtlı bir kullanıcı yok."
        }
    }

    fun kaydet(view: View) {
        val kulad = binding.editTextText.text.toString()
        if (kulad == "") {
            val toast = Toast.makeText(this@MainActivity, "Bir ad girmediniz.", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        } else {
            sharedPreferences.edit().putString("ad", kulad).apply()
            binding.textView.text = "Adınız: ${kulad}"
        }
    }

    fun sil(view: View) {
        val uyar = AlertDialog.Builder(this@MainActivity)
        kayitliAd = sharedPreferences.getString("ad", null)
        if (kayitliAd != null) {
            uyar.setTitle("Dikkat!")
            uyar.setMessage(
                "Yaptığınız işlem ${kayitliAd} adlı kullanıcıyı silecektir. Devam etmek istediğinizden emin misiniz?"
            )
            uyar.setCancelable(true)
            uyar.setIcon(R.drawable.uyariisareti)
            uyar.setPositiveButton("Evet") { dialog, which ->
                sharedPreferences.edit().remove("ad").apply()
                Toast.makeText(
                    this@MainActivity,
                    "Kullanıcı kaydı başarıyla silindi.",
                    Toast.LENGTH_LONG
                )
                    .show()
                binding.textView.text = "Henüz kayıtlı bir kullanıcı yok."
            }
            uyar.setNegativeButton("Hayır") { dialog, which ->
                Toast.makeText(this@MainActivity, "İşlem iptal edildi.", Toast.LENGTH_LONG).show()
            }
            uyar.show()
        } else {
            val toast =
                Toast.makeText(
                    this@MainActivity,
                    "Kayıtlı bir kullanıcı bulunamadı.",
                    Toast.LENGTH_LONG
                )
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}
