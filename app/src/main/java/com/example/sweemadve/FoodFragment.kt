package com.example.sweemadve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.FoodFragmentBinding
import java.util.*

class FoodFragment: Fragment(R.layout.food_fragment) {
    lateinit var binding: FoodFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FoodFragmentBinding.inflate(layoutInflater)
        binding.dateText.text = "24 Jan"
        return binding.root
    }


}