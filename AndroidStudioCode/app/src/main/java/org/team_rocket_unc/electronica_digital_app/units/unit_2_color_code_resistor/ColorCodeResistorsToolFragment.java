package org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;

public class ColorCodeResistorsToolFragment extends Fragment {

    View view;
    Spinner resistorInputMode;

    ResistorValue resistorValue;
    ResistorGraph resistorGraph;

    ColorSelector colorSelector;
    ValueSelector valueSelector;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u2_p1_color,container,false);
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        resistorInputMode = view.findViewById(R.id.resistorInputModeDDP);
        ArrayAdapter<CharSequence> resistorInputModeAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.resistor_input_mode, android.R.layout.simple_spinner_item);
        resistorInputMode.setAdapter(resistorInputModeAdapter);

        resistorValue = new ResistorValue(view);
        resistorGraph = view.findViewById(R.id.resistorGraph);

        colorSelector = new ColorSelector(view);
        colorSelector.addObserver(resistorGraph);
        colorSelector.addObserver(resistorValue);

        valueSelector = new ValueSelector(view);
        valueSelector.addObserver(resistorGraph);
        valueSelector.addObserver(resistorValue);
    }

    private void setUpUI() {
        resistorInputMode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0) {
                    valueSelector.resetSelection();
                    valueSelector.setVisible(View.VISIBLE);
                    colorSelector.setVisible(View.GONE);
                } else {
                    colorSelector.resetSelection();
                    valueSelector.setVisible(View.GONE);
                    colorSelector.setVisible(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

}
