package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

import java.util.Arrays;
import java.util.List;

public class ConversionToolModel {

    private static final List<Integer> CONVERSION_BASE_LIST = Arrays.asList(2, 10, 16);

    private int conversionBase = 2;
    private FullOutput output = new FullOutput("0", "0", "0");

    public void updateInput(String input) throws NumberFormatException {
        int decimalInput = Integer.parseInt(input, conversionBase);
        this.output = convert(decimalInput);
    }

    public FullOutput getOutput() {
        return output;
    }

    public void setConversionBase(int dropButtonSelected) {
        conversionBase = CONVERSION_BASE_LIST.get(dropButtonSelected);
    }

    private FullOutput convert(int input) {
        return new FullOutput(Integer.toBinaryString(input),
                Integer.toString(input),
                Integer.toHexString(input).toUpperCase());
    }

}
