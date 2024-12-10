package com.emirhneks.yasamdongusu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.yasamdongusu.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
  private lateinit var binding: ActivitySecondBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySecondBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.textView.text = "Adınız: " + intent.getStringExtra("ad")

    binding.button2.setOnClickListener {
      val intent = Intent(this, MainActivity::class.java)
      startActivity(intent)
    }
  }
}
