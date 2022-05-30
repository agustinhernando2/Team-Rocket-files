package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.BaseKeyListener;
import android.text.method.DigitsKeyListener;
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

import java.util.HashMap;
import java.util.Map;

public class ConversionToolFragment extends Fragment {

    View view;
    Spinner numberSystem;
    EditText input;
    TextView binaryOutput;
    TextView decimalOutput;
    TextView hexOutput;
    ConversionToolModel model;

    Toast inputErrorToast;

    private static final Map<Integer, InputFilter> FILTER_GETTER = new HashMap<Integer, InputFilter>();
    private static final Map<Integer, Integer> INPUT_TYPE_GETTER = new HashMap<Integer, Integer>();

    static {
        FILTER_GETTER.put(0, KeyboardUtils.createInputFilter("01"));
        FILTER_GETTER.put(1, KeyboardUtils.createInputFilter("0-9"));
        FILTER_GETTER.put(2, KeyboardUtils.createInputFilter("A-Fa-f0-9"));
        INPUT_TYPE_GETTER.put(0, InputType.TYPE_CLASS_NUMBER);
        INPUT_TYPE_GETTER.put(1, InputType.TYPE_CLASS_NUMBER);
        INPUT_TYPE_GETTER.put(2, InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
    }

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
        input.setFilters(new InputFilter[] {(FILTER_GETTER.get(0))});
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
            hexOutput.setText(model.getOutput().getHexaOutput());
        });
        numberSystem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                input.setText("0");
                model.setConvertionBase(i);
                input.setFilters(new InputFilter[] {(FILTER_GETTER.get(i))});
                input.setInputType(INPUT_TYPE_GETTER.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
