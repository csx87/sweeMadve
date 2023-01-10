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
import com.example.sweemadve.databinding.EventsFragment25Binding
import com.example.sweemadve.databinding.EventsFragment26Binding

class EventFragment26:Fragment(R.layout.events_fragment_26) {
    private var binding: EventsFragment26Binding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EventsFragment26Binding.inflate((layoutInflater))
        handleCardClick(binding!!)
        return binding!!.root
    }

    private fun handleCardClick(binding: EventsFragment26Binding) {

        var cardView: CardView? = null
        var hiddenGroup: Group? = null
        var arrow: ImageView? = null
        var headerView: View? = null
        var textView: TextView? = null
        var textView2: TextView? = null

        cardView = binding.breakfast26
        headerView = binding.breakfast26ClickView
        hiddenGroup = binding.breakfast26CardGroup
        arrow = binding.breakfast26Arrow
        textView=binding.breakfast26UpperTimings
        textView2 = binding.breakfast26UpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.dhaare
        headerView = binding.dhaareClickView
        hiddenGroup = binding.dhaareCardGroup
        arrow = binding.dhaareArrow
        textView=binding.dhaareUpperTimings
        textView2 = binding.dhaareUpperVenue
        handleClickListener(cardView,headerView,hiddenGroup,arrow,textView,textView2)

        cardView = binding.lunch26
        headerView = binding.lunch26ClickView
        hiddenGroup = binding.lunch26CardGroup
        arrow = binding.lunch26Arrow
        textView=binding.lunch26UpperTimings
        textView2 = binding.lunch26UpperVenue
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