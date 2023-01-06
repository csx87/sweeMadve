package com.example.sweemadve

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.MapsFragmentBinding

class MapsFragment: Fragment(R.layout.maps_fragment) {
    private lateinit var binding: MapsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MapsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


}