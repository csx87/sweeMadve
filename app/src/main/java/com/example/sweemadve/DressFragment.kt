package com.example.sweemadve

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.DressFragmentBinding


class DressFragment: Fragment(R.layout.dress_fragment) {
    private var scrollPosition = 0
    private lateinit var binding: DressFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DressFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        binding.scrollable.scrollY = scrollPosition
        super.onStart()
    }

    override fun onStop() {
        scrollPosition = binding.scrollable.scrollY
        super.onStop()
    }


}