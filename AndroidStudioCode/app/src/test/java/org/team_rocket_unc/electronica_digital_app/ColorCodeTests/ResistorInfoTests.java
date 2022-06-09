package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorInfo;

public class ResistorInfoTests {

    @Test
    public void resistorInfoColorConstructorTest() {
        //220 Ohm
        ResistorInfo resistorInfo = new ResistorInfo(R.color.RED, R.color.RED, R.color.BROWN, R.color.SILVER);
        Assert.assertEquals("220\u03A9 \u00B110%", resistorInfo.getValue());
        //330 Ohm
        resistorInfo = new ResistorInfo(R.color.ORANGE, R.color.ORANGE, R.color.BROWN, R.color.GOLD);
        Assert.assertEquals("330\u03A9 \u00B15%", resistorInfo.getValue());
        //1k Ohm
        resistorInfo = new ResistorInfo(R.color.BROWN, R.color.black, R.color.RED, R.color.SILVER);
        Assert.assertEquals("1k\u03A9 \u00B110%", resistorInfo.getValue());
        //4k7 Ohm
        resistorInfo = new ResistorInfo(R.color.YELLOW, R.color.VIOLET, R.color.RED, R.color.GOLD);
        Assert.assertEquals("4.7k\u03A9 \u00B15%", resistorInfo.getValue());
        //5k6 Ohm
        resistorInfo = new ResistorInfo(R.color.GREEN, R.color.BLUE, R.color.RED, R.color.SILVER);
        Assert.assertEquals("5.6k\u03A9 \u00B110%", resistorInfo.getValue());
        //8k2 Ohm
        resistorInfo = new ResistorInfo(R.color.GRAY, R.color.RED, R.color.RED, R.color.SILVER);
        Assert.assertEquals("8.2k\u03A9 \u00B110%", resistorInfo.getValue());
        //39k Ohm
        resistorInfo = new ResistorInfo(R.color.ORANGE, R.color.WHITE, R.color.ORANGE, R.color.GOLD);
        Assert.assertEquals("39k\u03A9 \u00B15%", resistorInfo.getValue());
        //1M Ohm
        resistorInfo = new ResistorInfo(R.color.BROWN, R.color.black, R.color.GREEN, R.color.GOLD);
        Assert.assertEquals("1M\u03A9 \u00B15%", resistorInfo.getValue());
    }

    @Test
    public void resistorInfoValueConstructorTest() {
        //150 Ohm
        ResistorInfo resistorInfo = new ResistorInfo("150\u03A9 \u00B15%");
        Assert.assertEquals(R.color.BROWN, resistorInfo.getBand1());
        Assert.assertEquals(R.color.GREEN, resistorInfo.getBand2());
        Assert.assertEquals(R.color.BROWN, resistorInfo.getBand3());
        Assert.assertEquals(R.color.GOLD, resistorInfo.getBand4());

        //1.8k Ohm
        resistorInfo = new ResistorInfo("1.8k\u03A9 \u00B110%");
        Assert.assertEquals(R.color.BROWN, resistorInfo.getBand1());
        Assert.assertEquals(R.color.GRAY, resistorInfo.getBand2());
        Assert.assertEquals(R.color.RED, resistorInfo.getBand3());
        Assert.assertEquals(R.color.SILVER, resistorInfo.getBand4());

        //2.7k Ohm
        resistorInfo = new ResistorInfo("2.7k\u03A9 \u00B110%");
        Assert.assertEquals(R.color.RED, resistorInfo.getBand1());
        Assert.assertEquals(R.color.VIOLET, resistorInfo.getBand2());
        Assert.assertEquals(R.color.RED, resistorInfo.getBand3());
        Assert.assertEquals(R.color.SILVER, resistorInfo.getBand4());

        //6.8k Ohm
        resistorInfo = new ResistorInfo("6.8k\u03A9 \u00B15%");
        Assert.assertEquals(R.color.BLUE, resistorInfo.getBand1());
        Assert.assertEquals(R.color.GRAY, resistorInfo.getBand2());
        Assert.assertEquals(R.color.RED, resistorInfo.getBand3());
        Assert.assertEquals(R.color.GOLD, resistorInfo.getBand4());

        //10k Ohm
        resistorInfo = new ResistorInfo("10k\u03A9 \u00B15%");
        Assert.assertEquals(R.color.BROWN, resistorInfo.getBand1());
        Assert.assertEquals(R.color.black, resistorInfo.getBand2());
        Assert.assertEquals(R.color.ORANGE, resistorInfo.getBand3());
        Assert.assertEquals(R.color.GOLD, resistorInfo.getBand4());

        //22k Ohm
        resistorInfo = new ResistorInfo("22k\u03A9 \u00B110%");
        Assert.assertEquals(R.color.RED, resistorInfo.getBand1());
        Assert.assertEquals(R.color.RED, resistorInfo.getBand2());
        Assert.assertEquals(R.color.ORANGE, resistorInfo.getBand3());
        Assert.assertEquals(R.color.SILVER, resistorInfo.getBand4());

        //100K Ohm
        resistorInfo = new ResistorInfo("100k\u03A9 \u00B110%");
        Assert.assertEquals(R.color.BROWN, resistorInfo.getBand1());
        Assert.assertEquals(R.color.black, resistorInfo.getBand2());
        Assert.assertEquals(R.color.YELLOW, resistorInfo.getBand3());
        Assert.assertEquals(R.color.SILVER, resistorInfo.getBand4());

        //470k Ohm
        resistorInfo = new ResistorInfo("470k\u03A9 \u00B15%");
        Assert.assertEquals(R.color.YELLOW, resistorInfo.getBand1());
        Assert.assertEquals(R.color.VIOLET, resistorInfo.getBand2());
        Assert.assertEquals(R.color.YELLOW, resistorInfo.getBand3());
        Assert.assertEquals(R.color.GOLD, resistorInfo.getBand4());
    }

}
