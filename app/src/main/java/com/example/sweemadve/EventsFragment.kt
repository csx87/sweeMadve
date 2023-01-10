package com.example.sweemadve

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.replace
import com.example.sweemadve.databinding.EventsFragmentBinding

class EventsFragment: Fragment(R.layout.events_fragment) {
    private var prvFlag = false
    private var binding: EventsFragmentBinding? = null
    lateinit var savedText: String
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventsFragmentBinding.inflate(layoutInflater)
        val ft = childFragmentManager.beginTransaction()
        val id = binding!!.frameLayout.id
        if(!prvFlag) {
            val eventFragment24 = EventFragment24()
            ft.replace(id, eventFragment24)
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            ft.commit();
            Log.i("Fragment","here")

        }

        else{
            when(savedText){
                "24 Jan" -> {
                    binding!!.eventsDateText.text = "24 Jan"
                    val eventFragment = EventFragment24()
                    ft.replace(id, eventFragment)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                    Log.i("Fragment","here")
                }
                "25 Jan" -> {
                    binding!!.eventsDateText.text = "25 Jan"
                    val eventFragment = EventFragment25()
                    ft.replace(id, eventFragment)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                    Log.i("Fragment","here")
                }
                "26 Jan" -> {
                    binding!!.eventsDateText.text = "26 Jan"
                    val eventFragment = EventFragment26()
                    ft.replace(id, eventFragment)
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    ft.commit();
                    Log.i("Fragment","here")
                }
                else -> Log.i("EvnetsFragment","Not able to go to previous fragment")
            }
        }

        prvFlag = true;

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

    override fun onSaveInstanceState(outState: Bundle) {
        binding = EventsFragmentBinding.inflate(layoutInflater)
        val string = binding!!.eventsDateText.text as String
        outState.putString("date",string)
        super.onSaveInstanceState(outState)
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