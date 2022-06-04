package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p2_truth_tables;

import java.util.Arrays;
import java.util.List;

public class ThruthTabeesToolModel {
    private static final List<String> GATE_LIST = Arrays.asList("AND","OR","NAND","NOR","NOT");

    private String gate ="AND";

    public void setGate(int dropButtonSelected) {
        gate = GATE_LIST.get(dropButtonSelected);
    }

    public String getGate(){
        return gate;
    }

}