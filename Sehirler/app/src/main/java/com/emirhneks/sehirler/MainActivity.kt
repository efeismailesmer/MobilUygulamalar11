package com.emirhneks.sehirler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.emirhneks.sehirler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sehirListesi: ArrayList<SehirlerSinifi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kayseri = SehirlerSinifi("Kayseri", "Pastırma", R.drawable.kayseri)
        val edirne = SehirlerSinifi("Edirne", "Ciğer", R.drawable.edirne)
        val karabuk = SehirlerSinifi("Karabük", "Lokum", R.drawable.karabuk)
        val tekirdag = SehirlerSinifi("Tekirdağ", "Köfte", R.drawable.tekirdag)

        sehirListesi = arrayListOf(kayseri, edirne, karabuk, tekirdag)

        val baglanti = SehirAdapter(sehirListesi)
        binding.sehirlerRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.sehirlerRecycler.adapter = baglanti
    }
}
