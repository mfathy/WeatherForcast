package me.mfathy.weather.forcast.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.mfathy.weather.forcast.R
import me.mfathy.weather.forcast.domain.model.City
import me.mfathy.weather.forcast.exception.ErrorMessageFactory
import me.mfathy.weather.forcast.injection.ViewModelFactory
import me.mfathy.weather.forcast.state.Resource
import me.mfathy.weather.forcast.state.ResourceState
import me.mfathy.weather.forcast.ui.forecast.ForecastActivity
import me.mfathy.weather.forcast.ui.forecast.ForecastActivity.Companion.KEY_CITY_KEY
import me.mfathy.weather.forcast.ui.forecast.ForecastActivity.Companion.KEY_TIME_RANGE
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var mainViewModel: MainViewModel

    lateinit var autoCompleteAdapter: AutoCompleteCityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        mainViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MainViewModel::class.java)

        radiosTimeRange.check(radioButton_one_forecast.id)
    }

    override fun onStart() {
        super.onStart()

        //  observe changes in articles data.
        mainViewModel.citiesMutableLiveData.observe(this,
            android.arch.lifecycle.Observer<Resource<List<City>>> {
                it?.let { resource ->
                    handleCitiesResult(resource)
                }
            })

        mainViewModel.fetchCities(Schedulers.io(), AndroidSchedulers.mainThread())
    }

    fun showWeatherInfo(view: View) {
        if (view.id == R.id.buttonShowWeather) {
            val timeRange = getCheckedTimeRange(radiosTimeRange.checkedRadioButtonId)
            val cityKey = autoCompleteTextCityName.selectedItem as City
            val intent = Intent(this, ForecastActivity::class.java)
            intent.putExtra(KEY_TIME_RANGE, timeRange)
            intent.putExtra(KEY_CITY_KEY, cityKey.key)
            startActivity(intent)
        }
    }

    private fun getCheckedTimeRange(checkedRadioButtonId: Int): String {
        return when (checkedRadioButtonId) {
            R.id.radioButton_one_forecast -> "1day"
            R.id.radioButton_five_forecast -> "5day"
            R.id.radioButton_ten_forecast -> "10day"
            R.id.radioButton_fifteen_forecast -> "15day"
            else -> "1day"
        }
    }

    private fun handleCitiesResult(resource: Resource<List<City>>) {

        when {
            resource.status == ResourceState.ERROR -> resource.error?.let {
                val snackbar =
                    Snackbar.make(contentView, ErrorMessageFactory.create(this, it), Snackbar.LENGTH_INDEFINITE)
                snackbar.show()
                snackbar.setAction(getString(R.string.retry)) {
                    mainViewModel.fetchCities(Schedulers.io(), AndroidSchedulers.mainThread())
                    snackbar.dismiss()
                }

            }
            resource.status == ResourceState.SUCCESS -> resource.data?.let { cities ->
                autoCompleteAdapter = AutoCompleteCityAdapter(this, R.layout.view_auto_complete_item, cities)
                autoCompleteTextCityName.adapter = autoCompleteAdapter
            }
            resource.status == ResourceState.LOADING -> {
            }
        }

    }
}
