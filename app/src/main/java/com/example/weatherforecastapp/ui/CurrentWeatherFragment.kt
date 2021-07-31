package com.example.weatherforecastapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.weatherforecastapp.R
import com.example.weatherforecastapp.databinding.FragmentCurrentWeather2Binding
import com.example.weatherforecastapp.databinding.FragmentCurrentWeatherBinding
import com.example.weatherforecastapp.util.Constants.TAG
import com.example.weatherforecastapp.viewmodel.CurrentWeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_current_weather.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

/**
 *
 *
 */
@AndroidEntryPoint
class CurrentWeatherFragment : Fragment() {

    private val viewModel by viewModels<CurrentWeatherViewModel>()
    //private lateinit var binding: FragmentCurrentWeatherBinding
    private lateinit var binding: FragmentCurrentWeather2Binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_current_weather2, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvLocation.text = "Taipei"
    }


    /*
    private fun bindUi() {
        lifecycleScope.launch {
            val currentWeatherDeferred = async { viewModel.getCurrentWeather() }
            val currentWeather = currentWeatherDeferred.await()

            val locationDeferred = async { viewModel.getWeatherLocation() }
            val weatherLocation = locationDeferred.await()

            withContext(Main) {
                weatherLocation.observe(viewLifecycleOwner) { weatherLocation ->
                    if (weatherLocation == null) return@observe
                    updateLocation(weatherLocation.name)
                }


                currentWeather.observe(viewLifecycleOwner) {
                    if (it == null) {
                        Log.e(TAG, "bindUI: current weather is null")
                        return@observe
                    }

                    toggleLoadingVisibility()
                    updateDateToToday()
                    updateTemperatures(it.temperature, it.feelslike)
                    updateCondition(it.weather_descriptions[0])
                    updatePrecipitation(it.precip)
                    updateWind(it.wind_dir, it.wind_speed)
                    updateVisibility(it.visibility)

                    // Glide...
                    Glide.with(binding.ivCondition)
                            .load(it.weather_icons[0])
                            .into(binding.ivCondition)

                }
            }


        }

    }*/

//    private fun toggleLoadingVisibility() {
//        binding.pbLoading.visibility = GONE
//        binding.tvLoading.visibility = GONE
//    }
//
//    private fun chooseUnits(metric: String, imperial: String): String { // return different units
//        return if (viewModel.isMetric) metric else imperial
//    }
//
//    // update location shown in ActionBar
//    private fun updateLocation(location: String) {
//        (activity as? AppCompatActivity)?.supportActionBar?.title = location
//    }
//
//    // update date as 'Today' shown in ActionBar
//    private fun updateDateToToday() {
//        (activity as? AppCompatActivity)?.supportActionBar?.subtitle = "Today"
//    }
//
//    private fun updateTemperatures(temperature: Int, feelsLike: Int) {
//        val unit = chooseUnits("°C", "°F")
//        binding.tvTemperature.text = "$temperature$unit"
//        binding.tvFeelsLikeTemperature.text = "Feels like $feelsLike$unit"
//    }
//
//    private fun updateCondition(condition: String) {
//        binding.tvCondition.text = condition
//    }
//
//    private fun updatePrecipitation(precipitationVolume: Double) {
//        val unit = chooseUnits("mm", "in")
//        binding.tvRainFall.text = "Preciptiation: $precipitationVolume $unit"
//    }
//
//    private fun updateWind(windDirection: String, windSpeed: Int) {
//        val unit = chooseUnits("kph", "mph")
//        binding.tvWind.text = "Wind: $windDirection, $windSpeed $unit"
//    }
//
//    private fun updateVisibility(visibilityDistance: Int) {
//        val unit = chooseUnits("km", "mi.")
//        binding.tvVisibility.text = "Visibility: $visibilityDistance $unit"
//    }






}