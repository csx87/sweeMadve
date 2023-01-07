package com.example.sweemadve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        val eventFragment24 = EventFragment24()
        val ft = childFragmentManager.beginTransaction()
        val id = binding!!.frameLayout.id
        ft.replace(id,eventFragment24)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.commit();

        binding!!.eventsDateDecrement.setOnClickListener{
                val textView = binding!!.eventsDateText
                handleDateText(textView,-1,ft,id)
        }

        binding!!.eventsDateIncrement.setOnClickListener{
            val textView = binding!!.eventsDateText
            handleDateText(textView,1,ft,id)
        }
        binding!!.eventsDateArrowDecrement.setOnClickListener{
            val textView = binding!!.eventsDateText
            handleDateText(textView,-1,ft,id)
        }

        binding!!.eventsDateArrowIncrement.setOnClickListener{
            val textView = binding!!.eventsDateText
            handleDateText(textView,1,ft,id)
        }

        return binding!!.root
    }

    fun handleDateText(date: TextView, flag : Int, ft2 : FragmentTransaction, frameId: Int){

        val ft = childFragmentManager.beginTransaction()
        if(flag == -1) {
            when (date.text) {
                "25 Jan" -> {
                    date.text = "24 Jan"
                    val eventFragment24 = EventFragment24()
                    ft.replace(frameId,eventFragment24)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                }
                "26 Jan" -> {
                    date.text = "25 Jan"
                    val eventFragment25 = EventFragment25()
                    ft.replace(frameId,eventFragment25)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                }
                //TODO:Toast
            }
        }

        else{
            when (date.text) {
                "24 Jan" -> {
                    date.text = "25 Jan"
                    val eventFragment25 = EventFragment25()
                    ft.replace(frameId,eventFragment25)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                }
                "25 Jan" -> {
                    date.text = "26 Jan"
                    val eventFragment26 = EventFragment26()
                    ft.replace(frameId,eventFragment26)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                }
                //TODO:Toast
            }
        }

    }

}