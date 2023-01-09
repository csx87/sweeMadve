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

import com.example.sweemadve.databinding.EventsFragment25Binding

class EventFragment25: Fragment(R.layout.events_fragment_25) {
    private var binding: EventsFragment25Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventsFragment25Binding.inflate(layoutInflater)
        handleCardClick(binding!!)
        return binding!!.root
    }


    private fun handleCardClick(binding: EventsFragment25Binding) {

        var cardView: CardView? = null
        var hiddenGroup: Group? = null
        var arrow: ImageView? = null
        var headerView: View? = null
        var textView: TextView? = null
        var textView2: TextView? = null

        cardView = binding.breakfast25
        headerView = binding.breakfast25ClickView
        hiddenGroup = binding.breakfast25CardGroup
        arrow = binding.breakfast25Arrow
        textView=binding.breakfast25UpperTimings
        textView2 = binding.breakfast25UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.haldi
        headerView = binding.haldiClickView
        hiddenGroup = binding.haldiCardGroup
        arrow = binding.haldiArrow
        textView=binding.haldiUpperTimings
        textView2 = binding.haldiUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.lunch25
        headerView = binding.lunch25ClickView
        hiddenGroup = binding.lunch25CardGroup
        arrow = binding.lunch25Arrow
        textView=binding.lunch25UpperTimings
        textView2 = binding.lunch25UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.baarat
        headerView = binding.baaratClickView
        hiddenGroup = binding.baaratCardGroup
        arrow = binding.baaratArrow
        textView=binding.baaratUpperTimings
        textView2 = binding.baaratUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.snacks25
        headerView = binding.snacks25ClickView
        hiddenGroup = binding.snacks25CardGroup
        arrow = binding.snacks25Arrow
        textView=binding.snacks25UpperTimings
        textView2 = binding.snacks25UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.phere
        headerView = binding.phereClickView
        hiddenGroup = binding.phereCardGroup
        arrow = binding.phereArrow
        textView=binding.phereUpperTimings
        textView2 = binding.phereUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)
        cardView = binding.dinner25
        headerView = binding.dinner25ClickView
        hiddenGroup = binding.dinner25CardGroup
        arrow = binding.dinner25Arrow
        textView=binding.dinner25UpperTimings
        textView2 = binding.dinner25UpperVenue
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

                textView2.animate().setDuration(200).alpha(1F).setInterpolator(
                    AccelerateInterpolator()
                ).start()
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