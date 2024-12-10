package com.emirhneks.e_devlet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emirhneks.e_devlet.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
  private lateinit var binding: ActivitySecondBinding

  @SuppressLint("SetTextI18n")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySecondBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.txtTC.text = "T.C. Kimlik No:\n" + intent.getLongExtra("tc", 0)
    binding.txtSifre.text = "e-Devlet Şifresi:\n" + intent.getStringExtra("sifre")
  }
}
