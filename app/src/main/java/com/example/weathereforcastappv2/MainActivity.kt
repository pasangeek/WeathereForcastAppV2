package com.example.weathereforcastappv2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.weathereforcastappv2.databinding.ActivityMainBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
            //binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


      setContentView(binding.root)

     navController = Navigation.findNavController(this,R.id.nav_host_fragment_container)

setupWithNavController(binding.bottomNav,navController)



    }
}