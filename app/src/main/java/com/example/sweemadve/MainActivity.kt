package com.example.sweemadve


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationBarView
import java.util.*


//import androidx.fragment.app.Fragment

var stack = ArrayDeque<String>()

lateinit var bottomNavigationView: NavigationBarView


class MainActivity : AppCompatActivity() {
    private lateinit var savedFragment: Fragment.SavedState;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
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

                R.id.events -> {

                    //Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.commit {
                        replace<EventsFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        //addToBackStack("home")
                    }
                    manageStack("E")
                    //supportFragmentManager.clearBackStack()
                    true
                }



                R.id.maps -> {

                    //manageBackStack()
                    val random: String = "random"
                    val bundle = bundleOf("v" to null)
                    supportFragmentManager.commit {
                        replace<MapsFragment>(R.id.fragmentContainerView,args = bundle)
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
        if(!supportFragmentManager.popBackStackImmediate())
        {
        printStack()
        if(stack.size > 0){
            if(stack.size > 1) {
                stack.pop()
                val fragment = stack.peek()
                if (fragment.equals("H")) {
                    bottomNavigationView.selectedItemId = R.id.home
                }

                else if (fragment.equals("E")) {
                    bottomNavigationView.selectedItemId = R.id.events
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

    //Dress_Code_click
     fun exampleClick(v :View){
         val bundle = bundleOf("id" to v.id)
        supportFragmentManager.commit {
            replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
            setReorderingAllowed(true)
            addToBackStack("dress")
        }
         //handleCardText(v)
    }

    fun venueClickEvent(v : View){
        val currentFragment:EventsFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as EventsFragment
        val text = findViewById<TextView>(R.id.eventsDateText).text as String
        Log.i("text",text)
        when(text){
            "25 Jan" -> currentFragment.savedText = "25 Jan"
        }
        val textView: TextView = findViewById<TextView>(v.id)
        bottomNavigationView.selectedItemId = R.id.maps

        //val string : String = textView.text as String
        var string : String? =null
        string = handleSelectedVenue(textView.text)
        val bundle = bundleOf("v" to string)
        supportFragmentManager.commit {
            replace<MapsFragment>(R.id.fragmentContainerView, args = bundle )
            setReorderingAllowed(true)
        }
        manageStack("M")



    }

    fun customTab360(v: View){
        val URI = "https://www.mirayagreens.com/360/"
        val package_name = "com.android.chrome";

        val builder = CustomTabsIntent.Builder()

        val params = CustomTabColorSchemeParams.Builder()
        //params.setToolbarColor(ContextCompat.getColor(this.root, R.color.colorPrimary))
        //builder.setDefaultColorSchemeParams(params.build())
        builder.setShowTitle(true)
        builder.setInstantAppsEnabled(true)

        val customBuilder = builder.build()

        customBuilder.intent.setPackage(package_name)
        customBuilder.launchUrl(this, Uri.parse(URI))



    }

    //event_page_dress_code_redirection
 fun dressCodeClickEvent(v: View){
     val currentFragment:EventsFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as EventsFragment
     when(v.id){
         R.id.baaleDressCode -> {
             currentFragment.savedText = "24 Jan"
             val bundle = bundleOf("id" to R.id.baaleShastra)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.maayraDressCode -> {
             currentFragment.savedText = "24 Jan"
             val bundle = bundleOf("id" to R.id.maayra)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.mehendiDressCode -> {
             currentFragment.savedText = "24 Jan"
             val bundle = bundleOf("id" to R.id.mehendi)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.sangeetDressCode -> {
             currentFragment.savedText = "24 Jan"
             val bundle = bundleOf("id" to R.id.sangeet)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.bollywoodPartyDressCode -> {
             currentFragment.savedText = "24 Jan"
             val bundle = bundleOf("id" to R.id.bollywoodParty)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.haldiDressCode -> {
             currentFragment.savedText = "25 Jan"
             val bundle = bundleOf("id" to R.id.haldi)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.baaratDressCode -> {
             currentFragment.savedText = "25 Jan"
             val bundle = bundleOf("id" to R.id.baarat)
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.phereDressCode -> {
             currentFragment.savedText = "25 Jan"
             val bundle = bundleOf("id" to R.id.baarat) //baarat phere same dress code
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

         R.id.dhaareDressCode -> {
             currentFragment.savedText = "26 Jan"
             val bundle = bundleOf("id" to R.id.dhaare) //baarat phere same dress code
             supportFragmentManager.commit {
                 replace<CardDressFragment>(R.id.fragmentContainerView, args = bundle )
                 setReorderingAllowed(true)
                 addToBackStack("dress")
             }
         }

     }
 }

    private fun handleSelectedVenue(text: CharSequence?):String?{
        if(text!=null){
            val str1: String = text.toString()
            if(str1.contains("Pav".toString())) return "Pav"
            else if(str1.contains("Fou".toString())) return "Fou"
            else if(str1.contains("Bam".toString())) return "Bam"
            else if(str1.contains("Poo".toString())) return "Poo"
            else if(str1.contains("Mai".toString())) return "Mai"
            else if(str1.contains("Din".toString())) return "Din"
            else if(str1.contains("BAn".toString())) return "Ban"
        }
        return null
    }



}

