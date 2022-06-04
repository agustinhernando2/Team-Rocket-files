package org.team_rocket_unc.electronica_digital_app.LogicFunctionsTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates.Gate;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates.LogicGatesModel;

public class LogicGates {

    public Gate gateA = new Gate();
    public Gate gateB = new Gate();
    public Gate gateC = new Gate();


    @Test
    public void positiveTestAndGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("AND");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void positiveTestNandGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("NAND");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }
    @Test
    public void positiveTestOrGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("OR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void positiveTestNorGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("NOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }
    @Test
    public void positiveTestXorGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("XOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void positiveTestNxorGate() {
        LogicGatesModel logicGates = LogicGatesModel.getInstance();
        gateA.setGateType("XNOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        logicGates.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        logicGates.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }





}
