package teamrocket.org.electronicadigital;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InstructionsFragment extends Fragment {

    private final String title;
    private final String instructions;

    private Fragment tool;
    private View view;
    private TextView titleTextView;
    private TextView instructionsTextView;
    private Button buttonNext;

    public InstructionsFragment(String title, String instructions, Fragment tool){
        this.title = title;
        this.instructions = instructions;
        this.tool = tool;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_instructions,container,false);

        titleTextView = view.findViewById(R.id.instructionsTitle);
        titleTextView.setText(title);
        instructionsTextView = view.findViewById(R.id.instructionsText);
        instructionsTextView.setText(instructions);
        buttonNext = view.findViewById(R.id.nextButton);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, tool).commit();
            }
        });

        return view;
    }

}
