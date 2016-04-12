package by.bsuir.timetable.desktop.service;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoggedState implements ObservableBooleanValue {

    private boolean loggedState;
    private List<ChangeListener<? super Boolean>> changeListeners = new ArrayList<>();

    @Override
    public boolean get() {
        return loggedState;
    }

    public void set(boolean value) {
        if (loggedState != value) {
            for (ChangeListener<? super Boolean> listener : changeListeners)
                listener.changed(this, loggedState, value);
            loggedState = value;
        }
        ;
    }

    @Override
    public void addListener(ChangeListener<? super Boolean> listener) {
        changeListeners.add(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super Boolean> listener) {
        changeListeners.remove(listener);
    }

    @Override
    public Boolean getValue() {
        return loggedState;
    }

    @Override
    public void addListener(InvalidationListener listener) {
        // invalidate state not present
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        // invalidate state not present
    }
}
