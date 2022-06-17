package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import java.util.ArrayList;
import java.util.List;

public interface Subject {

    List<Observer> observers = new ArrayList<>();

    void notifyObservers(ResistorInfo resistorInfo);

    void addObserver(Observer observers);

    void setVisible(int visible);

}
