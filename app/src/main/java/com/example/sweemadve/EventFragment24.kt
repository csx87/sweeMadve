package com.example.sweemadve

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.example.sweemadve.databinding.EventsFragment24Binding

class EventFragment24:Fragment(R.layout.events_fragment_24) {
    var binding: EventsFragment24Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventsFragment24Binding.inflate(layoutInflater)
        handleCardClick(binding!!)
        return binding!!.root
    }

    private fun handleCardClick(binding: EventsFragment24Binding){

        var cardView: CardView? = null
        var hiddenGroup: Group? = null
        var arrow: ImageView?=null
        var headerView: View? = null
        var textView: TextView? = null

        //lunch 24
        cardView = binding.lunch24
        headerView = binding.lunch24ClickView
        hiddenGroup = binding.lunch24CardGroup
        arrow = binding.lunch24Arrow
        textView=binding.lunch24UpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //baale
        cardView = binding.baale
        headerView = binding.baaleClickView
        hiddenGroup = binding.baaleCardGroup
        arrow = binding.baaleArrow
        textView=binding.baaleUpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //mehendi
        cardView = binding.mehendi
        headerView = binding.mehendiClickView
        hiddenGroup = binding.mehendiCardGroup
        arrow = binding.mehendiArrow
        textView=binding.mehendiUpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //maayra
        cardView = binding.maayra
        headerView = binding.maayraClickView
        hiddenGroup=binding.maayraCardGroup
        arrow=binding.maayraArrow
        textView=binding.maayraUpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //snacks 24
        cardView = binding.snacks24
        headerView = binding.snacks24ClickView
        hiddenGroup = binding.snacks24CardGroup
        arrow=binding.snacks24Arrow
        textView=binding.snacks24UpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //sangeet
        cardView = binding.sangeet
        headerView = binding.sangeetClickView
        hiddenGroup = binding.sangeetCardGroup
        arrow=binding.sangeetArrow
        textView=binding.sangeetUpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //dinner
        cardView = binding.dinner24
        headerView = binding.dinner24ClickView
        hiddenGroup = binding.dinner24CardGroup
        arrow=binding.dinner24Arrow
        textView=binding.dinner24UpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)

        //Bollywood Party
        cardView = binding.bollywoodParty
        headerView = binding.bollywoodPartyClickView
        hiddenGroup = binding.bollywoodPartyCardGroup
        arrow=binding.bollywoodPartyArrow
        textView=binding.bollywoodPartyUpperTimings
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView)


    }

    private fun handleClickListener(cardView: CardView, clickView : View, hiddenGroup: Group, arrow: ImageView, textView: TextView){
        clickView.setOnClickListener{
            if(hiddenGroup.visibility == View.VISIBLE){
                hiddenGroup.visibility = View.GONE;
                //TransitionManager.beginDelayedTransition(cardView, AutoTransition());
                textView.alpha = 0.0f;
                textView.visibility = View.VISIBLE;
                textView.animate().setDuration(200).alpha(1F).setInterpolator(AccelerateInterpolator()).start()
                arrow.setImageResource(android.R.drawable.arrow_down_float)
            }
            else {
                textView.visibility = TextView.GONE
                TransitionManager.beginDelayedTransition(cardView, AutoTransition());
                hiddenGroup.visibility = View.VISIBLE;
                arrow.setImageResource(android.R.drawable.arrow_up_float);
            }
        }
    }


}