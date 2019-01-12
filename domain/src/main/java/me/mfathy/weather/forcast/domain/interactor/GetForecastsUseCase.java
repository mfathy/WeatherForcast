package me.mfathy.weather.forcast.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.Forecast;

import javax.inject.Inject;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class GetForecastsUseCase extends UseCase<Forecast, GetForecastsUseCase.Params> {

    private ForecastsRepository mRepository;

    @Inject
    public GetForecastsUseCase(CompositeDisposable disposables, ForecastsRepository repository) {
        super(disposables);
        this.mRepository = repository;
    }

    @Override
    Observable<Forecast> buildUseCaseObservable(Params params) {
        if (params == null) throw new IllegalArgumentException("Params cannot be null");
        return mRepository.getForecasts(params.timeRange, params.cityKey);
    }

    public static class Params{
        String cityKey;
        String timeRange;

        public Params(String cityKey, String timeRange) {
            this.cityKey = cityKey;
            this.timeRange = timeRange;
        }
    }
}
