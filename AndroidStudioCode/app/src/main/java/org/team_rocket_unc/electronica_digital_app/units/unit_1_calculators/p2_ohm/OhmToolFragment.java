package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

public class OhmToolFragment extends Fragment {

    public boolean[] selectedInputs = {false, false, false, false};

    boolean listeningChange = true;

    View view;
    EditText resistance;
    EditText tension;
    EditText power;
    EditText current;
    OhmToolModel model;
    CheckBox boxR;
    CheckBox boxT;
    CheckBox boxP;
    CheckBox boxC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p4_ohm,container,false);
        model = new OhmToolModel();
        setUI();
        setUpUI();
        updatedSelectors();
        return view;
    }

    private void setUI(){
        resistance = view.findViewById(R.id.resistanceInput);
        tension = view.findViewById(R.id.tensionInput);
        power = view.findViewById(R.id.powerInput);
        current = view.findViewById(R.id.intensityInput);

        boxC = view.findViewById(R.id.checkBoxI);
        boxP = view.findViewById(R.id.checkBoxP);
        boxT = view.findViewById(R.id.checkBoxV);
        boxR = view.findViewById(R.id.checkBoxR);
    }


    private int countTrues(boolean[] array) {
        int count = 0;
        for(boolean selectedInput : array) {
            if (selectedInput) {
                count++;
            }
        }
        return count;
    }

    private boolean forbiddenCheck() {
        int selected = countTrues(selectedInputs);
        return selected == 2;
    }

    private void updatedSelectors() {
        selectedInputs[0] = boxC.isChecked();
        current.setFocusableInTouchMode(boxC.isChecked());
        selectedInputs[1] = boxT.isChecked();
        tension.setFocusableInTouchMode(boxT.isChecked());
        selectedInputs[2] = boxR.isChecked();
        resistance.setFocusableInTouchMode(boxR.isChecked());
        selectedInputs[3] = boxP.isChecked();
        power.setFocusableInTouchMode(boxP.isChecked());

        listeningChange = false;
        current.setText("0");
        model.setCurrent("0");
        tension.setText("0");
        model.setTension("0");
        resistance.setText("0");
        model.setResistance("0");
        power.setText("0");
        model.setPower("0");
        listeningChange = true;

        updateOutputs();
    }

    private void setUpUI(){
        KeyboardUtils.closeKeyboardOnEnter(current,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(tension,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(resistance,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(power,getActivity());

        boxR.setOnClickListener(view -> {
            if(forbiddenCheck()) {
                boxR.setChecked(false);
            }
            updatedSelectors();
        });

        boxT.setOnClickListener(view -> {
            if(forbiddenCheck()) {
                boxT.setChecked(false);
            }
            updatedSelectors();
        });

        boxC.setOnClickListener(view -> {
            if(forbiddenCheck()) {
                boxC.setChecked(false);
            }
            updatedSelectors();
        });

        boxP.setOnClickListener(view -> {
            if(forbiddenCheck()) {
                boxP.setChecked(false);
            }
            updatedSelectors();
        });

        KeyboardUtils.functionAfterChange(current,() ->{
            if(boxC.isChecked()) {
                String input = this.current.getText().toString();
                model.setCurrent(input.length() > 0 ? input : "0");
                updateOutputs();
            }
        });

        KeyboardUtils.functionAfterChange(tension,() ->{
            if(boxT.isChecked()) {
                String input = this.tension.getText().toString();
                model.setTension(input.length() > 0 ? input : "0");
                updateOutputs();
            }
        });

        KeyboardUtils.functionAfterChange(resistance,() ->{
            if(boxR.isChecked()) {
                String input = this.resistance.getText().toString();
                model.setResistance(input.length() > 0 ? input : "0");
                updateOutputs();
            }
        });

        KeyboardUtils.functionAfterChange(power,() ->{
            if(boxP.isChecked()) {
                String input = this.power.getText().toString();
                model.setPower(input.length() > 0 ? input : "0");
                updateOutputs();
            }
        });
    }

    private void updateOutputs(){
        if(countTrues(selectedInputs) == 2 && listeningChange){
            model.calculateAll(selectedInputs);
            listeningChange = false;
            if(!selectedInputs[0])
                current.setText(model.getCurrent());
            if(!selectedInputs[1])
                tension.setText(model.getTension());
            if(!selectedInputs[2])
                resistance.setText(model.getResistance());
            if(!selectedInputs[3])
                power.setText(model.getPower());
            listeningChange = true;
        }
    }

}
