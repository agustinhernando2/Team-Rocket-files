package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p2_truth_tables;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.R;

public class TruthTablesToolFragment extends Fragment {

    View view;
    Spinner gateSelector;
    TextView txt;
    TruthTablesToolModel model;
    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u3_p3_truth_table,container,false);
        model=new TruthTablesToolModel();
        setUI();
        setUpUI();
        return view;
    }

    private void setUI() {
        imageView = view.findViewById(R.id.image);
        gateSelector = view.findViewById(R.id.gateSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.logic_gates, android.R.layout.simple_spinner_item);
        gateSelector.setAdapter(adapter);
    }

    private void setUpUI() {
        gateSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                model.setGate(i);
                String gate=model.getGate();
                switch (gate){
                    case "AND":
                        imageView.setImageResource(R.drawable.and);
                        break;
                    case "OR":
                        imageView.setImageResource(R.drawable.or);
                        break;
                    case "NAND":
                        imageView.setImageResource(R.drawable.nand);
                        break;
                    case "NOR":
                        imageView.setImageResource(R.drawable.nor);
                        break;
                    case "NOT":
                        imageView.setImageResource(R.drawable.not);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
