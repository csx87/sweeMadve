package com.example.sweemadve

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.CardDressFragmentBinding

class CardDressFragment: Fragment(R.layout.card_dress_fragment) {
    private lateinit var binding: CardDressFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardDressFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getInt("id")
        handleCardText(id)
    }

    fun handleCardText(id : Int){
        
        when(id){
            R.id.maayra -> {
                binding.cardFragmentText.text = getString(R.string.maayra)

            }

            R.id.baaleShastra -> {
                binding.cardFragmentText.text = getString(R.string.baaleShastra)
            }

            R.id.mehendi -> {
                binding.cardFragmentText.text = getString(R.string.mehendi)
            }

            R.id.sangeet -> {
                binding.cardFragmentText.text = getString(R.string.sangeet)
            }

            R.id.haldi -> {
                binding.cardFragmentText.text = getString(R.string.haldi)
            }

            R.id.baarat -> {
                binding.cardFragmentText.text = getString(R.string.baarat)
            }

            R.id.dhaare -> {
                binding.cardFragmentText.text = getString(R.string.dhaare)
            }

            R.id.bollywoodNight -> {
                binding.cardFragmentText.text = getString(R.string.bollywoodNight)
            }
            else -> Log.i("card","Invalid Option") //Toast

        }

    }
}