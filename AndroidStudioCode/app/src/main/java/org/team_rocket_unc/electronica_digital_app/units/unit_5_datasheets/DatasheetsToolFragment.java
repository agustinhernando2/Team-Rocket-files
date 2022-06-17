package org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.github.barteksc.pdfviewer.PDFView;

import org.team_rocket_unc.electronica_digital_app.R;

public class DatasheetsToolFragment extends Fragment {

    View view;
    Spinner pdfSpinner;
    DataSheetsToolModel model;
    PDFView pdfView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_u5_p1_datasheets,container,false);
        model= new DataSheetsToolModel();
        setUI();
        setUpUI();
        return view;
    }

    private void setUI(){
        pdfView = view.findViewById(R.id.pdfView);
        pdfSpinner = view.findViewById(R.id.pdfSel);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.pdfs_names, android.R.layout.simple_spinner_item);
        pdfSpinner.setAdapter(adapter);
    }

    private void setUpUI(){
        pdfSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                model.setPdf(i);
                pdfView.fromAsset(model.getPdfName()+".pdf").load();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
