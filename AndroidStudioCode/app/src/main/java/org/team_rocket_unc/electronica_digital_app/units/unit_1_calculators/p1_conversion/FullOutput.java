package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

public class FullOutput {

    private final String binaryOutput;
    private final String decimalOutput;
    private final String hexOutput;

    public FullOutput(String binaryOutput, String decimalOutput, String hexOutput) {
        this.binaryOutput = binaryOutput;
        this.decimalOutput = decimalOutput;
        this.hexOutput = hexOutput;
    }

    public String getBinaryOutput() {
        return binaryOutput;
    }

    public String getDecimalOutput() {
        return decimalOutput;
    }

    public String getHexOutput() {
        return hexOutput;
    }

}
