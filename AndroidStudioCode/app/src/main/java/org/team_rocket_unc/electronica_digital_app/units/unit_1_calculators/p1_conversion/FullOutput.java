package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion;

public class FullOutput {

    private final String binaryOutput;
    private final String decimalOutput;
    private final String hexaOutput;

    public FullOutput(String binaryOutput, String decimalOutput, String hexaOutput) {
        this.binaryOutput = binaryOutput;
        this.decimalOutput = decimalOutput;
        this.hexaOutput = hexaOutput;
    }

    public String getBinaryOutput() {
        return binaryOutput;
    }

    public String getDecimalOutput() {
        return decimalOutput;
    }

    public String getHexaOutput() {
        return hexaOutput;
    }

}
