package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

public class ConversionToolFragment extends Fragment {

    View view;
    EditText decimalInput;
    TextView binaryOutput;
    ConversionToolModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p2_conversor,container,false);
        model = new ConversionToolModel();
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        decimalInput = view.findViewById(R.id.decimalInput);
        binaryOutput = view.findViewById(R.id.binaryOutput);
    }

    private void setUpUI() {
        KeyboardUtils.closeKeyboardOnEnter(decimalInput,getActivity());
        KeyboardUtils.functionAfterChange(decimalInput,() ->{
            try {
                model.updateDecimalInput(Integer.parseInt(decimalInput.getText().toString()));
            } catch (NumberFormatException e) {
                Toast.makeText(view.getContext(), "Input no aceptado", Toast.LENGTH_SHORT).show();
            }
            binaryOutput.setText(model.getBinaryOutput());
        });
    }

}
