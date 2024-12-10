package com.emirhneks.sehirler

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emirhneks.sehirler.databinding.SehirSatirBinding

class SehirAdapter(val sehirListesi: ArrayList<SehirlerSinifi>) :
    RecyclerView.Adapter<SehirAdapter.SehirlerViewHolder>() {
    class SehirlerViewHolder(val binding: SehirSatirBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SehirlerViewHolder {
        val binding = SehirSatirBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SehirlerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return sehirListesi.size
    }

    override fun onBindViewHolder(holder: SehirlerViewHolder, position: Int) {
        holder.binding.textView.text = sehirListesi[position].ad
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, TanitimActivity::class.java)
            intent.putExtra("sehir", sehirListesi[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}
