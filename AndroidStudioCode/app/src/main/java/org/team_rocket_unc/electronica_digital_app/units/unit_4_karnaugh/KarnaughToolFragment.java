package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.Set;

public class KarnaughToolFragment extends Fragment {

    View view;
    Spinner algorithmSelector;
    EditText inputEditor;
    EditText noCareConditionsEditor;
    Button calculateButton;
    TextView output;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u4_p1_karnaugh,container,false);
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        algorithmSelector = view.findViewById(R.id.algorithmDDB);
        ArrayAdapter<CharSequence> algorithmInputModeAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.algorithms, android.R.layout.simple_spinner_item);
        algorithmSelector.setAdapter(algorithmInputModeAdapter);

        inputEditor = view.findViewById(R.id.karnaughConditions);
        noCareConditionsEditor = view.findViewById(R.id.karnaughNoCareConditions);
        calculateButton = view.findViewById(R.id.karnaughCalculateButton);
        output = view.findViewById(R.id.karnaughOutput);
    }

    private void setUpUI() {
        calculateButton.setOnClickListener(v -> {
            try {
                KarnaughMap karnaughMap = new KarnaughMap(inputEditor.getText().toString(),
                        noCareConditionsEditor.getText().toString(),
                        algorithmSelector.getSelectedItemPosition() == 0
                        ? new QuineMcCluskeyStrategy()
                        : new PetrickStrategy());
                Set<String> outputSet = karnaughMap.calculateLogicFunction();
                output.setText(outputSet.toString());
            } catch (KarnaughMap.InvalidKarnaughInputException e) {
                Toast toast = Toast.makeText(this.getContext(),
                        "Error en el input. Solo enteros de 0 a 15 separados por comas",
                        Toast.LENGTH_SHORT);
                output.setText("");
                toast.show();
            }
        });
    }

}
