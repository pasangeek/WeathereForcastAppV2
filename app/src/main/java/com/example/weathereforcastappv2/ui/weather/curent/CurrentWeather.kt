package com.example.weathereforcastappv2.ui.weather.curent

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.textInputServiceFactory
import com.example.weathereforcastappv2.R
import com.example.weathereforcastappv2.data.ApixuWeatherApiService
import com.example.weathereforcastappv2.data.response.CurrentWeatherResponse
import com.example.weathereforcastappv2.databinding.ActivityMainBinding
import com.example.weathereforcastappv2.databinding.FragmentCurrentWeatherBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeather : Fragment() {
private  lateinit var binding: FragmentCurrentWeatherBinding
    companion object {
        fun newInstance() = CurrentWeather()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
   binding = FragmentCurrentWeatherBinding.inflate(inflater,container,false)
      val root: View = binding.root

        //return inflater.inflate(R.layout.fragment_current_weather, container, false)
return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = ApixuWeatherApiService()
        GlobalScope.launch (Dispatchers.Main){
            val currentWeatherResponse = apiService.getCurrentWeather("London").await()

          //  var textView1 = view?.findViewById<TextureView>(R.id.textViewCurrentweather)


     binding.textViewCurrentWeather.text= currentWeatherResponse.current.toString()


        }


    }

}