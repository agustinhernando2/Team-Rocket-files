package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.Observer;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorGraph;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorInfo;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ValueSelector;

public class ValueSelectorTests {

    View mockView = Mockito.mock(View.class);
    LinearLayout mockedLayout = Mockito.mock(LinearLayout.class);
    Spinner mockedSpinner = Mockito.mock(Spinner.class);
    Observer mockObserver = Mockito.mock(ResistorGraph.class);
    ResistorInfo mockedResistorInfo = Mockito.mock(ResistorInfo.class);
    Context mockedContext = Mockito.mock(Context.class);

    @Before
    public void setupMockView() {
        Mockito.when(mockView.findViewById(R.id.resistorValueInput)).thenReturn(mockedLayout);
        Mockito.when(mockView.findViewById(R.id.inputStandardResistorDDB)).thenReturn(mockedSpinner);
        Mockito.when(mockView.getContext()).thenReturn(mockedContext);
    }

    @Ignore("The mocking of ArrayAdapter is still broken")
    @Test
    public void addObserversTest() {
        ValueSelector valueSelector = new ValueSelector(mockView);
        valueSelector.addObserver(mockObserver);
        valueSelector.notifyObservers(mockedResistorInfo);
        Mockito.doAnswer(invocation -> {
            Assert.assertEquals(invocation.getArgument(0), mockedResistorInfo);
            return null;
        }).when(mockObserver).update(mockedResistorInfo);
    }

}
