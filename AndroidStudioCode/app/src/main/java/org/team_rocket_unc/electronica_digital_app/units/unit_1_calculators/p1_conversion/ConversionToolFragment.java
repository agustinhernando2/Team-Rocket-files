package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

import java.util.Arrays;
import java.util.List;

public class ConversionToolFragment extends Fragment {

    View view;
    Spinner numberSystem;
    EditText input;
    TextView binaryOutput;
    TextView decimalOutput;
    TextView hexOutput;
    ConversionToolModel model;

    Toast inputErrorToast;

    private static final List<InputFilter> FILTER_LIST = Arrays.asList(
            KeyboardUtils.createInputFilter("01"),
            KeyboardUtils.createInputFilter("0-9"),
            KeyboardUtils.createInputFilter("A-Fa-f0-9"));
    private static final List<Integer> INPUT_TYPE_LIST = Arrays.asList(
            InputType.TYPE_CLASS_NUMBER,
            InputType.TYPE_CLASS_NUMBER,
            InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p2_conversor,container,false);
        model = new ConversionToolModel();
        inputErrorToast = Toast.makeText(view.getContext(), "Input no aceptado", Toast.LENGTH_SHORT);
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        input = view.findViewById(R.id.conversorInput);
        input.setFilters(new InputFilter[] {(FILTER_LIST.get(0))});
        binaryOutput = view.findViewById(R.id.binaryOutput);
        decimalOutput = view.findViewById(R.id.decimalOutput);
        hexOutput = view.findViewById(R.id.hexaOutput);
        numberSystem = view.findViewById(R.id.inputSystemDDB);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.number_system, android.R.layout.simple_spinner_item);
        numberSystem.setAdapter(adapter);
    }

    private void setUpUI() {
        KeyboardUtils.closeKeyboardOnEnter(input,getActivity());
        KeyboardUtils.functionAfterChange(input,() ->{
            String input = this.input.getText().toString();
            try {
                model.updateInput(input.length() > 0 ? input : "0");
            } catch(NumberFormatException e) {
                inputErrorToast.show();
            }
            binaryOutput.setText(model.getOutput().getBinaryOutput());
            decimalOutput.setText(model.getOutput().getDecimalOutput());
            hexOutput.setText(model.getOutput().getHexOutput());
        });
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
    }

}
