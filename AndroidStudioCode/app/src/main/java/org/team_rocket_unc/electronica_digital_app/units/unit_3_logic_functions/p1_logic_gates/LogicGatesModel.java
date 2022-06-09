package org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;

import org.team_rocket_unc.electronica_digital_app.R;

import java.util.Arrays;
import java.util.List;

public class LogicGatesModel {
    private Gate gateA = new Gate();
    private Gate gateB = new Gate();
    private Gate gateC = new Gate();

    private static final List<String> ALL_GATES_TYPES = Arrays.asList("AND", "NAND", "OR", "NOR"," XOR", "XNOR");

    private static final LogicGatesModel model = new LogicGatesModel();

    private LogicGatesModel() {}

    public static LogicGatesModel getInstance() {
        return model;
    }

    public boolean getOutputOfCircuit() {
        calculateGates();
        return gateC.isOutput();
    }

    private void calculateGates() {
        calculate(gateA);
        calculate(gateB);
        gateC.setInput1(gateA.isOutput());
        gateC.setInput2(gateB.isOutput());
        calculate(gateC);
    }

    public void calculate(Gate gate) {
        if(gate.getGateType().equals("AND")){
            gate.setOutput(AND(gate.isInput1(), gate.isInput2()));
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

    public void updateImgOnStartFragment(ImageView imgGateA,ImageView imgGateB,ImageView imgGateC){
        int index;
        index = ALL_GATES_TYPES.indexOf(gateA.getGateType());
        updateImg(imgGateA, index);
        index = ALL_GATES_TYPES.indexOf(gateB.getGateType());
        updateImg(imgGateB, index);
        index = ALL_GATES_TYPES.indexOf(gateC.getGateType());
        updateImg(imgGateC, index);
    }
    public void updateImg(ImageView view, int i) {
        System.out.println(i);
        switch (i) {
            case 0:
                view.setImageResource(R.drawable.and);
                break;
            case 1:
                view.setImageResource(R.drawable.nand);
                break;
            case 2:
                view.setImageResource(R.drawable.or);
                break;
            case 3:
                view.setImageResource(R.drawable.nor);
                break;
            case 4:
                view.setImageResource(R.drawable.xor);
                break;
            case 5:
                view.setImageResource(R.drawable.xnor);
                break;
        }
    }

    public void updateSeleccionOnStartFragment(Spinner gateTypeA, Spinner gateTypeB, Spinner gateTypeC) {
        int index;
        index = ALL_GATES_TYPES.indexOf(gateA.getGateType());
        gateTypeA.setSelection(index);
        index = ALL_GATES_TYPES.indexOf(gateB.getGateType());
        gateTypeB.setSelection(index);
        index = ALL_GATES_TYPES.indexOf(gateC.getGateType());
        gateTypeC.setSelection(index);
    }

    public void updateInputsOnStartFragment(CheckBox gateA_in1, CheckBox gateA_in2, CheckBox gateB_in1, CheckBox gateB_in2, CheckBox output) {
        gateA_in1.setChecked(gateA.isInput1());
        gateA_in2.setChecked(gateA.isInput2());
        gateB_in1.setChecked(gateB.isInput1());
        gateB_in2.setChecked(gateB.isInput2());
        output.setChecked(gateC.isOutput());
    }
}
