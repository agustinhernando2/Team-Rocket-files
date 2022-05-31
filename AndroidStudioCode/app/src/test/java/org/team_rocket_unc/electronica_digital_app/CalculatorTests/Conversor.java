package org.team_rocket_unc.electronica_digital_app.CalculatorTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p1_conversion.ConversionToolModel;

public class Conversor {
    ConversionToolModel staticConversion = new ConversionToolModel();

    @Test
    public void testBinaryInput() {
        staticConversion.setConversionBase(0);
        staticConversion.updateInput("1111");
        assertEquals("1111",staticConversion.getOutput().getBinaryOutput());
        assertEquals("15",staticConversion.getOutput().getDecimalOutput());
        assertEquals("F",staticConversion.getOutput().getHexOutput());
    }

    @Test
    public void testDecimalInput() {
        staticConversion.setConversionBase(1);
        staticConversion.updateInput("256");
        assertEquals("100000000",staticConversion.getOutput().getBinaryOutput());
        assertEquals("256",staticConversion.getOutput().getDecimalOutput());
        assertEquals("100",staticConversion.getOutput().getHexOutput());
    }

    @Test
    public void testHexaInput() {
        staticConversion.setConversionBase(2);
        staticConversion.updateInput("F5");
        assertEquals("11110101",staticConversion.getOutput().getBinaryOutput());
        assertEquals("245",staticConversion.getOutput().getDecimalOutput());
        assertEquals("F5",staticConversion.getOutput().getHexOutput());
    }

    @Test
    public void testInputForbiddenBinary() {
        staticConversion.setConversionBase(0);
        NumberFormatException exception = null;
        try {
            staticConversion.updateInput("50");
        } catch (NumberFormatException e){
            exception=e;
        }

        assertNotNull(exception);
    }

    @Test
    public void testInputForbiddenDecimal() {
        staticConversion.setConversionBase(1);
        NumberFormatException exception = null;
        try {
            staticConversion.updateInput("ZV");
        } catch (NumberFormatException e){
            exception=e;
        }

        assertNotNull(exception);
    }

    @Test
    public void testInputForbiddenHexa() {
        staticConversion.setConversionBase(2);
        NumberFormatException exception = null;
        try {
            staticConversion.updateInput("24Y");
        } catch (NumberFormatException e){
            exception=e;
        }

        assertNotNull(exception);
    }

    @Test
    public void testForbiddenCharacters() {
        NumberFormatException exception = null;
        try {
            staticConversion.updateInput(" + *");
        } catch (NumberFormatException e){
            exception=e;
        }

        assertNotNull(exception);
    }

}
