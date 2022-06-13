package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

public class Gate {
    private boolean input1;
    private boolean input2;
    private boolean output;
    private String gateType;

    public Gate() {
        this.input1 = false;
        this.input2 = false;
        this.output = false;
        this.gateType = "AND";
    }
    public boolean isInput1() {
        return input1;
    }

    public void setInput1(boolean input1) {
        this.input1 = input1;
    }

    public boolean isInput2() {
        return input2;
    }

    public void setInput2(boolean input2) {
        this.input2 = input2;
    }

    public boolean isOutput() {
        return output;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }

    public String getGateType() {
        return gateType;
    }

    public void setGateType(String gateType) {
        this.gateType = gateType;
    }
}
