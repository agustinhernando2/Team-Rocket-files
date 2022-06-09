package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.team_rocket_unc.electronica_digital_app.R;

import java.util.List;

public class ColorSelector implements Subject {

    LinearLayout colorInput;
    Spinner colorBand1;
    Spinner colorBand2;
    Spinner colorBand3;
    Spinner colorBand4;

    public ColorSelector(View view) {
        colorInput = view.findViewById(R.id.resistorColorInput);
        colorBand1 = getBand(view, R.id.inputColorBand1DDB, BandColorAdaptor.getFirstBandColors());
        colorBand2 = getBand(view, R.id.inputColorBand2DDB, BandColorAdaptor.getSecondBandColors());
        colorBand3 = getBand(view, R.id.inputColorBand3DDB, BandColorAdaptor.getPartialBandColors());
        colorBand4 = getBand(view, R.id.inputColorBand4DDB, BandColorAdaptor.getSpecialBandColors());
        setListener(colorBand1);
        setListener(colorBand2);
        setListener(colorBand3);
        setListener(colorBand4);
        resetSelection();
    }

    private Spinner getBand(View view, int bandId, List<Integer> colors) {
        Spinner band = view.findViewById(bandId);
        BandColorAdaptor fullBandAdapter = new BandColorAdaptor(view.getContext(), colors);
        band.setAdapter(fullBandAdapter);
        return band;
    }

    private void setListener(Spinner band) {
        band.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int color1 = (int) colorBand1.getSelectedItem();
                int color2 = (int) colorBand2.getSelectedItem();
                int color3 = (int) colorBand3.getSelectedItem();
                int color4 = (int) colorBand4.getSelectedItem();
                ResistorInfo resistorInfo = new ResistorInfo(color1, color2, color3, color4);
                notifyObservers(resistorInfo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void setVisible(int visibility) {
        colorInput.setVisibility(visibility);
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

    public void resetSelection() {
        colorBand1.setSelection(0);
        colorBand2.setSelection(0);
        colorBand3.setSelection(3);
        colorBand4.setSelection(0);
        notifyObservers(new ResistorInfo(R.color.BROWN, R.color.black, R.color.ORANGE, R.color.GOLD));
    }

}
