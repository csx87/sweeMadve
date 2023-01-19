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

            }

            R.id.baaleShastra -> {
                binding.cardDressHeading.text ="Bale Shastra"
                binding.cardDressMenContents.text = getString(R.string.baaleShastraMenContents)
                binding.cardDressWomenContents.text = getString(R.string.baaleShastraWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.baale_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.baale_women)
                binding.cardDressTimings.text = getString(R.string.baaleShastraTimings)
                binding.cardDressSlogan.text = getString(R.string.baaleShastraSlogan)
            }

            R.id.mehendi -> {
                binding.cardDressHeading.text ="Mehendi"
                binding.cardDressMenContents.text = getString(R.string.mehendiMenContents)
                binding.cardDressWomenContents.text = getString(R.string.mehendiWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.mehendi_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.mehendi_women)
                binding.cardDressTimings.text = getString(R.string.mehendiTimings)
                binding.cardDressSlogan.text = getString(R.string.mehendiSlogan)
            }

            R.id.sangeet -> {
                binding.cardDressHeading.text ="Sangeet"
                binding.cardDressMenContents.text = getString(R.string.sangeetMenContents)
                binding.cardDressWomenContents.text = getString(R.string.sangeetWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.sangeet_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.sangeet_women)
                binding.cardDressTimings.text = getString(R.string.sangeetTimings)
                binding.cardDressSlogan.text = getString(R.string.sangeetSlogan)
            }

            R.id.haldi -> {
                binding.cardDressHeading.text ="Haldi"
                binding.cardDressMenContents.text = getString(R.string.haldiMenContents)
                binding.cardDressWomenContents.text = getString(R.string.haldiWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.haldi_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.haldi_women)
                binding.cardDressTimings.text = getString(R.string.haldiTimings)
                binding.cardDressSlogan.text = getString(R.string.haldiSlogan)
            }

            R.id.baarat -> {
                binding.cardDressHeading.text ="Baarat"
                binding.cardDressMenContents.text = getString(R.string.baaratMenContents)
                binding.cardDressWomenContents.text = getString(R.string.baaratWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.baarat_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.baarat_women)
                binding.cardDressTimings.text = getString(R.string.baaratTimings)
                binding.cardDressSlogan.text = getString(R.string.baaratSlogan)
            }

            R.id.dhaare -> {
                binding.cardDressHeading.text ="Dhaare"
                binding.cardDressMenContents.text = getString(R.string.dhaareMenContents)
                binding.cardDressWomenContents.text = getString(R.string.dhaareWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.dhaare_men)
                binding.cardDressWomenImage.setImageResource(R.drawable.dhaare_women)
                binding.cardDressTimings.text = getString(R.string.dhaareTimings)
                binding.cardDressSlogan.text = getString(R.string.dhaareSlogan)
                binding.random.textSize = 10F
            }

            R.id.bollywoodParty -> {
                binding.cardDressHeading.text ="Dhaare"
                binding.cardDressMenContents.text = getString(R.string.bollywoodNightMenContents)
                binding.cardDressWomenContents.text = getString(R.string.bollywoodNightWomenContents)
                binding.cardDressMenImage.setImageResource(R.drawable.bollywoodnight_men2)
                binding.cardDressWomenImage.setImageResource(R.drawable.bollywoodnight_women2)
                binding.cardDressTimings.text = getString(R.string.bollywoodNightTimings)
                binding.cardDressSlogan.text = getString(R.string.bollywoodNightSlogan)
                binding.random.textSize = 10F
            }
            else -> Log.i("card","Invalid Option") //Toast

        }

    }
}