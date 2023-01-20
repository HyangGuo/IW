package it.unimi.di.sweng.lab12;

import org.jetbrains.annotations.NotNull;

public interface Observable {
    void notifyObservers();

    void addObserver(@NotNull Observer obs);
}
