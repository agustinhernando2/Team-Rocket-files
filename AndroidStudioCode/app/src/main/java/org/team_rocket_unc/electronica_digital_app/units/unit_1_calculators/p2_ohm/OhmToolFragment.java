package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OhmToolFragment extends Fragment {

    public List<Boolean> selectedInputs = Arrays.asList(false,false,false,false);

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
        return view;
    }

    private void setUI(){
        resistance = view.findViewById(R.id.resistanceInput);
        tension = view.findViewById(R.id.tensionInput);
        power = view.findViewById(R.id.powerInput);
        current = view.findViewById(R.id.intensityInput);

        boxC = view.findViewById(R.id.checkBoxI);
        boxP=view.findViewById(R.id.checkBoxP);
        boxT = view.findViewById(R.id.checkBoxV);
        boxR=view.findViewById(R.id.checkBoxR);
    }

    private void setUpUI(){
        KeyboardUtils.closeKeyboardOnEnter(resistance,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(tension,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(current,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(power,getActivity());

        boxR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputs.set(0, !selectedInputs.get(0));
                if(Collections.frequency(selectedInputs,true)==3) {
                    boxR.setChecked(false);
                    selectedInputs.set(0, false);
                }
            }
        });
        boxT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputs.set(1, !selectedInputs.get(1));
                if(Collections.frequency(selectedInputs,true)==3) {
                    boxT.setChecked(false);
                    selectedInputs.set(1, false);
                }
            }
        });
        boxC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputs.set(2, !selectedInputs.get(2));
                if(Collections.frequency(selectedInputs,true)==3) {
                    boxC.setChecked(false);
                    selectedInputs.set(2, false);
                }
            }
        });
        boxP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedInputs.set(3, !selectedInputs.get(3));
                if(Collections.frequency(selectedInputs,true)==3) {
                    boxP.setChecked(false);
                    selectedInputs.set(3, false);
                }
            }
        });

        KeyboardUtils.functionAfterChange(resistance,() ->{
            if(boxR.isChecked()){
                String input = this.resistance.getText().toString();
                model.setResistance(input.length() > 0 ? input : "0");
                updateOutputs();
            } else {
                model.setResistance("0");
            }
        });

        KeyboardUtils.functionAfterChange(tension,() ->{
            if(boxT.isChecked()){
                String input = this.tension.getText().toString();
                model.setTension(input.length() > 0 ? input : "0");
                updateOutputs();
            } else {
                model.setTension("0");
            }
            System.out.print(selectedInputs);
        });

        KeyboardUtils.functionAfterChange(current,() ->{
            if(boxC.isChecked()){
                String input = this.current.getText().toString();
                model.setCurrent(input.length() > 0 ? input : "0");
                updateOutputs();
            } else {
                model.setCurrent("0");
            }

        });
        KeyboardUtils.functionAfterChange(power,() ->{
            if(boxP.isChecked()){
                String input = this.power.getText().toString();
                model.setPower(input.length() > 0 ? input : "0");
                updateOutputs();
            } else {model.setPower("0");
                }
        });
    }

    private void updateOutputs(){
        System.out.println(Collections.frequency(selectedInputs,true));
        if(Collections.frequency(selectedInputs,true)==2){
            model.calculateAll(selectedInputs);
            if(selectedInputs.get(0)){ //mismo orden y logica que el calculateAll del Model
                if(selectedInputs.get(1)){current.setText(model.getCurrent()); power.setText(model.getPower());}
                else if(selectedInputs.get(2)){tension.setText(model.getTension()); power.setText(model.getPower());}
                else if(selectedInputs.get(3)){tension.setText(model.getTension()); current.setText(model.getCurrent());}
            }
            else if(selectedInputs.get(1)){
                if(selectedInputs.get(2)){resistance.setText(model.getResistance()); power.setText(model.getPower());}
                else if(selectedInputs.get(3)){resistance.setText(model.getResistance()); current.setText(model.getCurrent());}
            }
            else if(selectedInputs.get(2) && selectedInputs.get(3)){
                resistance.setText(model.getResistance());
                tension.setText(model.getTension());
            }
        }
    }

}
