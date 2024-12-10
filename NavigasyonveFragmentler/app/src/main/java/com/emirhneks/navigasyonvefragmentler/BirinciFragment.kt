package com.emirhneks.navigasyonvefragmentler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.emirhneks.navigasyonvefragmentler.databinding.FragmentBirinciBinding

class BirinciFragment : Fragment() {
    private var _binding: FragmentBirinciBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBirinciBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtAd.setText("")
        binding.button.setOnClickListener {
            val ad = binding.txtAd.text.toString()
            val action = BirinciFragmentDirections.actionBirinciFragmentToIkinciFragment(ad)
            Navigation.findNavController(view).navigate(action)
            Toast.makeText(requireContext(), "Merhaba $ad", Toast.LENGTH_SHORT).show()
        }
    }
}
