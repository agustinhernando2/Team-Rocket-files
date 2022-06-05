package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

public class OhmToolFragment extends Fragment {

    View view;
    EditText resistance;
    EditText tension;
    EditText power;
    EditText current;
    OhmToolModel model;

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
    }

    private void setUpUI(){
        KeyboardUtils.closeKeyboardOnEnter(resistance,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(tension,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(current,getActivity());
        KeyboardUtils.closeKeyboardOnEnter(power,getActivity());

        KeyboardUtils.functionAfterChange(resistance,() ->{
            model.setResistance(this.resistance.getText().toString());
        });
        KeyboardUtils.functionAfterChange(tension,() ->{
            model.setTension(this.tension.getText().toString());
        });
        KeyboardUtils.functionAfterChange(current,() ->{
            model.setCurrent(this.current.getText().toString());
        });
        KeyboardUtils.functionAfterChange(power,() ->{
            model.setPower(this.power.getText().toString());
        });

    }

}
