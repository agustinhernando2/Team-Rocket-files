package org.team_rocket_unc.electronica_digital_app.CalculatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm.OhmToolModel;

import java.util.Arrays;

public class OhmPow {
    OhmToolModel staticOhmPow = new OhmToolModel();

    @Test
    public void testPowerResistance() {
        staticOhmPow.setPower("600");
        staticOhmPow.setResistance("300");
        staticOhmPow.calculateAll(Arrays.asList(true,false,false,true));
        assertEquals("1.414",staticOhmPow.getCurrent());
        assertEquals("424.26",staticOhmPow.getTension());
    }

    @Test
    public void testPowerCurrent() {
        staticOhmPow.setPower("100");
        staticOhmPow.setCurrent("0.01");
        staticOhmPow.calculateAll(Arrays.asList(false,false,true,true));
        assertEquals("1000000",staticOhmPow.getResistance());
        assertEquals("10000.00",staticOhmPow.getTension());
    }

    @Test
    public void testPowerVoltage() {
        staticOhmPow.setPower("3");
        staticOhmPow.setTension("5");
        staticOhmPow.calculateAll(Arrays.asList(false,true,false,true));
        assertEquals("8",staticOhmPow.getResistance());
        assertEquals("0.600",staticOhmPow.getCurrent());
    }

    @Test
    public void testResistanceCurrent() {
        staticOhmPow.setResistance("3000");
        staticOhmPow.setCurrent("0.01");
        staticOhmPow.calculateAll(Arrays.asList(true,false,true,false));
        assertEquals("30.00",staticOhmPow.getTension());
        assertEquals("0.30",staticOhmPow.getPower());
    }

    @Test
    public void testResistanceVoltage() {
        staticOhmPow.setResistance("1000");
        staticOhmPow.setTension("15");
        staticOhmPow.calculateAll(Arrays.asList(true,true,false,false));
        assertEquals("0.015",staticOhmPow.getCurrent());
        assertEquals("0.23",staticOhmPow.getPower());
    }

    @Test
    public void testVoltageCurrent() {
        staticOhmPow.setCurrent("0.259");
        staticOhmPow.setTension("9");
        staticOhmPow.calculateAll(Arrays.asList(false,true,true,false));
        assertEquals("35",staticOhmPow.getResistance());
        assertEquals("2.33",staticOhmPow.getPower());
    }

}
