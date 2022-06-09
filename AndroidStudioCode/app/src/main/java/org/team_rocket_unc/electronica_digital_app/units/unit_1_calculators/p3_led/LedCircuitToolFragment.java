package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p3_led;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

public class LedCircuitToolFragment extends Fragment {

    View view;
    Spinner ledColor;
    EditText currentInput;
    EditText tensionInput;
    TextView resistanceOutput;
    TextView ledTensionOutput;
    LedCircuitToolModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p3_led,container,false);
        model= new LedCircuitToolModel();
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        currentInput = view.findViewById(R.id.intensityInput);
        tensionInput = view.findViewById(R.id.tensionInput);

        resistanceOutput = view.findViewById(R.id.resistanceOutput);
        ledTensionOutput = view.findViewById(R.id.ledTensionOutput);

        ledColor = view.findViewById(R.id.inputSystemLedColor);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.led_color, android.R.layout.simple_spinner_item);
        ledColor.setAdapter(adapter);
    }

    private void setUpUI(){
        KeyboardUtils.closeKeyboardOnEnter(currentInput,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(tensionInput,getActivity());
        ledColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                model.setLedTension(i);
                ledTensionOutput.setText(model.getLedTension());
                updateResistanceOutput();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        KeyboardUtils.functionAfterChange(currentInput, this::updateResistanceOutput);
        KeyboardUtils.functionAfterChange(tensionInput, this::updateResistanceOutput);
    }

    private void updateResistanceOutput(){
        String currentString=currentInput.getText().toString();
        String tensionString = tensionInput.getText().toString();
        try {
            model.calculate(currentString, tensionString);
            resistanceOutput.setText(model.getResistance());
        } catch (NumberFormatException e){
            System.out.println(e.getMessage()); //no es una exception, solo crashea si no hay input (????
        }
    }
}
