package com.example.sweemadve

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.FoodFragmentBinding





class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener {


        private var myDialog : DatePickerDialog?= null

        private fun intToMonth(int : Int):String?{
            return when(int){
            0 -> "Jan"
            1 -> "Feb"
            2 -> "Mar"
            3 -> "Apr"
            4 -> "May"
            5 -> "Jun"
            6 ->  "July"
            7 -> "Aug"
            8 -> "Sept"
            9 -> "Oct"
            10 -> "Nov"
            11 -> "Dec"
            else -> null
            }
        }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        myDialog =  DatePickerDialog(requireContext(), this, year, month, day)
        val datePicker = myDialog!!.datePicker
        datePicker.maxDate = 1674671400000
        datePicker.minDate = 1674498600000
        myDialog!!.setOnDateSetListener(this)


        return myDialog as DatePickerDialog


    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateText = activity?.findViewById<TextView>(R.id.dateText)
        val date = p3.toString()
        val month = intToMonth(p2)
        dateText?.text = date.plus(" ").plus(month)
    }



}


