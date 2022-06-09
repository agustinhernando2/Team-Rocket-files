package org.team_rocket_unc.electronica_digital_app.CalculatorTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p3_led.LedCircuitToolModel;

public class Led {
    LedCircuitToolModel staticLed = new LedCircuitToolModel();

    @Test
    public void calculateResistance() {
        staticLed.setLedTension(2);
        staticLed.calculate("0.02", "5");
        assertEquals("130", staticLed.getResistance());
    }

    @Test
    public void checkColorSelector() {
        staticLed.setLedTension(4);
        assertEquals("3.4", staticLed.getLedTension());
    }
}
