package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p3_led.LedCircuitToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm.OhmToolFragment;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion.*;
import org.team_rocket_unc.electronica_digital_app.InstructionsFragment;
import org.team_rocket_unc.electronica_digital_app.R;

public class CalculatorMenuFragment extends Fragment {

    View view;
    Button conversorButton;
    Button ohmButton;
    Button ledButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u1_p1_menu,container,false);

        setTool(conversorButton, R.id.buttonConversion, new InstructionsFragment(getString(R.string.u1_p2_conversor_title),
                getString(R.string.u1_p2_conversor_instructions), new ConversionToolFragment()));
        setTool(conversorButton, R.id.buttonOhm, new InstructionsFragment("Circuito ley de ohm",
                "Instrucciones del circuito de la ley de ohm",
                new OhmToolFragment()));
        setTool(conversorButton, R.id.buttonLed, new InstructionsFragment("Circuito con LED",
                "Instrucciones del circuito con LED",
                new LedCircuitToolFragment()));
        return view;
    }

    private void setTool(Button targetToolButton, int targetToolButtonId, Fragment targetToolFragment) {
        targetToolButton = view.findViewById(targetToolButtonId);
        targetToolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, targetToolFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

}
