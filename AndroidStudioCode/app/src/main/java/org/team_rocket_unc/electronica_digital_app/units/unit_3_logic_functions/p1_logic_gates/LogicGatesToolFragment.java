package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

import java.util.List;

public class LogicGatesToolFragment extends Fragment {

    View view;
    CheckBox gateA_in1;
    CheckBox gateA_in2;
    //CheckBox gateA_in1;
    //CheckBox gateA_in2;
    CheckBox output;
    LogicGatesModel logicGatesModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u3_p2_logic_gates,container,false);
        logicGatesModel = LogicGatesModel.getInstance();
        setUI();
        setUpUI();
        return view;
    }
    private void updateFragment() {
        logicGatesModel.update(gateA_in1.isChecked(), gateA_in2.isChecked());
        output.setChecked(logicGatesModel.getOutput());
    }
    private void setUI() {
        gateA_in1= (CheckBox) view.findViewById(R.id.cBoxGateA_in1);
        gateA_in2= (CheckBox) view.findViewById(R.id.cBoxGateA_in2);
        output= (CheckBox) view.findViewById(R.id.cbOutput);
        /*
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.number_system, android.R.layout.simple_spinner_item);
        numberSystem.setAdapter(adapter);
        */
    }





    private void setUpUI() {
        gateA_in1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateFragment();
            }
        });
        gateA_in2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateFragment();

            }
        });








        /*
        numberSystem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input.setText("0");
                model.setConversionBase(i);
                input.setFilters(new InputFilter[] {(FILTER_LIST.get(i))});
                input.setInputType(INPUT_TYPE_LIST.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */
    }



}

