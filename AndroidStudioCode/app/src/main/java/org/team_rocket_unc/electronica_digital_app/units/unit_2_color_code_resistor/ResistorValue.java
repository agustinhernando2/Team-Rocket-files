package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.team_rocket_unc.electronica_digital_app.R;

public class ResistorValue implements Observer {

    private final TextView outputValue;

    public ResistorValue(View view) {
        outputValue = view.findViewById(R.id.resistorOutput);
    }

    @Override
    public void update(ResistorInfo resistorInfo) {
        outputValue.setText(resistorInfo.getValue());
    }

}
