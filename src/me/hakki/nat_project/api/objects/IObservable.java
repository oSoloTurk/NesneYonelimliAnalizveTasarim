package me.hakki.nat_project.api.objects;

public interface IObservable<T> {
    void observe(final IObserver observer);
    void notifyObservers(T value);
}
