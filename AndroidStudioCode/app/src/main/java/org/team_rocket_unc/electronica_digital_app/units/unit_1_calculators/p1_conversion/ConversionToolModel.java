package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

public class ConversionToolModel {

    private int decimalInput = 0;
    private String binaryOutput = "0";

    public void updateDecimalInput(int decimalInput) {
        System.out.println("INPUT: " + decimalInput);
        this.decimalInput = decimalInput;
        binaryOutput = Integer.toBinaryString(decimalInput);
    }

    public String getBinaryOutput() {
        return binaryOutput;
    }

}
