package com.emirhneks.mevlana

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.mevlana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.button.setOnClickListener {
      binding.imageView.setImageResource(R.drawable.mevlana2)
      binding.textView.text = "Mevlânâ Celâleddîn-i Rûmî 2"
    }
  }

  fun geri(view: View) {
    binding.imageView.setImageResource(R.drawable.mevlana1)
    binding.textView.text = "Mevlânâ Celâleddîn-i Rûmî 1"
  }
}
