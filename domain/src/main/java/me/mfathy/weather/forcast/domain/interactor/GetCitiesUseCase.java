package me.mfathy.weather.forcast.domain.interactor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import me.mfathy.weather.forcast.domain.ForecastsRepository;
import me.mfathy.weather.forcast.domain.model.City;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mohammed Fathy on 12/01/2019.
 * dev.mfathy@gmail.com
 */
public class GetCitiesUseCase extends UseCase<List<City>, GetCitiesUseCase.Params> {

    private ForecastsRepository mRepository;

    @Inject
    public GetCitiesUseCase(CompositeDisposable disposables, ForecastsRepository repository) {
        super(disposables);

        this.mRepository = repository;
    }

    @Override
    Observable<List<City>> buildUseCaseObservable(Params params) {
        return mRepository.getCities();
    }

    public static class Params{
        String cityKey;

        public Params(String cityKey) {
            this.cityKey = cityKey;
        }
    }
}
