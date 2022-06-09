package org.team_rocket_unc.electronica_digital_app.CalculatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm.OhmToolModel;

public class OhmPow {
    OhmToolModel staticOhmPow = new OhmToolModel();

    @Test
    public void testPowerResistance() {
        staticOhmPow.setPower("600");
        staticOhmPow.setResistance("300");
        staticOhmPow.calculateAll(new boolean[]{false,false,true,true});
        assertEquals("1.414",staticOhmPow.getCurrent());
        assertEquals("424.264",staticOhmPow.getTension());
    }

    @Test
    public void testPowerCurrent() {
        staticOhmPow.setPower("100");
        staticOhmPow.setCurrent("0.01");
        staticOhmPow.calculateAll(new boolean[]{true,false,false,true});
        assertEquals("1000000",staticOhmPow.getResistance());
        assertEquals("10000",staticOhmPow.getTension());
    }

    @Test
    public void testPowerVoltage() {
        staticOhmPow.setPower("3");
        staticOhmPow.setTension("5");
        staticOhmPow.calculateAll(new boolean[]{false,true,false,true});
        assertEquals("8.333",staticOhmPow.getResistance());
        assertEquals("0.6",staticOhmPow.getCurrent());
    }

    @Test
    public void testResistanceCurrent() {
        staticOhmPow.setResistance("3000");
        staticOhmPow.setCurrent("0.01");
        staticOhmPow.calculateAll(new boolean[]{true,false,true,false});
        assertEquals("30",staticOhmPow.getTension());
        assertEquals("0.3",staticOhmPow.getPower());
    }

    @Test
    public void testResistanceVoltage() {
        staticOhmPow.setResistance("1000");
        staticOhmPow.setTension("15");
        staticOhmPow.calculateAll(new boolean[]{false,true,true,false});
        assertEquals("0.015",staticOhmPow.getCurrent());
        assertEquals("0.225",staticOhmPow.getPower());
    }

    @Test
    public void testVoltageCurrent() {
        staticOhmPow.setCurrent("0.259");
        staticOhmPow.setTension("9");
        staticOhmPow.calculateAll(new boolean[]{true,true,false,false});
        assertEquals("34.749",staticOhmPow.getResistance());
        assertEquals("2.331",staticOhmPow.getPower());
    }

}
