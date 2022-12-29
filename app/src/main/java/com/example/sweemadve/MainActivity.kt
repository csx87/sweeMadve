package com.example.sweemadve

import android.graphics.BitmapShader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater

//import androidx.fragment.app.Fragment



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Adding more menu to navigation bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.upper_more_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

}

