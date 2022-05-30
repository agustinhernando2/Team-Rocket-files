package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

import android.view.View;
import android.widget.ArrayAdapter;

import org.team_rocket_unc.electronica_digital_app.R;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConversionToolModel {

    private final Map<Integer, Integer> CONVERTION_BASE_GETTER = new HashMap<Integer, Integer>();

    private int convertionBase = 2;
    private int decimalInput= 0;
    private FullOutput output = new FullOutput("0", "0", "0");

    public void updateInput(String input) throws NumberFormatException {
        CONVERTION_BASE_GETTER.put(0,2);
        CONVERTION_BASE_GETTER.put(1,10);
        CONVERTION_BASE_GETTER.put(2, 16);
        int decimalInput = Integer.parseInt(input, convertionBase);
        this.output = convert(decimalInput);
        this.decimalInput = decimalInput;
    }

    public FullOutput getOutput() {
        return output;
    }

    public void setConvertionBase(int dropButtonSelected) {
        convertionBase = CONVERTION_BASE_GETTER.get(dropButtonSelected);
    }

    private FullOutput convert(int input) {
        return new FullOutput(Integer.toBinaryString(input),
                Integer.toString(input),
                Integer.toHexString(input).toUpperCase());
    }

}
