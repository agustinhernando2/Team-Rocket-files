package org.team_rocket_unc.electronica_digital_app.LogicFunctionsTests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p1_logic_gates.LogicGatesModel;

public class LogicGates {
    LogicGatesModel logicGates = new LogicGatesModel();

    @Test
    public void positiveTestAndGate() {
        boolean outṕut;
        outṕut = logicGates.checkInputs(true,true);
        assertEquals(true, outṕut);
        outṕut = logicGates.checkInputs(false,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(true,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(false,true);
        assertEquals(false, outṕut);
    }











    @Test
    public void positiveTestOrGate() {
        boolean outṕut;
        outṕut = logicGates.checkInputs(true,true);
        assertEquals(true, outṕut);
        outṕut = logicGates.checkInputs(false,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(true,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(false,true);
        assertEquals(false, outṕut);
    }
    @Test
    public void positiveTestXorGate() {
        boolean outṕut;
        outṕut = logicGates.checkInputs(true,true);
        assertEquals(true, outṕut);
        outṕut = logicGates.checkInputs(false,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(true,false);
        assertEquals(false, outṕut);
        outṕut = logicGates.checkInputs(false,true);
        assertEquals(false, outṕut);
    }


}
