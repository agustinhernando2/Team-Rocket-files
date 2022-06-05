package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p3_led;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;

public class LedCircuitToolFragment extends Fragment {

    View view;
    Spinner ledColor;
    EditText currentInput;
    EditText tensionInput;
    TextView resistanceOutput;
    TextView ledTensionOutput;
    LedCircuitToolModel model;
    Button calculateButton;
    Toast inputErrorToast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p3_led,container,false);
        model= new LedCircuitToolModel();
        //inputErrorToast = Toast.makeText(view.getContext(), "Input no aceptado", Toast.LENGTH_SHORT);
        setUI();
        setUpUI();

        return view;
    }

    private void setUI() {
        currentInput = view.findViewById(R.id.intensityInput);
        tensionInput = view.findViewById(R.id.tensionInput);

        calculateButton = view.findViewById(R.id.calculateButton);

        resistanceOutput = view.findViewById(R.id.resistanceOutput);
        ledTensionOutput = view.findViewById(R.id.ledTensionOutput);

        ledColor = view.findViewById(R.id.inputSystemLedColor);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.led_color, android.R.layout.simple_spinner_item);
        ledColor.setAdapter(adapter);
    }

    private void setUpUI(){

        ledColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                model.setLedTension(i);
                ledTensionOutput.setText(model.getLedTension());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        calculateButton.setOnClickListener(view -> {
            try {
                model.calculate(currentInput.getText().toString(), tensionInput.getText().toString());
                resistanceOutput.setText(model.getResistance());
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        });
    }

}
