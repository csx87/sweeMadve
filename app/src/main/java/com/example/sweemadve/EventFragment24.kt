package com.example.sweemadve

import android.os.Bundle
import android.text.method.LinkMovementMethod
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

        //Make article linkable
        binding!!.lunch24Contents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.baaleContents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.mehendiContents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.maayraContents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.snacks24Contents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.sangeetContents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.dinner24Contents.movementMethod = LinkMovementMethod.getInstance()
        binding!!.bollywoodPartyContents.movementMethod = LinkMovementMethod.getInstance()

        return binding!!.root
    }

    private fun handleCardClick(binding: EventsFragment24Binding){

        var cardView: CardView? = null
        var hiddenGroup: Group? = null
        var arrow: ImageView?=null
        var headerView: View? = null
        var textView: TextView? = null
        var textView2: TextView? = null

        //lunch 24
        cardView = binding.lunch24
        headerView = binding.lunch24ClickView
        hiddenGroup = binding.lunch24CardGroup
        arrow = binding.lunch24Arrow
        textView=binding.lunch24UpperTimings
        textView2 = binding.lunch24UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //baale
        cardView = binding.baale
        headerView = binding.baaleClickView
        hiddenGroup = binding.baaleCardGroup
        arrow = binding.baaleArrow
        textView=binding.baaleUpperTimings
        textView2 = binding.baaleUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //mehendi
        cardView = binding.mehendi
        headerView = binding.mehendiClickView
        hiddenGroup = binding.mehendiCardGroup
        arrow = binding.mehendiArrow
        textView=binding.mehendiUpperTimings
        textView2 = binding.mehendiUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //maayra
        cardView = binding.maayra
        headerView = binding.maayraClickView
        hiddenGroup=binding.maayraCardGroup
        arrow=binding.maayraArrow
        textView=binding.maayraUpperTimings
        textView2=binding.maayraUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //snacks 24
        cardView = binding.snacks24
        headerView = binding.snacks24ClickView
        hiddenGroup = binding.snacks24CardGroup
        arrow=binding.snacks24Arrow
        textView=binding.snacks24UpperTimings
        textView2=binding.snacks24UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //sangeet
        cardView = binding.sangeet
        headerView = binding.sangeetClickView
        hiddenGroup = binding.sangeetCardGroup
        arrow=binding.sangeetArrow
        textView=binding.sangeetUpperTimings
        textView2=binding.sangeetUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //dinner
        cardView = binding.dinner24
        headerView = binding.dinner24ClickView
        hiddenGroup = binding.dinner24CardGroup
        arrow=binding.dinner24Arrow
        textView=binding.dinner24UpperTimings
        textView2=binding.dinner24UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        //Bollywood Party
        cardView = binding.bollywoodParty
        headerView = binding.bollywoodPartyClickView
        hiddenGroup = binding.bollywoodPartyCardGroup
        arrow=binding.bollywoodPartyArrow
        textView=binding.bollywoodPartyUpperTimings
        textView2=binding.bollywoodPartyUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)


    }

    private fun handleClickListener(cardView: CardView, clickView : View, hiddenGroup: Group, arrow: ImageView, textView: TextView, textView2: TextView){
        clickView.setOnClickListener{
            if(hiddenGroup.visibility == View.VISIBLE){
                hiddenGroup.visibility = View.GONE;
                //TransitionManager.beginDelayedTransition(cardView, AutoTransition());
                textView.alpha = 0.0f;
                textView.visibility = View.VISIBLE;
                textView2.alpha = 0.0f;
                textView2.visibility = View.VISIBLE;

                textView2.animate().setDuration(200).alpha(1F).setInterpolator(AccelerateInterpolator()).start()
                textView.animate().setDuration(200).alpha(1F).setInterpolator(AccelerateInterpolator()).start()

                arrow.setImageResource(android.R.drawable.arrow_down_float)
            }
            else {
                textView.visibility = View.GONE;
                textView2.visibility = View.GONE;

                TransitionManager.beginDelayedTransition(cardView, AutoTransition());
                hiddenGroup.visibility = View.VISIBLE;
                arrow.setImageResource(android.R.drawable.arrow_up_float);
            }
        }
    }


}