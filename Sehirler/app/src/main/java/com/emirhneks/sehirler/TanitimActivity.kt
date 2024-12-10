package com.emirhneks.sehirler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.sehirler.databinding.ActivityTanitimBinding

class TanitimActivity : AppCompatActivity() {
  private lateinit var binding: ActivityTanitimBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityTanitimBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    val gelenIntent = intent
    val secilenSehir = gelenIntent.getSerializableExtra("sehir") as SehirlerSinifi
    binding.imageView.setImageResource(secilenSehir.gorsel)
    binding.textView.text = "Seçilen Şehir: ${secilenSehir.ad}"
    binding.textView2.text = "Şehrin Yemeği: ${secilenSehir.yemek}"
  }
}
