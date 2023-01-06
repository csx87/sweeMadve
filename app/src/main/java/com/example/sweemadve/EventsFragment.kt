package com.example.sweemadve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.sweemadve.databinding.EventsFragmentBinding

class EventsFragment: Fragment(R.layout.events_fragment) {
    private var binding: EventsFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventsFragmentBinding.inflate(layoutInflater)
        val event_24_fragment = EventFragment24()
        val ft = childFragmentManager.beginTransaction()
        val id = binding!!.frameLayout.id
        ft.replace(id,event_24_fragment)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.commit();
        return binding!!.root
    }




}