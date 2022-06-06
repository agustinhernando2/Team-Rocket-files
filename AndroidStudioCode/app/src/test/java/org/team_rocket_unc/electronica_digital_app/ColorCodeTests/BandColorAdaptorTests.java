package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.BandColorAdaptor;

public class BandColorAdaptorTests {


    @Test
    public void getNormalBandColorsTest() {
        Assert.assertEquals(10, BandColorAdaptor.getNormalBandColors().size());
    }

    @Test
    public void getPartialBandColorsTest() {
        Assert.assertEquals(7, BandColorAdaptor.getPartialBandColors().size());
    }

    @Test
    public void getSpecialBandColorsTest() {
        Assert.assertEquals(2, BandColorAdaptor.getSpecialBandColors().size());
    }

}
