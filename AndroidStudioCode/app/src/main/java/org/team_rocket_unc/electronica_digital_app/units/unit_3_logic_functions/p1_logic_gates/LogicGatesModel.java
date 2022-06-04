package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

import java.util.Arrays;
import java.util.List;

public class LogicGatesModel {
    private Gate gateA = new Gate();
    private Gate gateB = new Gate();
    private Gate gateC = new Gate();

    private static final List<String> allGateTypes = Arrays.asList("AND", "NAND", "OR", "NOR"," XOR", "XNOR");

    private static final LogicGatesModel model = new LogicGatesModel();

    private LogicGatesModel() {}

    public static LogicGatesModel getInstance() {
        return model;
    }

    public boolean getOutput() {
        recalculate();
        return gateC.isOutput();
    }

    private void recalculate() {
        calculate(gateA);
        calculate(gateB);
        System.out.println("r"+gateA.isOutput());
        System.out.println(gateB.isOutput());
        System.out.println(gateB.getGateType());
        gateC.setInput1(gateA.isOutput());
        gateC.setInput2(gateB.isOutput());
        calculate(gateC);
    }

    public void calculate(Gate gate) {
        if(gate.getGateType().equals("AND")){
            gate.setOutput(AND(gate.isInput1(), gate.isInput2()));
            System.out.println("c"+gate.isOutput()+""+gate.isInput1()+""+gate.isInput2());
        }
        else if(gate.getGateType().equals("NAND") ){
            gate.setOutput(NAND(gate.isInput1(), gate.isInput2()));
        }
        else if(gate.getGateType().equals("OR")){
            gate.setOutput(OR(gate.isInput1(), gate.isInput2()));
        }
        else if(gate.getGateType().equals("NOR")){
            gate.setOutput(NOR(gate.isInput1(), gate.isInput2()));
        }
        else if(gate.getGateType().equals("XOR")){
            gate.setOutput(XOR(gate.isInput1(), gate.isInput2()));
        }
        else if(gate.getGateType().equals("XNOR")){
            gate.setOutput(XNOR(gate.isInput1(), gate.isInput2()));
        }
    }

    public void setInputs(boolean gateA_in1, boolean gateA_in2, boolean gateB_in1, boolean gateB_in2) {
        this.gateA.setInput1(gateA_in1);
        this.gateA.setInput2(gateA_in2);
        this.gateB.setInput1(gateB_in1);
        this.gateB.setInput2(gateB_in2);

    }
    public void setTypes(String gateA, String gateB, String gateC) {
        this.gateA.setGateType(gateA);
        this.gateB.setGateType(gateB);
        this.gateC.setGateType(gateC);
    }

    public boolean AND(boolean A, boolean B){
        return A && B;
    }
    public boolean NAND(boolean A, boolean B){
        return !AND(A,B);
    }
    public boolean OR(boolean A, boolean B){
        return A || B;
    }
    public boolean NOR(boolean A, boolean B){
        return !OR(A,B);
    }
    public boolean XOR(boolean A, boolean B){
        return (A && !B) || (!A && B);
    }
    public boolean XNOR(boolean A, boolean B){
        return !XOR(A,B);
    }


}
