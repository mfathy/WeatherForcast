package me.mfathy.weather.forcast.ui.forecast

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_forecast.*
import me.mfathy.weather.forcast.R
import me.mfathy.weather.forcast.domain.model.Forecast
import me.mfathy.weather.forcast.exception.ErrorMessageFactory
import me.mfathy.weather.forcast.injection.ViewModelFactory
import me.mfathy.weather.forcast.state.Resource
import me.mfathy.weather.forcast.state.ResourceState
import javax.inject.Inject

class ForecastActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var forecastViewModel: ForecastViewModel

    private lateinit var forecastAdapter: ForecastAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        AndroidInjection.inject(this)

        forecastViewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ForecastViewModel::class.java)

        val layoutManager = LinearLayoutManager(this)
        forecastAdapter = ForecastAdapter()
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = forecastAdapter

    }

    override fun onStart() {
        super.onStart()

        //  observe changes in articles data.
        forecastViewModel.forecastMutableLiveData.observe(this,
            android.arch.lifecycle.Observer<Resource<Forecast>> {
                it?.let { resource ->
                    handleForecastResult(resource)
                }
            })

        val time = intent.getStringExtra(KEY_TIME_RANGE)
        val city = intent.getStringExtra(KEY_CITY_KEY)

        forecastViewModel.fetchForecasts(Schedulers.io(), AndroidSchedulers.mainThread(), city, time)
    }

    private fun handleForecastResult(resource: Resource<Forecast>) {
        when {
            resource.status == ResourceState.SUCCESS -> resource.data?.let {
                title = it.headline
                forecastAdapter.mForecasts = it.dailyForecasts
                forecastAdapter.notifyDataSetChanged()

                recyclerView.visibility = View.VISIBLE
                errorTextView.visibility = View.INVISIBLE
                progressBar.visibility = View.INVISIBLE
            }
            resource.status == ResourceState.ERROR -> resource.error?.let{
                errorTextView.text = ErrorMessageFactory.create(this, it)
                recyclerView.visibility = View.INVISIBLE
                errorTextView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
            }
            resource.status == ResourceState.LOADING -> {
                recyclerView.visibility = View.INVISIBLE
                errorTextView.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        const val KEY_TIME_RANGE = "KEY_TIME_RANGE"
        const val KEY_CITY_KEY = "KEY_CITY_KEY"
    }
}
