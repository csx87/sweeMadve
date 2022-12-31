package com.example.sweemadve

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TextView
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import com.example.sweemadve.databinding.FoodFragmentBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*


class DatePickerFragment: DialogFragment(), DatePickerDialog.OnDateSetListener{


        private var myDialog : DatePickerDialog?= null
        val selectedDate = Calendar.getInstance()

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
        // Create a new instance of DatePickerDialog and return it
        myDialog =  DatePickerDialog(requireContext(), this, 2022, 0, 24)
        val datePicker = myDialog!!.datePicker
        datePicker.maxDate = 1674671400000
        datePicker.minDate = 1674498600000
        myDialog!!.setOnDateSetListener(this)
        datePicker.isSaveEnabled = true


        return myDialog as DatePickerDialog


    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateText = activity?.findViewById<TextView>(R.id.dateText)
        val foodText = activity?.findViewById<TextView>(R.id.foodText)
        val foodNav = activity?.findViewById<BottomNavigationView>(R.id.foodNavigationView)

        val date = p3.toString()
        val month = intToMonth(p2)
        p0?.updateDate(p1,p2,p3)
        //p0.setOnDateChangedListener(this)
        dateText?.text = date.plus(" ").plus(month)

        when(foodNav?.selectedItemId){
            R.id.breakfast -> handleFoodMenuDisplay(dateText,foodText,"Breakfast")
            R.id.lunch -> handleFoodMenuDisplay(dateText,foodText,"Lunch")
            R.id.snacks -> handleFoodMenuDisplay(dateText,foodText,"Snacks")
            R.id.dinner -> handleFoodMenuDisplay(dateText,foodText,"Dinner")
        }
    }

    private fun handleFoodMenuDisplay(dateText: TextView?,foodText: TextView?, type: String?) {
        if (dateText?.text as String == "24 Jan") {
            when (type) {
                "Breakfast" -> foodText?.text = getString(R.string.Breakfast_24)
                "Lunch" -> foodText?.text = getString(R.string.Lunch_24)
                "Snacks" -> foodText?.text = getString(R.string.Snacks_24)
                "Dinner" -> foodText?.text = getString(R.string.Dinner_24)
                else -> foodText?.text = "Invalid_Date"
            }
        }

        if (dateText.text as String == "25 Jan") {
            when (type) {
                "Breakfast" -> foodText?.text = getString(R.string.Breakfast_25)
                "Lunch" -> foodText?.text = getString(R.string.Lunch_25)
                "Snacks" -> foodText?.text = getString(R.string.Snacks_25)
                "Dinner" -> foodText?.text = getString(R.string.Dinner_25)
                else -> foodText?.text = "Invalid_Date"
            }
        }

        if(dateText.text as String == "26 Jan"){
            when(type){
                "Breakfast" -> foodText?.text = getString(R.string.Breakfast_26)
                "Lunch" -> foodText?.text = getString(R.string.Lunch_26)
                "Snacks" -> foodText?.text = getString(R.string.Snacks_26)
                "Dinner" -> foodText?.text = getString(R.string.Dinner_26)
                else -> foodText?.text = "Invalid_Date"
            }
        }
    }

}


