package com.example.sweemadve

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
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
        binding.foodText.text = getString(R.string.Lunch_24)
        binding.foodNavigationView.menu.findItem(R.id.breakfast).isVisible = false
        binding.foodNavigationView.menu.findItem(R.id.lunch).isChecked = true
        //binding.dateText.doAfterTextChanged { handleFoodMenuDisplay(binding,type = "Breakfast")  }
        binding.foodNavigationView.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.breakfast -> {
                    handleFoodMenuDisplay(binding,"Breakfast")
                    Log.i("Here","Here")
                    true
                }
                R.id.lunch -> {
                    handleFoodMenuDisplay(binding,"Lunch")
                    true
                }
                R.id.snacks -> {
                    handleFoodMenuDisplay(binding,"Snacks")
                    true
                }
                R.id.dinner -> {
                    handleFoodMenuDisplay(binding,"Dinner")
                    true
                }
                else -> false
            }
        }
        //Handel the clicking of 24 case
        return binding.root
    }

   private fun handleFoodMenuDisplay(binding: FoodFragmentBinding,type: String) {
        if (binding.dateText.text as String == "24 Jan") {
            when (type) {
                "Breakfast" -> binding.foodText.text = getString(R.string.Breakfast_24)
                "Lunch" -> binding.foodText.text = getString(R.string.Lunch_24)
                "Snacks" -> binding.foodText.text = getString(R.string.Snacks_24)
                "Dinner" -> binding.foodText.text = getString(R.string.Dinner_24)
                else -> binding.foodText.text = "Invalid_Date"

            }
        }

        if (binding.dateText.text as String == "25 Jan") {
            when (type) {
                "Breakfast" -> binding.foodText.text = getString(R.string.Breakfast_25)
                "Lunch" -> binding.foodText.text = getString(R.string.Lunch_25)
                "Snacks" -> binding.foodText.text = getString(R.string.Snacks_25)
                "Dinner" -> binding.foodText.text = getString(R.string.Dinner_25)
                else -> binding.foodText.text = "Invalid_Date"
            }
        }

        if(binding.dateText.text as String == "26 Jan"){
            when(type){
                "Breakfast" -> binding.foodText.text = getString(R.string.Breakfast_26)
                "Lunch" -> binding.foodText.text = getString(R.string.Lunch_26)
                "Snacks" -> binding.foodText.text = getString(R.string.Snacks_26)
                "Dinner" -> binding.foodText.text = getString(R.string.Dinner_26)
                else -> binding.foodText.text = "Invalid_Date"
            }
        }
    }



}