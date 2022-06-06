package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;

public class LogicGatesToolFragment extends Fragment {

    View view;
    CheckBox gateA_in1;
    CheckBox gateA_in2;
    CheckBox gateB_in1;
    CheckBox gateB_in2;
    CheckBox output;
    LogicGatesModel logicGatesModel;
    Spinner gateTypeA;
    Spinner gateTypeB;
    Spinner gateTypeC;
    ImageView imgGateA;
    ImageView imgGateB;
    ImageView imgGateC;

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
        imgGateA = (ImageView) view.findViewById(R.id.imgGateA);
        imgGateB = (ImageView) view.findViewById(R.id.imgGateB);
        imgGateC = (ImageView) view.findViewById(R.id.imgGateC);
        gateA_in1= (CheckBox) view.findViewById(R.id.cBoxGateA_in1);
        gateA_in2= (CheckBox) view.findViewById(R.id.cBoxGateA_in2);
        gateB_in1= (CheckBox) view.findViewById(R.id.cBoxGateB_in1);
        gateB_in2= (CheckBox) view.findViewById(R.id.cBoxGateB_in2);
        gateTypeA = (Spinner) view.findViewById(R.id.spinnerG1);
        gateTypeB = (Spinner) view.findViewById(R.id.spinnerG2);
        gateTypeC = (Spinner) view.findViewById(R.id.spinnerG3);
        output= (CheckBox) view.findViewById(R.id.cbOutput);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.gateType));

        gateTypeA.setAdapter(adapter);
        gateTypeB.setAdapter(adapter);
        gateTypeC.setAdapter(adapter);
    }

    private void setUpUI() {
        logicGatesModel.updateImgOnStartFragment(imgGateA,imgGateB,imgGateC);
        logicGatesModel.updateSeleccionOnStartFragment(gateTypeA, gateTypeB, gateTypeC);
        logicGatesModel.updateInputsOnStartFragment(gateA_in1,gateA_in2,gateB_in1,gateB_in2,output);

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
        gateTypeA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
                logicGatesModel.updateImg((ImageView) imgGateA,i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gateTypeB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
                logicGatesModel.updateImg((ImageView) imgGateB,i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        gateTypeC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                onChangeSpinner();
                logicGatesModel.updateImg((ImageView) imgGateC,i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void onChangeSpinner() {
        logicGatesModel.setTypes(
                gateTypeA.getSelectedItem().toString()
                , gateTypeB.getSelectedItem().toString()
                , gateTypeC.getSelectedItem().toString());

        output.setChecked(logicGatesModel.getOutput());
    }

    private void onChangeBox() {
        logicGatesModel.setInputs(
                gateA_in1.isChecked(),
                gateA_in2.isChecked(),
                gateB_in1.isChecked(),
                gateB_in2.isChecked());

        output.setChecked(logicGatesModel.getOutput());
    }
}

