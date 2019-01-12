package me.mfathy.weather.forcast.domain.interactor;

import com.fernandocejas.arrow.checks.Preconditions;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Mohammed Fathy on 14/09/2018.
 * dev.mfathy@gmail.com
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 */
public abstract class UseCase<T, P> {

    private final CompositeDisposable disposables;


    public UseCase(CompositeDisposable disposables) {
        this.disposables = disposables;
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link UseCase}.
     */
    abstract Observable<T> buildUseCaseObservable(P params);

    /**
     * Executes the current use case.
     *
     * @return Observable
     */
    public Observable<T> execute(P params) {
        return this.buildUseCaseObservable(params);
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void addDisposable(Disposable disposable) {
        Preconditions.checkNotNull(disposable);
        Preconditions.checkNotNull(disposables);
        disposables.add(disposable);
    }
}


