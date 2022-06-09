package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.BandColorAdaptor;

import java.util.List;

public class BandColorAdaptorTests {


    @Test
    public void getFirstBandColorsTest() {
        List<Integer> bandColorAdaptor = BandColorAdaptor.getFirstBandColors();
        Assert.assertEquals(9, bandColorAdaptor.size());
        Assert.assertEquals(R.color.BROWN, (int)bandColorAdaptor.get(0));
        Assert.assertEquals(R.color.WHITE, (int)bandColorAdaptor.get(8));
    }

    @Test
    public void getSecondBandColorsTest() {
        List<Integer> bandColorAdaptor = BandColorAdaptor.getSecondBandColors();
        Assert.assertEquals(10, bandColorAdaptor.size());
        Assert.assertEquals(R.color.black, (int) bandColorAdaptor.get(0));
        Assert.assertEquals(R.color.WHITE, (int) bandColorAdaptor.get(9));
    }

    @Test
    public void getPartialBandColorsTest() {
        List<Integer> bandColorAdaptor = BandColorAdaptor.getPartialBandColors();
        Assert.assertEquals(7, bandColorAdaptor.size());
        Assert.assertEquals(R.color.black, (int) bandColorAdaptor.get(0));
        Assert.assertEquals(R.color.BLUE, (int) bandColorAdaptor.get(6));
    }

    @Test
    public void getSpecialBandColorsTest() {
        List<Integer> bandColorAdaptor = BandColorAdaptor.getSpecialBandColors();
        Assert.assertEquals(2, bandColorAdaptor.size());
        Assert.assertEquals(R.color.GOLD, (int) bandColorAdaptor.get(0));
        Assert.assertEquals(R.color.SILVER, (int) bandColorAdaptor.get(1));
    }

}
