package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;


import android.content.Context;
import android.graphics.Paint;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorGraph;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorInfo;

@RunWith(MockitoJUnitRunner.class)
public class ObserverTests {

    @Mock
    Context mockContext;

    @Ignore("Mock context is broken")
    @Test
    public void updateTest() {
        Mockito.when(mockContext.getResources()).thenReturn(null);
        ResistorGraph resistorGraph = new ResistorGraph(mockContext);
        ResistorInfo resistor = new ResistorInfo("220\u03A9 \u00B110%");
        resistorGraph.update(resistor);
        Paint band1Paint = (Paint)Whitebox.getInternalState(resistorGraph, "band1Paint");
        Paint band2Paint = (Paint)Whitebox.getInternalState(resistorGraph, "band2Paint");
        Paint band3Paint = (Paint)Whitebox.getInternalState(resistorGraph, "band3Paint");
        Paint band4Paint = (Paint)Whitebox.getInternalState(resistorGraph, "band4Paint");
        Assert.assertEquals(mockContext.getResources().getColor(R.color.RED), band1Paint.getColor());
        Assert.assertEquals(mockContext.getResources().getColor(R.color.RED), band2Paint.getColor());
        Assert.assertEquals(mockContext.getResources().getColor(R.color.BROWN), band3Paint.getColor());
        Assert.assertEquals(mockContext.getResources().getColor(R.color.SILVER), band4Paint.getColor());
    }


}
