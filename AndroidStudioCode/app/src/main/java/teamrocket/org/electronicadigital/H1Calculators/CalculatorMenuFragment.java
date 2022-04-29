package teamrocket.org.electronicadigital.H1Calculators;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import teamrocket.org.electronicadigital.H1Calculators.ledCircuitTool.LedCircuitToolFragment;
import teamrocket.org.electronicadigital.H1Calculators.ohmTool.OhmToolFragment;
import teamrocket.org.electronicadigital.H1Calculators.conversionTool.*;
import teamrocket.org.electronicadigital.InstructionsFragment;
import teamrocket.org.electronicadigital.R;

public class CalculatorMenuFragment extends Fragment {

    View view;
    Button conversorButton;
    Button ohmButton;
    Button ledButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_h1_calculators_menu,container,false);

        setTool(conversorButton, R.id.buttonConversion, new InstructionsFragment("Conversor de sistemas de unidades",
                "Instrucciones del conversor",
                new ConversionToolFragment()));
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
                        .replace(R.id.fragment_container, targetToolFragment).commit();
            }
        });
    }

}
