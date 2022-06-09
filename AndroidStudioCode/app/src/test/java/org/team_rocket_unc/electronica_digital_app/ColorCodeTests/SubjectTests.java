package org.team_rocket_unc.electronica_digital_app.ColorCodeTests;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.reflect.Whitebox;
import org.team_rocket_unc.electronica_digital_app.R;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.Observer;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorGraph;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ResistorInfo;
import org.team_rocket_unc.electronica_digital_app.units.unit_2_color_code_resistor.ValueSelector;
import org.testng.mustache.Value;

@RunWith(MockitoJUnitRunner.class)
public class SubjectTests {

    @Mock
    View mockView;

    @Mock
    LinearLayout mockedLayout;

    @Mock
    Spinner mockedSpinner;

    @Mock
    Observer mockObserver;

    @Mock
    ResistorInfo mockedResistorInfo;

    @Mock
    Context mockedContext;

    @Before
    public void setupMockView() {
        Mockito.when(mockView.findViewById(R.id.resistorValueInput)).thenReturn(mockedLayout);
        Mockito.when(mockView.findViewById(R.id.inputStandardResistorDDB)).thenReturn(mockedSpinner);
        Mockito.when(mockView.getContext()).thenReturn(mockedContext);
    }

    @Ignore("The mocking of the View is broken")
    @Test
    public void addObserversTestAndNotify() {
        ValueSelector valueSelector = new ValueSelector(mockView);
        valueSelector.addObserver(mockObserver);
        valueSelector.notifyObservers(mockedResistorInfo);
        Mockito.doAnswer(invocation -> {
            Assert.assertEquals(invocation.getArgument(0), mockedResistorInfo);
            return null;
        }).when(mockObserver).update(mockedResistorInfo);
    }

    @Ignore("The mocking of the View is broken")
    @Test
    public void setVisibleTest() {
        ValueSelector valueSelector = new ValueSelector(mockView);
        int expectedVisibility = View.VISIBLE;
        valueSelector.setVisible(expectedVisibility);
        LinearLayout layout = (LinearLayout) Whitebox.getInternalState(valueSelector, "valueLayout");
        Assert.assertEquals(expectedVisibility, layout.getVisibility());
    }

}
