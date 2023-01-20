package com.example.sweemadve

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.MapsFragmentBinding
import com.example.sweemadve.databinding.SpinnerItemBinding

class MapsFragment: Fragment(R.layout.maps_fragment), AdapterView.OnItemSelectedListener {
    var flag:Int = 0
    private lateinit var binding: MapsFragmentBinding
    lateinit var spinnerItem: SpinnerItemBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MapsFragmentBinding.inflate(layoutInflater)
        val spinner = binding.spinner
        spinner.onItemSelectedListener = this
        ArrayAdapter.createFromResource(
            this.requireContext(),
            R.array.maps,
            R.layout.spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /* <item>Fountain Area</item> 0
        <item>Bamboo Lawn</item> 1
        <item>Main Entrance</item> 2
        <item>Pavilion Area</item> 3
        <item>Pool Area</item> 4
        <item>Dining Hall</item> 5
        <item>Banquet Hall</item> 6*/

        super.onViewCreated(view, savedInstanceState)
        val venueText = requireArguments().getString("v")
        if (venueText == null)
            Log.i("venue_text", "null")
        else {
            Log.i("venue_text", venueText!!)
            when (venueText) {
                "Fou" -> binding.spinner.setSelection(0)
                "Bam" ->  binding.spinner.setSelection(1)
                "Mai" ->  binding.spinner.setSelection(2)
                "Pav" ->  binding.spinner.setSelection(3)
                "Poo" ->  binding.spinner.setSelection(4)
                "Din" ->  binding.spinner.setSelection(5)
                "Ban" ->  binding.spinner.setSelection(6)

            }
        }
    }


    override fun onStop() {
        flag =0;
        super.onStop()
    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        binding.mapsContents.textSize = 18F
        when(p2){
            0->{
                binding.mapsContents.text = getString(R.string.fountain_area)
                binding.mapImage1.setImageResource(R.drawable.fountain_area1)
                binding.mapImage2.setImageResource(R.drawable.fountain_area2)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.VISIBLE
                binding.mapImage3.visibility = View.GONE
                binding.mapImage4.visibility = View.GONE

            }

            1 -> {
                    binding.mapsContents.text = getString(R.string.bamboo_lawn)
                    binding.mapImage1.setImageResource(R.drawable.bamboo_area1)
                    binding.mapImage2.setImageResource(R.drawable.bamboo_area2)
                    binding.mapImage3.setImageResource(R.drawable.bamboo_area3)
                    binding.mapImage4.setImageResource(R.drawable.bamboo_area4)
                    binding.mapImage1.visibility = View.VISIBLE
                    binding.mapImage2.visibility = View.VISIBLE
                    binding.mapImage3.visibility = View.VISIBLE
                    binding.mapImage4.visibility = View.VISIBLE
            }
            2->{
                binding.mapsContents.text = getString(R.string.main_entrance)
                binding.mapImage1.setImageResource(R.drawable.image_not_available)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.GONE
                binding.mapImage3.visibility = View.GONE
                binding.mapImage4.visibility = View.GONE
            }
            3 -> {
                binding.mapsContents.textSize = 16F
                binding.mapsContents.text = getString(R.string.pavilion_area)
                binding.mapImage1.setImageResource(R.drawable.pavilion_hall1)
                binding.mapImage2.setImageResource(R.drawable.pavilion_hall2)
                binding.mapImage3.setImageResource(R.drawable.pavilion_hall3)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.VISIBLE
                binding.mapImage3.visibility = View.VISIBLE
                binding.mapImage4.visibility = View.GONE
            }
            4 -> {
                binding.mapsContents.text = getString(R.string.pool_area)
                binding.mapImage1.setImageResource(R.drawable.pool_area1)
                binding.mapImage2.setImageResource(R.drawable.pool_area2)
                binding.mapImage3.setImageResource(R.drawable.pool_area3)
                binding.mapImage4.setImageResource(R.drawable.pool_area4)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.VISIBLE
                binding.mapImage3.visibility = View.VISIBLE
                binding.mapImage4.visibility = View.VISIBLE
            }
            5-> {
                binding.mapsContents.text = getString(R.string.dining_hall)
                binding.mapImage1.setImageResource(R.drawable.image_not_available)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.GONE
                binding.mapImage3.visibility = View.GONE
                binding.mapImage4.visibility = View.GONE
            }
            6 -> {
                binding.mapsContents.text = getString(R.string.banquet_hall)
                binding.mapImage1.setImageResource(R.drawable.banquet_hall)
                binding.mapImage2.setImageResource(R.drawable.banquet_hall2)
                binding.mapImage1.visibility = View.VISIBLE
                binding.mapImage2.visibility = View.VISIBLE
                binding.mapImage3.visibility = View.GONE
                binding.mapImage4.visibility = View.GONE
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        binding.mapsContents.text = getString(R.string.fountain_area)
    }


}