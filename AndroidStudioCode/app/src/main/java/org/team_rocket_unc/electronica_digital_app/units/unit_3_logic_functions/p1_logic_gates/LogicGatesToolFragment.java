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
import android.widget.Spinner;
import android.widget.Toast;

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
    CheckBox gateB_in1;
    CheckBox gateB_in2;
    CheckBox output;
    LogicGatesModel logicGatesModel;
    Spinner gateType1;
    Spinner gateType2;
    Spinner gateType3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u3_p2_logic_gates,container,false);
        logicGatesModel = LogicGatesModel.getInstance();
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        gateA_in1= (CheckBox) view.findViewById(R.id.cBoxGateA_in1);
        gateA_in2= (CheckBox) view.findViewById(R.id.cBoxGateA_in2);
        gateB_in1= (CheckBox) view.findViewById(R.id.cBoxGateB_in1);
        gateB_in2= (CheckBox) view.findViewById(R.id.cBoxGateB_in2);
        gateType1= (Spinner) view.findViewById(R.id.spinnerG1);
        gateType2= (Spinner) view.findViewById(R.id.spinnerG2);
        gateType3= (Spinner) view.findViewById(R.id.spinnerG3);

        output= (CheckBox) view.findViewById(R.id.cbOutput);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.gateType));

        gateType1.setAdapter(adapter);
        gateType2.setAdapter(adapter);
        gateType3.setAdapter(adapter);


    }





    private void setUpUI() {

        gateA_in1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onChangeBox();
            }
        });
        gateA_in2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onChangeBox();

            }
        });
        gateB_in1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onChangeBox();
            }
        });
        gateB_in2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                onChangeBox();

            }
        });
        gateType1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gateType2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gateType3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void onChangeSpinner() {
        logicGatesModel.setTypes(
                gateType1.getSelectedItem().toString()
                ,gateType2.getSelectedItem().toString()
                ,gateType3.getSelectedItem().toString());
        boolean b = logicGatesModel.getOutput();
        output.setChecked(b);
        Toast.makeText(getActivity(), "onChangeSpinner! "+ output.isChecked()+ b,
                Toast.LENGTH_SHORT).show();
    }

    private void onChangeBox() {

        logicGatesModel.setInputs(gateA_in1.isChecked(), gateA_in2.isChecked(),gateB_in1.isChecked(), gateB_in2.isChecked());
        output.setChecked(logicGatesModel.getOutput());
        Toast.makeText(getActivity(), "onChangeBox! "+ output.isChecked(),
                Toast.LENGTH_SHORT).show();
    }


}

