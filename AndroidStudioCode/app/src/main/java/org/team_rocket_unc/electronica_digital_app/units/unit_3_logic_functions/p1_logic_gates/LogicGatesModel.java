package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

import android.widget.CheckBox;

public class LogicGatesModel {
    boolean stateA_in1 = true;
    boolean stateA_in2 = true;
    //boolean stateB_in1 = true;
    //boolean stateB_in2 = true;
    boolean output = true;


    private static final LogicGatesModel model = new LogicGatesModel();

    private LogicGatesModel() {}

    public static LogicGatesModel getInstance() {
        return model;
    }


    public boolean checkInputs(boolean A, boolean B){

        return true;
    }

    public boolean getOutput() {
        recalculate();
        return output;
    }

    private void recalculate() {
        output = stateA_in1 && stateA_in2 ? true : false;

    }

    public void update(boolean gateA_in1, boolean gateA_in2) {
        stateA_in1 = gateA_in1;
        stateA_in2 = gateA_in2;
    }
}
