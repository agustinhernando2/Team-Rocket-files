package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.team_rocket_unc.electronica_digital_app.R;

public class ValueSelector implements Subject {

    LinearLayout valueLayout;
    Spinner standardResistor;

    public ValueSelector(View view) {
        valueLayout = view.findViewById(R.id.resistorValueInput);
        standardResistor = view.findViewById(R.id.inputStandardResistorDDB);
        ArrayAdapter<CharSequence> standardResistorAdapter = ArrayAdapter.createFromResource(
                view.getContext(), R.array.standard_resistors, android.R.layout.simple_spinner_item);
        standardResistor.setAdapter(standardResistorAdapter);

        standardResistor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ResistorInfo resistorInfo = new ResistorInfo(adapterView.getItemAtPosition(i).toString());
                notifyObservers(resistorInfo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        resetSelection();
    }

    public void setVisible(int visibility) {
        valueLayout.setVisibility(visibility);
    }

    public void resetSelection() {
        notifyObservers(new ResistorInfo("10k\u03A9 \u00B15%"));
        standardResistor.setSelection(69);
    }

    @Override
    public void notifyObservers(ResistorInfo resistor) {
        for (Observer observer : observers) {
            observer.update(resistor);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

}
