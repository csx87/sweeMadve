package com.example.sweemadve

import android.app.Activity
import android.graphics.BitmapShader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.sweemadve.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView
import java.util.ArrayDeque
import kotlin.system.exitProcess

//import androidx.fragment.app.Fragment

var stack = ArrayDeque<String>()

lateinit var bottomNavigationView: NavigationBarView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.fragmentContainerView)
            }
        }



        bottomNavigationView = findViewById<NavigationBarView>(R.id.bottom_navigation)



        bottomNavigationView.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.home -> {

                    //Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.commit {
                        replace<HomeFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("home")
                    }
                    manageStack("H")
                    //supportFragmentManager.clearBackStack()
                    true
                }

                R.id.maps -> {

                    //manageBackStack()
                    supportFragmentManager.commit {
                        replace<MapsFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("maps") // name can be null


                    }
                    manageStack("M")

                    true
                }

                R.id.food -> {

                        supportFragmentManager.commit {
                        replace<FoodFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("food") // name can be nul
                    }
                    manageStack("F")
                    true
                }

                R.id.dress -> {

                    supportFragmentManager.commit {
                        replace<DressFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("dress") // name can be null

                    }
                    manageStack("D")
                    true
                }
                else -> false

            }

        }



    }

    //Adding more menu to navigation bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.upper_more_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {


        printStack()
        if(stack.size > 0){
            if(stack.size > 1) {
                stack.pop()
                val fragment = stack.peek()
                if (fragment.equals("H")) {
                    bottomNavigationView.selectedItemId = R.id.home
                }

                else if (fragment.equals("M")) {
                    bottomNavigationView.selectedItemId = R.id.maps

                }


                else if (fragment.equals("F")) {
                    bottomNavigationView.selectedItemId = R.id.food

                }

                else if (fragment.equals("D")) {
                    bottomNavigationView.selectedItemId = R.id.dress
                }
            }

            else if(stack.size == 1){
                val fragment = stack.peek()
                if(fragment.equals("H")){
                    finish()

                }
                else{
                    bottomNavigationView.selectedItemId = R.id.home
                    supportFragmentManager.commit {
                        replace<HomeFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("home")
                    }
                    stack.clear()
                }
            }
        }

        else{
            //exit_app
            finish()
        }
        printStack()
        //super.onBackPressed()
    }

    private fun manageStack(fragment : String) {
                stack.remove(fragment)
                stack.push(fragment)
    }

    private fun printStack(){
        for (item in stack){
            Log.i("Stack:",item)
        }
    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }
}

