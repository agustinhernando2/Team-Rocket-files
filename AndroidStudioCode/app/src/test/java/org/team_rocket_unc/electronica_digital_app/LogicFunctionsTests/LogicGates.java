package org.team_rocket_unc.electronica_digital_app.LogicFunctionsTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates.Gate;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates.LogicGatesModel;


public class LogicGates {

    public Gate gateA = new Gate();


    LogicGatesModel model;
    @Before
    public void setUp(){
        model = LogicGatesModel.getInstance();
    }
    @Test
    public void outputAllAndCircuit() {
        model.setTypes("AND","AND","AND");
        model.setInputs(true,true,true,true);
        boolean output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(true,false,true,true);
        output = model.getOutputOfCircuit();
        assertEquals(false, output);
        model.setInputs(true,true,false,true);
        output = model.getOutputOfCircuit();
        assertEquals(false, output);
        model.setInputs(true,true,true,false);
        output = model.getOutputOfCircuit();
        assertEquals(false, output);
    }
    @Test
    public void outputAllOrCircuit() {
        model.setTypes("OR","OR","OR");
        model.setInputs(true,true,true,true);
        boolean output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(true,false,true,true);
        output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(true,true,false,true);
        output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(false,false,false,false);
        output = model.getOutputOfCircuit();
        assertEquals(false, output);
    }
    @Test
    public void outputAllXorCircuit() {
        model.setTypes("XOR","XOR","XOR");
        model.setInputs(true,true,true,true);
        boolean output = model.getOutputOfCircuit();
        assertEquals(false, output);
        model.setInputs(true,false,true,true);
        output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(true,true,false,true);
        output = model.getOutputOfCircuit();
        assertEquals(true, output);
        model.setInputs(false,false,false,false);
        output = model.getOutputOfCircuit();
        assertEquals(false, output);
    }

    @Test
    public void outputAndGate() {

        gateA.setGateType("AND");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void outputNandGate() {

        gateA.setGateType("NAND");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }
    @Test
    public void outputOrGate() {

        gateA.setGateType("OR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void outputNorGate() {

        gateA.setGateType("NOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }
    @Test
    public void outputXorGate() {
        gateA.setGateType("XOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(false, gateA.isOutput());

    }
    @Test
    public void outputXnorGate() { ;
        gateA.setGateType("XNOR");

        gateA.setInput1(true);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

        gateA.setInput1(true);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(true);
        model.calculate(gateA);
        assertEquals(!true, gateA.isOutput());

        gateA.setInput1(false);
        gateA.setInput2(false);
        model.calculate(gateA);
        assertEquals(!false, gateA.isOutput());

    }





}
